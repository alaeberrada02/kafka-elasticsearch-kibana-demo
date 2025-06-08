package com.example.kafka.producer;

import com.example.kafka.model.ExchangeRate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateProducer {

    private final KafkaTemplate<String, ExchangeRate> kafkaTemplate;

    public ExchangeRateProducer(KafkaTemplate<String, ExchangeRate> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ExchangeRate exchangeRate) {
        kafkaTemplate.send("exchange-rates", exchangeRate.getId(), exchangeRate);
        System.out.println("✅ Message envoyé à Kafka : " + exchangeRate);
    }
}
