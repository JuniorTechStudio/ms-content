package com.jts.subscription.content.data.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreparedSubscriptionContent {
    private String telegramId;
    private String content;
}
