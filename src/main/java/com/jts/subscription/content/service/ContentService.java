package com.jts.subscription.content.service;

import com.jts.subscription.content.data.entity.Content;
import com.jts.subscription.content.exeption.EntityNotFoundException;
import com.jts.subscription.content.exeption.ErrorCode;
import com.jts.subscription.content.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Content updateContent(Content content) {
        Content tempContent = findContentById(content.getId());
        tempContent.setContent(content.getContent());
        return tempContent;
    }

    public Content findContentById(UUID id) {
        return contentRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                String.format("Content with id: %s not found", id),
                                ErrorCode.CONTENT_NOT_FOUND
                        )
                );
    }

}
