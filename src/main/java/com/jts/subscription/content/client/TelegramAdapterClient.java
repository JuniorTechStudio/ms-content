package com.jts.subscription.content.client;

import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-telegram-adapter", url = "http://localhost:8080/")
public interface TelegramAdapterClient {

   @PostMapping("telegram/send")
   void sendPreparedContent(@RequestBody TelegramSendContentRequest request);

}
