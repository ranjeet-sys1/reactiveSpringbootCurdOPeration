package com.app.reactiveCurdOPeration.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class DBConfiguration  extends AbstractReactiveMongoConfiguration {
    @Bean
    public MongoClient mongoClient(){
        return MongoClients.create();
    }
    @Override
    protected String getDatabaseName() {
        return "reactive-curd-operation";
    }
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(){
        return new ReactiveMongoTemplate(mongoClient(),getDatabaseName());
    }
}
