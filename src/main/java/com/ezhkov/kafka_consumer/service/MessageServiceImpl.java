package com.ezhkov.kafka_consumer.service;

import com.ezhkov.kafka_consumer.entity.Message;
import com.ezhkov.kafka_consumer.repository.MessageRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Setter
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}
