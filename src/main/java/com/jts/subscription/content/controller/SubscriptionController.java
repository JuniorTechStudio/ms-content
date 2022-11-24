package com.jts.subscription.content.controller;

import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.facade.SubscriptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionFacade subscriptionFacade;

    @PostMapping
    public void prepareContent(@RequestBody PrepareAndSendContentRequest prepareAndSendContentRequest) {
        subscriptionFacade.prepareAndSendContent(prepareAndSendContentRequest);
    }

}
