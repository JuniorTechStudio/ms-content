package com.jts.subscription.content.controller;

import com.jts.subscription.content.client.ContentClient;
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
    private final ContentClient contentClient;

    @GetMapping("/{id}")
    public Content getContent(@PathVariable UUID id) {
        return contentService.getContent(id);
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

    @PostMapping("/jopa/{text}")
    public void jopa(@PathVariable String text){
        contentClient.sendMessage(text);
    }
}
