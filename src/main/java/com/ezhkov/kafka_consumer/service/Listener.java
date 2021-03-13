package com.ezhkov.kafka_consumer.service;

import com.ezhkov.kafka_consumer.dto.MessageDTO;
import com.ezhkov.kafka_consumer.entity.Message;
import com.ezhkov.kafka_consumer.utils.MessageMapper;
import lombok.Setter;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Component
@Setter
public class Listener {

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = "word", containerFactory = "kafkaListenerContainerFactory")
    public void listener(ConsumerRecord<String, MessageDTO> message) {

        LocalDateTime date =  LocalDateTime.ofInstant(Instant.ofEpochMilli(message.timestamp()),
                TimeZone.getDefault().toZoneId());
        Message value =  messageMapper.messageDTOToEntity(message.value(), date);

        Message savedMessage = messageService.save(value);

        System.out.println(savedMessage); //only to show result of db writing

    }
}
