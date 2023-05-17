package com.jts.subscription.content.service;


import com.jts.subscription.content.client.TelegramAdapterClient;
import com.jts.subscription.content.data.dto.PrepareAndSendContentRequest;
import com.jts.subscription.content.data.dto.PreparedSubscriptionContent;
import com.jts.subscription.content.data.dto.TelegramSendContentRequest;
import com.jts.subscription.content.data.entity.Word;
import com.jts.subscription.content.exeption.EntityNotFoundException;
import com.jts.subscription.content.exeption.ErrorCode;
import com.jts.subscription.content.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;
    private final TelegramAdapterClient telegramAdapterClient;

    public Word findWordById(UUID id) {
        return wordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Word with id: %s not found", id),
                        ErrorCode.CONTENT_NOT_FOUND
                ));
    }

    public TelegramSendContentRequest prepareRandomWordByUserInfo(PrepareAndSendContentRequest request) {
//        var randomWord = wordRepository.getRandomWord();
        var randomWord = new Word(null, "test", "test");
        var content = randomWord.getEnValue() + " - " + randomWord.getRuValue();
        var preparedSubscriptionContentList = request.getSubscriptionUserInfoDTOList()
                .stream()
                .map(userInfo -> new PreparedSubscriptionContent(userInfo.getTelegramId(), content))
                .collect(Collectors.toList());
        return new TelegramSendContentRequest(preparedSubscriptionContentList);
    }

}
