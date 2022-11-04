package com.jts.subscription.content.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class SubscriptionUserInfoDTO {
    private String telegramId;
    private UUID subscriptionId;
    private Integer order;
}
