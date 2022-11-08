package com.jts.subscription.content.repository;

import com.jts.subscription.content.data.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContentRepository extends JpaRepository<Content, UUID> {

    Optional<Content> findBySubscriptionIdAndOrder(UUID subscriptionId, Integer order);
}
