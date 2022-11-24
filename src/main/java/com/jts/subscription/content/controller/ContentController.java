package com.jts.subscription.content.controller;

import com.jts.subscription.content.client.TelegramAdapterClient;
import com.jts.subscription.content.data.entity.Content;
import com.jts.subscription.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;
    private final TelegramAdapterClient telegramAdapterClient;

    @GetMapping("/{text}")
    public void getContent(@PathVariable String text) {
    }

    @PostMapping
    public Content createContent(@RequestBody Content content) {
        return contentService.createContent(content);
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable UUID id) {
        contentService.deleteContent(id);
    }

    @PutMapping
    public Content updateContent(@RequestBody Content content) {
        return contentService.updateContent(content);
    }

    @PostMapping("/send/{text}")
    public void sendMessege(@PathVariable String text){
        telegramAdapterClient.sendMessage(text);
    }
}
