package com.jts.subscription.content.facade;

import com.jts.subscription.content.client.TelegramAdapterClient;
import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.service.SubscriptionService;
import com.jts.subscription.content.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionFacade {

    private final WordService wordService;
    private final SubscriptionService subscriptionService;
    private final TelegramAdapterClient telegramAdapterClient;

    public void prepareAndSendContentBySubscriptionTitleAndOrder(PrepareAndSendContentRequest request) {
        var telegramSendContentRequest = subscriptionService.prepareContentBySubscriptionTitleAndOrder(request);
        telegramAdapterClient.sendPreparedContent(telegramSendContentRequest);
    }

    public void prepareAndSendRandomWordByUserInfo(PrepareAndSendContentRequest request) {
        var telegramSendContentRequest = wordService.prepareRandomWordByUserInfo(request);
        telegramAdapterClient.sendPreparedContent(telegramSendContentRequest);
    }

}
