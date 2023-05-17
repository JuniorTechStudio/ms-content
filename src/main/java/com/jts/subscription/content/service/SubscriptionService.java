package com.jts.subscription.content.service;

import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.data.dto.PreparedSubscriptionContent;
import com.jts.subscription.content.data.dto.SubscriptionUserInfoDTO;
import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import com.jts.subscription.content.repository.TextRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final TextRepository textRepository;

    public TelegramSendContentRequest prepareContentBySubscriptionTitleAndOrder(PrepareAndSendContentRequest request) {
        var preparedSubscriptionContentList = request.getSubscriptionUserInfoDTOList()
                .stream()
                .map(this::createPreparedSubscriptionContent)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new TelegramSendContentRequest(preparedSubscriptionContentList);
    }

    private PreparedSubscriptionContent createPreparedSubscriptionContent(SubscriptionUserInfoDTO userInfo) {
        var subscriptionTitle = userInfo.getSubscriptionTitle();
        var order = userInfo.getOrder();
        return textRepository.findContentBySubscriptionTitleAndOrder(subscriptionTitle, order)
                .map(text -> new PreparedSubscriptionContent(userInfo.getTelegramId(), text.getContent()))
                .orElseGet(() -> {
                    log.warn("Content with subscription title {} and order {} NOT FOUND", subscriptionTitle, order);
                    return null;
                });
    }

}
