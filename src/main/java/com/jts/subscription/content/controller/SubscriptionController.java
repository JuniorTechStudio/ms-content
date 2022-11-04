package com.jts.subscription.content.controller;

import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.data.dto.PreparedSubscriptionContent;
import com.jts.subscription.content.data.entity.Content;
import com.jts.subscription.content.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public void prepareContent(@RequestBody PrepareAndSendContentRequest prepareAndSendContentRequest) {
        List<PreparedSubscriptionContent> preparedSubscriptionContentList = subscriptionService.prepareContentForSubscription(prepareAndSendContentRequest);
        subscriptionService.sendPreparedContent(preparedSubscriptionContentList);
    }

}
