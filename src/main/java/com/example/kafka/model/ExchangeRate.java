package com.example.kafka.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Document(indexName = "exchange-rates")
public class ExchangeRate {

    @Id
    private String id;
    private String source;
    private String target;
    private double rate;
    private LocalDateTime timestamp;

    public ExchangeRate() {
    }

    public ExchangeRate(String id, String source, String target, double rate, LocalDateTime timestamp) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.rate = rate;
        this.timestamp = timestamp;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public double getRate() {
        return rate;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", rate=" + rate +
                ", timestamp=" + timestamp +
                '}';
    }
}
