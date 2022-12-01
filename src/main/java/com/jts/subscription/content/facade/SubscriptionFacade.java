package com.jts.subscription.content.facade;

import com.jts.subscription.content.client.TelegramAdapterClient;
import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.service.SubscriptionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubscriptionFacade {

    private final SubscriptionService subscriptionService;
    private final TelegramAdapterClient telegramAdapterClient;

    public void prepareAndSendContent(PrepareAndSendContentRequest request) {
        var telegramSendContentRequest = subscriptionService.prepareContentForSubscription(request);
        telegramAdapterClient.sendPreparedContent(telegramSendContentRequest);
    }

}
