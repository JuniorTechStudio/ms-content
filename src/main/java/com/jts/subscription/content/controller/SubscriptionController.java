package com.jts.subscription.content.controller;

import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.facade.SubscriptionFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionFacade subscriptionFacade;

    @PostMapping("/send")
    public void prepareAndSendContent(@RequestBody PrepareAndSendContentRequest request) {
        subscriptionFacade.prepareAndSendContent(request);
    }

}

