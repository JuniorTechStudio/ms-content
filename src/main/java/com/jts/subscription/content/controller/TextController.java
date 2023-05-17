package com.jts.subscription.content.controller;

import com.jts.subscription.content.data.entity.Text;
import com.jts.subscription.content.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/content")
public class TextController {

    private final TextService textService;

    @GetMapping("/{text}")
    public void getContent(@PathVariable String text) {
    }

    @PostMapping
    public Text createContent(@RequestBody Text text) {
        return textService.createContent(text);
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable UUID id) {
        textService.deleteContent(id);
    }

}
