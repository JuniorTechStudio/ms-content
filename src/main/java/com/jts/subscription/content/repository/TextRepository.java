package com.jts.subscription.content.repository;

import com.jts.subscription.content.data.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TextRepository extends JpaRepository<Text, UUID> {

    Optional<Text> findContentBySubscriptionTitleAndOrder(String subscriptionTitle, Integer order);

}
