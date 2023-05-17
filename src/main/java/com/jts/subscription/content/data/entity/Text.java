package com.jts.subscription.content.data.entity;

import com.jts.subscription.content.data.enums.ContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

    @Column(name = "subscription_title")
    private String subscriptionTitle;

    @Column(name = "order_number")
    private Integer order;

    @Override
    public ContentType getType() {
        return ContentType.TEXT;
    }

}
