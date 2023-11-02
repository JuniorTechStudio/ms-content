package com.ts.subscription.content.repository;

import com.ts.subscription.content.data.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TextRepository extends JpaRepository<Text, UUID> {

    Optional<Text> findBySubscriptionIdAndOrderNumber(UUID subscriptionId, Integer orderNumber);

    List<Text> findAllBySubscriptionId(UUID subscriptionId);

}
