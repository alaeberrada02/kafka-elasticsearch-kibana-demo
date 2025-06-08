package com.example.kafka.service;

import com.example.kafka.model.ExchangeRate;
import com.example.kafka.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
public class ExchangeRateService {

    private final WebClient webClient;
    private final ExchangeRateRepository repository;

    @Value("${exchange.api.url}")
    private String apiUrl;

    public ExchangeRateService(WebClient.Builder webClientBuilder, ExchangeRateRepository repository) {
        this.webClient = webClientBuilder.baseUrl(apiUrl).build();
        this.repository = repository;
    }

    public Flux<ExchangeRate> fetchExchangeRates() {
        return webClient.get()
                .retrieve()
                .bodyToMono(Map.class)
                .flatMapMany(json -> {
                    String base = (String) json.get("base");
                    Map<String, Double> rates = (Map<String, Double>) json.get("rates");

                    return Flux.fromIterable(rates.entrySet())
                            .map(entry -> {
                                ExchangeRate rate = new ExchangeRate();
                                rate.setId(UUID.randomUUID().toString());
                                rate.setSource(base);
                                rate.setTarget(entry.getKey());
                                rate.setRate(entry.getValue());
                                rate.setTimestamp(LocalDateTime.now());

                                // Sauvegarde dans Elasticsearch
                                repository.save(rate);

                                return rate;
                            });
                });
    }
}
