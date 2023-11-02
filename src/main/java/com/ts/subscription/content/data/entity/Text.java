package com.ts.subscription.content.data.entity;

import com.ts.subscription.content.data.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity(name = "Text")
@Table(schema = "content", name = "text")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Text implements Content {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "content")
    private String content;

    @Column(name = "subscription_id")
    private UUID subscriptionId;

    @Column(name = "subscription_title")
    private String subscriptionTitle;

    @Column(name = "order_number")
    private int orderNumber;

    @Override
    public ContentType getType() {
        return ContentType.TEXT;
    }

}
