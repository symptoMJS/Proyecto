package dominio;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    private String nombre;
    private int edad;
    private String habitat;

    public Animal(String nombre, int edad, String habitat) {
        this.nombre = nombre;
        this.edad = edad;
        this.habitat = habitat;
    }

    public void informacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Habitat: " + habitat);
    }
}
