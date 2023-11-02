package com.ts.subscription.content.data.dto;

import java.util.UUID;

public record ContentCreateResponse(UUID subscriptionId, String subscriptionTitle, String content, int orderNumber) {
}
