package com.example.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recipe {

    @JsonIgnore
    UUID id;
    String name;
    String[] ingredients;
    String[] instructions;

    @PostConstruct
    void init() {
        id = UUID.randomUUID();
    }

}
