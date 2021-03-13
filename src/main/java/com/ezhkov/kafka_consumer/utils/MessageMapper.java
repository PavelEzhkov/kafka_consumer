package com.ezhkov.kafka_consumer.utils;

import com.ezhkov.kafka_consumer.dto.MessageDTO;
import com.ezhkov.kafka_consumer.entity.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageMapper {

    public Message messageDTOToEntity(MessageDTO dto, LocalDateTime dateTime) {
        return Message.builder().word(dto.getWord()).date(dateTime).build();
    }
}
