package com.ts.subscription.content.service;

import com.ts.subscription.content.data.dto.AllSubscriptionContent;
import com.ts.subscription.content.data.dto.ContentCreateRequest;
import com.ts.subscription.content.data.dto.ContentCreateResponse;
import com.ts.subscription.content.data.dto.ContentValue;
import com.ts.subscription.content.data.entity.Text;
import com.ts.subscription.content.data.mapper.ContentMapper;
import com.ts.subscription.content.exeption.EntityNotFoundException;
import com.ts.subscription.content.exeption.ErrorCode;
import com.ts.subscription.content.repository.TextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TextService {

    private final TextRepository textRepository;
    private final ContentMapper contentMapper;

    public ContentCreateResponse createContent(UUID subscriptionId, ContentCreateRequest request) {
        var text = contentMapper.toText(subscriptionId, request);
        var savedContent = textRepository.save(text);
        return contentMapper.toContentCreateResponse(savedContent);
    }

//    public void deleteContent(UUID id) {
//        textRepository.deleteById(id);
//    }

//    @Transactional
//    public Text updateContent(Text text) {
//        Text tempText = findTextById(text.getId());
//        tempText.setContent(text.getContent());
//        return tempText;
//    }

    public Text findTextById(UUID id) {
        return textRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Text with id: %s not found", id),
                        ErrorCode.CONTENT_NOT_FOUND
                ));
    }

    public ContentValue getContentByOrderNumber(UUID subscriptionId, int orderNumber) {
        Text text = textRepository.findBySubscriptionIdAndOrderNumber(subscriptionId, orderNumber)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Text with subscription title: %s and order number: %d not found", subscriptionId, orderNumber),
                        ErrorCode.CONTENT_BY_SUBSCRIPTION_AND_ORDER_NOT_FOUND));
        return new ContentValue(text.getContent());
    }

    public AllSubscriptionContent findAllContentBySubscriptionId(UUID subscriptionId) {
        var contentList = textRepository.findAllBySubscriptionId(subscriptionId);
        var contentWithOrderNumberList = contentMapper.toContentWithOrderNumberList(contentList);
        return new AllSubscriptionContent(contentWithOrderNumberList);
    }

}
