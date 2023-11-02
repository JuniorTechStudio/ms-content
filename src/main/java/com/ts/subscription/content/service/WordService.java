package com.ts.subscription.content.service;

import com.ts.subscription.content.data.entity.Word;
import com.ts.subscription.content.exeption.EntityNotFoundException;
import com.ts.subscription.content.exeption.ErrorCode;
import com.ts.subscription.content.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

//    public TelegramSendContentRequest prepareRandomWordByUserInfo(PrepareAndSendContentRequest request) {
//        var randomWord = wordRepository.getRandomWord();
//        var content = randomWord.getEnValue() + " - " + randomWord.getRuValue();
//        var preparedSubscriptionContentList = request.getSubscriptionUserInfoDTOList()
//                .stream()
//                .map(userInfo -> new PreparedSubscriptionContent(userInfo.getTelegramId(), content))
//                .collect(Collectors.toList());
//        return new TelegramSendContentRequest(preparedSubscriptionContentList);
//    }

    public Word findWordById(UUID id) {
        return wordRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Word with id: %s not found", id),
                        ErrorCode.CONTENT_NOT_FOUND
                ));
    }

}
