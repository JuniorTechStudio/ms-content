package com.jts.subscription.content.service;

import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.data.dto.PreparedSubscriptionContent;
import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import com.jts.subscription.content.data.entity.Content;
import com.jts.subscription.content.data.dto.SubscriptionUserInfoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;
@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final ContentService contentService;

    public TelegramSendContentRequest prepareContentForSubscription(PrepareAndSendContentRequest request) {
        var preparedSubscriptionContentList = request.getSubscriptionUserInfoDTOList()
                .stream()
                .map(this::createPreparedSubscriptionContent)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new TelegramSendContentRequest(preparedSubscriptionContentList);
    }

    private PreparedSubscriptionContent createPreparedSubscriptionContent(SubscriptionUserInfoDTO userInfo) {
        try {
            Content content = contentService.findContentBySubscriptionTitleAndOrder(
                    userInfo.getSubscriptionTitle(), userInfo.getOrder()
            );
            return new PreparedSubscriptionContent(userInfo.getTelegramId(), content.getContent());
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
