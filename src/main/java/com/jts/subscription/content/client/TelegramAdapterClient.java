package com.jts.subscription.content.client;

import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ms-telegram-adapter", url = "http://localhost:8080/JTSBot")
public interface TelegramAdapterClient {

   @RequestMapping(value = "/{text}", method = RequestMethod.POST)
   void sendMessage(@PathVariable String text);

   @RequestMapping(value = "/subscription", method = RequestMethod.POST)
   void sendPreparedContent(@RequestBody TelegramSendContentRequest telegramSendContentRequest);
}
