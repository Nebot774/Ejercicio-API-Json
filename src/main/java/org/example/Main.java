package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.xml.stream.Location;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //creamos un scanner
        Scanner teclado=new Scanner(System.in);

        //preguntamos cuantas fotos de perros quiere el usuario
        System.out.println("Cuantas imagenes de perritos quieres ver?");
        int respuestaCantidadPerros=teclado.nextInt();




        //creamos un object mapper para la serializacion y deserializacion de JSON
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            JsonNode rootNode = objectMapper.readTree(new URL("https://dog.ceo/api/breeds/image/random"));//pasamos la ruta de la api
            List<Location> locations = objectMapper.readValue(rootNode.get("results").traverse(), new TypeReference<>(){});
            locations.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}