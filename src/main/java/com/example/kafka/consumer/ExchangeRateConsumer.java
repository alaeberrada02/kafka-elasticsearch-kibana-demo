package com.example.kafka.consumer;

import com.example.kafka.model.ExchangeRate;
import com.example.kafka.repository.ExchangeRateRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateConsumer {

    private final ExchangeRateRepository repository;

    public ExchangeRateConsumer(ExchangeRateRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "exchange-rate", groupId = "group_id")
    public void consume(ExchangeRate rate) {
        System.out.println("✅ Consumed from Kafka: " + rate);
        repository.save(rate);
        System.out.println("✅ Indexed to Elasticsearch: " + rate);
    }
}
