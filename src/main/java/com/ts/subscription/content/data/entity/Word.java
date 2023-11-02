package com.ts.subscription.content.data.entity;

import com.ts.subscription.content.data.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity(name = "Word")
@Table(schema = "content", name = "word")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Word implements Content {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "ru_value")
    private String ruValue;

    @Column(name = "en_value")
    private String enValue;

    @Override
    public ContentType getType() {
        return ContentType.WORD;
    }

}
