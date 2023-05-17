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
@RequestMapping("/word")
public class WordController {

    private final SubscriptionFacade subscriptionFacade;

    @PostMapping("/send/random")
    public void updateContent(@RequestBody PrepareAndSendContentRequest request) {
        subscriptionFacade.prepareAndSendRandomWordByUserInfo(request);
    }

}
