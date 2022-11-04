package com.jts.subscription.content.service;

import com.jts.subscription.content.client.TelegramAdapterClient;
import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.data.dto.PreparedSubscriptionContent;
import com.jts.subscription.content.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import com.jts.subscription.content.data.entity.Content;
import com.jts.subscription.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final ContentRepository contentRepository;
    private final TelegramAdapterClient telegramAdapterClient;

    public List<PreparedSubscriptionContent> prepareContentForSubscription(PrepareAndSendContentRequest prepareAndSendContentRequest) {
        List<PreparedSubscriptionContent> preparedSubscriptionContentList = new ArrayList<>();
        List<SubscriptionUserInfoDTO> subscriptionUserInfoDTOList = prepareAndSendContentRequest.getSubscriptionUserInfoDTOList();
        for (SubscriptionUserInfoDTO subscriptionUserInfoDTO : subscriptionUserInfoDTOList) {
            UUID subscriptionId = subscriptionUserInfoDTO.getSubscriptionId();
            Integer order = subscriptionUserInfoDTO.getOrder();
            Optional<Content> contentOptional = contentRepository.findBySubscriptionIdAndOrder(subscriptionId, order);
            Content content = contentOptional.orElseThrow();
            String telegramId = subscriptionUserInfoDTO.getTelegramId();
            PreparedSubscriptionContent preparedSubscriptionContent = new PreparedSubscriptionContent(telegramId, content.getContent());
            preparedSubscriptionContentList.add(preparedSubscriptionContent);
        }
        return preparedSubscriptionContentList;
    }

    public void sendPreparedContent(List<PreparedSubscriptionContent> preparedSubscriptionContentList) {
        TelegramSendContentRequest telegramSendContentRequest = TelegramSendContentRequest
                .builder()
                .preparedSubscriptionContentList(preparedSubscriptionContentList)
                .build();
        telegramAdapterClient.sendPreparedContent(telegramSendContentRequest);
    }

}
