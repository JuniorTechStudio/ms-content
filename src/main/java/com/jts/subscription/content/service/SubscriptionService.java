package com.jts.subscription.content.service;

import com.jts.subscription.content.client.TelegramAdapterClient;
import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.data.dto.PreparedSubscriptionContent;
import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import com.jts.subscription.content.data.entity.Content;
import com.jts.subscription.content.exeption.EntityNotFoundException;
import com.jts.subscription.content.exeption.ErrorCode;
import com.jts.subscription.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final ContentRepository contentRepository;
    private final TelegramAdapterClient telegramAdapterClient;

    public List<PreparedSubscriptionContent> prepareContentForSubscription(PrepareAndSendContentRequest prepareAndSendContentRequest) {
        var preparedSubscriptionContentList = new ArrayList<PreparedSubscriptionContent>();
        prepareAndSendContentRequest.getSubscriptionUserInfoDTOList().forEach(
                subscriptionUserInfoDTO -> {
                    Content content = findContentBySubscriptionTitleAndOrder(
                            subscriptionUserInfoDTO.getSubscriptionTitle(),
                            subscriptionUserInfoDTO.getOrder()
                    );
                    String telegramId = subscriptionUserInfoDTO.getTelegramId();
                    var preparedSubscriptionContent = new PreparedSubscriptionContent(telegramId, content.getContent());
                    preparedSubscriptionContentList.add(preparedSubscriptionContent);
                }
        );
        return preparedSubscriptionContentList;
    }

    public void sendPreparedContent(List<PreparedSubscriptionContent> preparedSubscriptionContentList) {
        TelegramSendContentRequest telegramSendContentRequest = TelegramSendContentRequest
                .builder()
                .preparedSubscriptionContentList(preparedSubscriptionContentList)
                .build();
        telegramAdapterClient.sendPreparedContent(telegramSendContentRequest);
    }

    private Content findContentBySubscriptionTitleAndOrder(String subscriptionTitle, Integer order) {
        return contentRepository.findContentBySubscriptionTitleAndOrder(subscriptionTitle, order)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Content with subscriptionTitle: %s and order: %d not found", subscriptionTitle, order),
                                ErrorCode.SUBSCRIPTION_NOT_FOUND
                        )
                );
    }

}
