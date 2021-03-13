package com.ezhkov.kafka_consumer.service;

import com.ezhkov.kafka_consumer.entity.Message;

public interface MessageService {
    Message save(Message message);
}
