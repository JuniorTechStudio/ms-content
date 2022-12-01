package com.jts.subscription.content.service;

import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.data.dto.PreparedSubscriptionContent;
import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import com.jts.subscription.content.data.entity.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final ContentService contentService;

    public TelegramSendContentRequest prepareContentForSubscription(PrepareAndSendContentRequest request) {
        var preparedSubscriptionContentList = request.getSubscriptionUserInfoDTOList()
                .stream()
                .map(
                        subscriptionUserInfoDTO -> {
                            Content content = contentService.findContentBySubscriptionTitleAndOrder(
                                    subscriptionUserInfoDTO.getSubscriptionTitle(),
                                    subscriptionUserInfoDTO.getOrder()
                            );
                            return new PreparedSubscriptionContent(subscriptionUserInfoDTO.getTelegramId(), content.getContent());
                        }
                )
                .collect(Collectors.toList());
        return new TelegramSendContentRequest(preparedSubscriptionContentList);
    }

}
