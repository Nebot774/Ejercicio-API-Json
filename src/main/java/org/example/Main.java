package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.xml.stream.Location;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
            //creamos array donde almazenaremos las url de las imagenes de los perror
            List<String> imagenesPerros=new ArrayList<>();

            //creamos bucle for que se repetira la cantidad de veçes que el usuario a pedido
            for(int i=0;i<respuestaCantidadPerros;i++){
                JsonNode fotoPerro = objectMapper.readTree(new URL("https://dog.ceo/api/breeds/image/random"));//pasamos la ruta de la api
               String fotoPerroAnadirArray=objectMapper.readValue(fotoPerro.get("message").traverse(), new TypeReference<>(){});

               imagenesPerros.add(fotoPerroAnadirArray);
            }

            imagenesPerros.forEach(System.out::println);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}