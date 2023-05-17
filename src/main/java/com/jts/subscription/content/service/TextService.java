package com.jts.subscription.content.service;

import com.jts.subscription.content.data.entity.Text;
import com.jts.subscription.content.exeption.EntityNotFoundException;
import com.jts.subscription.content.exeption.ErrorCode;
import com.jts.subscription.content.repository.TextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TextService {

    private final TextRepository textRepository;

    public Text createContent(Text text) {
        return textRepository.save(text);
    }

    public void deleteContent(UUID id) {
        textRepository.deleteById(id);
    }

    @Transactional
    public Text updateContent(Text text) {
        Text tempText = findTextById(text.getId());
        tempText.setContent(text.getContent());
        return tempText;
    }

    public Text findTextById(UUID id) {
        return textRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Text with id: %s not found", id),
                        ErrorCode.CONTENT_NOT_FOUND
                ));
    }

    public Text findTextBySubscriptionTitleAndOrder(String subscriptionTitle, Integer order) {
        return textRepository.findContentBySubscriptionTitleAndOrder(subscriptionTitle, order)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Text with subscription title: %s and order number: %d not found", subscriptionTitle, order),
                        ErrorCode.CONTENT_BY_SUBSCRIPTION_AND_ORDER_NOT_FOUND
                ));
    }

}
