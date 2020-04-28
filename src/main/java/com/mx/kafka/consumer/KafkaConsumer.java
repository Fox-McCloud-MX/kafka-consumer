package com.mx.kafka.consumer;

import com.mx.kafka.config.KafkaConsumerConfig;
import com.mx.kafka.config.KafkaProducerConfig;
import com.mx.kafka.enity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {
    
    @KafkaListener(topics = "github-topic",
            containerGroup = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeUser(User user) {
        log.info(user.toString());
    }
}
