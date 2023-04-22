package com.example.nosqlorm00.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration {
    @Override
    protected String getDatabaseName() {
        return "primo-MongoDB";
    }

    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString
                ("mongodb+srv://Giuliac35:cTXq4q8r2TJEhbHf@database-prova.z3frsop.mongodb.net/?retryWrites=true&w=majority");
        //a questo punto si fa la BUILD
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.example");
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
