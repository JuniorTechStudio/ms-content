package com.ts.subscription.content.repository;

import com.ts.subscription.content.data.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface WordRepository extends JpaRepository<Word, UUID> {

    @Query(value = "SELECT * FROM content.word ORDER BY random() LIMIT 1", nativeQuery = true)
    Word getRandomWord();

}