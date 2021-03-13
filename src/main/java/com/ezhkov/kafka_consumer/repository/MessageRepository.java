package com.ezhkov.kafka_consumer.repository;

import com.ezhkov.kafka_consumer.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
