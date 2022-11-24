package com.jts.subscription.content.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionUserInfoDTO {
    private String telegramId;
    private String subscriptionTitle;
    private Integer order;
}
