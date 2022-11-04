package com.jts.subscription.content.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TelegramSendContentRequest {
    private List<PreparedSubscriptionContent> preparedSubscriptionContentList;
}
