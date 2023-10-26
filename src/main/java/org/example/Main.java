package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());


    }
}