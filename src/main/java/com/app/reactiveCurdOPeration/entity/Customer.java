package com.app.reactiveCurdOPeration.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Customer {
    @Id
    private String  id;
    private String name;
    private double totalCost;

    public Customer() {
    }

    public Customer(String name, double totalCost) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.totalCost = totalCost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
