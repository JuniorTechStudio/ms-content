package com.jts.subscription.content.service;

import com.jts.subscription.content.data.entity.Content;
import com.jts.subscription.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public Content createContent(Content content) {
        return contentRepository.save(content);
    }

    public Content getContent(UUID id) {
        return contentRepository.findById(id).orElseThrow();
    }

    public void deleteContent(UUID id) {
        contentRepository.deleteById(id);
    }

    public Content updateContent(Content content) {
        UUID id = content.getId();
        Content tempContent = contentRepository.findById(id).orElseThrow();
        tempContent.setContent(content.getContent());
        return contentRepository.save(tempContent);
    }

}
