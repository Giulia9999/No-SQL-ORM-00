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
    //CREIAMO LA RELAZIONE CON IL DATABASE
    //PRENDIAMO LA STRINGA DI CONNESSIONE DA MONGODB (In "connect"-"connect your application"
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://Giuliac35:cTXq4q8r2TJEhbHf@database-prova.z3frsop.mongodb.net/?retryWrites=true&w=majority");
        //a questo punto si fa la BUILD
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        return MongoClients.create(mongoClientSettings);
    }

    @Override
    //METODO PER INDICARE AL MONGO DB DA QUALI ENTITà DEVE PRENDERE I DATI
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("co.develhope");
    }

    //METODO PER CREARE GLI INDICI
    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
