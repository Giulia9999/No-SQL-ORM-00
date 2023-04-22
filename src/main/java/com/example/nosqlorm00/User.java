package com.example.nosqlorm00;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class User {
    @Id
    private String id;
    private String name;
    private String lastname;
    @Indexed(unique = true)
    private String email;
}
