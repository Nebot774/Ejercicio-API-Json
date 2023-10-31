package org.example;


public class Perro {
    private String raza;
    private String urlImagen;

    // Constructor
    public Perro(String raza, String urlImagen) {
        this.raza = raza;
        this.urlImagen = urlImagen;
    }

    // Getters y Setters
    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    // Método toString para mostrar información del perro
    @Override
    public String toString() {
        return "Perro{" +
                "raza='" + raza + '\'' +
                ", urlImagen='" + urlImagen + '\'' +
                '}';
    }
}

