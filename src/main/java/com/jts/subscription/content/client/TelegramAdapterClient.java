package com.jts.subscription.content.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "botyara", url = "http://localhost:8080/JTSBot")
public interface TelegramAdapterClient {
   @RequestMapping(value = "/{text}", method = RequestMethod.POST)
   void sendMessage(@PathVariable String text);
}
