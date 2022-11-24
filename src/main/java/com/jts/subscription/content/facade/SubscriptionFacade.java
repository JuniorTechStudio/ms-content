package com.jts.subscription.content.facade;

import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.service.SubscriptionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SubscriptionFacade {

    private final SubscriptionService subscriptionService;

    public void prepareAndSendContent(PrepareAndSendContentRequest prepareAndSendContentRequest) {
        var preparedSubscriptionContentList = subscriptionService.prepareContentForSubscription(prepareAndSendContentRequest);
        subscriptionService.sendPreparedContent(preparedSubscriptionContentList);
    }

}
