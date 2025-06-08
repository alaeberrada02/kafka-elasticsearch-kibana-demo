package com.example.kafka.repository;

import com.example.kafka.model.ExchangeRate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends ElasticsearchRepository<ExchangeRate, String> {
}
