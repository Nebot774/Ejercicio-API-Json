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
            List<Perro> listaPerros=new ArrayList<>();

            //creamos bucle for que se repetira la cantidad de veçes que el usuario a pedido
            for(int i=0;i<respuestaCantidadPerros;i++){
                String URL="https://dog.ceo/api/breeds/image/random";

                JsonNode fotoPerro = objectMapper.readTree(new URL(URL));//pasamos la ruta de la api
               String fotoPerroAnadirArray=objectMapper.readValue(fotoPerro.get("message").traverse(), new TypeReference<>(){});
               String nombrePerro=averiguarRaza("URL");

               //C

               imagenesPerros.add(fotoPerroAnadirArray);
            }

            imagenesPerros.forEach(System.out::println);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

//metodo para sacar la raza de perro a partir de la url recibida por la API
    private static String averiguarRaza(String imagenUrl){
        //dividimos la URL por las barras
        String[] partes=imagenUrl.split("/");
        if(partes.length>=2){
            //la penultima parte de la URL es la raza
            return partes[partes.length-2];
        }

    }


}