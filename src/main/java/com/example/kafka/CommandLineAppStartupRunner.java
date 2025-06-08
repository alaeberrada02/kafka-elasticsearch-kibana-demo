package com.example.kafka;

import com.example.kafka.service.ExchangeRateService;
import com.example.kafka.model.ExchangeRate;
import com.example.kafka.producer.ExchangeRateProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final ExchangeRateService exchangeRateService;
    private final ExchangeRateProducer producer;

    public CommandLineAppStartupRunner(ExchangeRateService exchangeRateService,
                                       ExchangeRateProducer producer) {
        this.exchangeRateService = exchangeRateService;
        this.producer = producer;
    }

    @Override
    public void run(String... args) {
        // Récupérer et publier les taux toutes les 5 secondes
        new Thread(() -> {
            while (true) {
                exchangeRateService.fetchExchangeRates()
                        .subscribe(rate -> producer.sendMessage(rate));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
