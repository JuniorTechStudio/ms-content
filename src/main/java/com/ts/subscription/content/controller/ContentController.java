package com.ts.subscription.content.controller;

import com.ts.subscription.content.data.dto.AllSubscriptionContent;
import com.ts.subscription.content.data.dto.ContentCreateRequest;
import com.ts.subscription.content.data.dto.ContentCreateResponse;
import com.ts.subscription.content.data.dto.ContentValue;
import com.ts.subscription.content.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class ContentController {

    private final TextService textService;

    @GetMapping("/{subscriptionId}/contents")
    public ResponseEntity<AllSubscriptionContent> getContents(@PathVariable UUID subscriptionId) {
        var allContentBySubscription = textService.findAllContentBySubscriptionId(subscriptionId);
        return ResponseEntity.ok(allContentBySubscription);
    }

    @GetMapping("/{subscriptionId}/contents")
    public ResponseEntity<ContentValue> getContentByOrderNumber(
            @PathVariable UUID subscriptionId,
            @RequestParam("orderNumber") Integer orderNumber
    ) {
        var contentValue = textService.getContentByOrderNumber(subscriptionId, orderNumber);
        return ResponseEntity.ok(contentValue);
    }

    @PostMapping("/{subscriptionId}/contents")
    public ResponseEntity<ContentCreateResponse> createContent(
            @PathVariable UUID subscriptionId,
            @RequestBody ContentCreateRequest request
    ) {
        var contentCreateResponse = textService.createContent(subscriptionId, request);
        return ResponseEntity.ok(contentCreateResponse);
    }

}
