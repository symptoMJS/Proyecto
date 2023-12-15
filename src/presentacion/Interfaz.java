package presentacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import dominio.*;

public class InterfazZoo {
    private List<Animal> animales;
    private List<Cuidador> cuidadores;

    public InterfazZoo() {
        this.animales = cargarAnimales();
        this.cuidadores = cargarCuidadores();
    }

    private List<Animal> cargarAnimales() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("animales.dat"))) {
            return (ArrayList<Animal>) obj.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de animales no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo de animales. Se creará una nueva lista.");
        }
        return new ArrayList<>();
    }

    private List<Cuidador> cargarCuidadores() {
        try (ObjectInputStream obj = new ObjectInputStream(new FileInputStream("cuidadores.dat"))) {
            return (ArrayList<Cuidador>) obj.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de cuidadores no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo de cuidadores. Se creará una nueva lista.");
        }
        return new ArrayList<>();
    }

    private void guardarAnimales() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("animales.dat"))) {
            obj.writeObject(animales);
            System.out.println("Animales guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar animales.");
            e.printStackTrace();
        }
    }

    private void guardarCuidadores() {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("cuidadores.dat"))) {
            obj.writeObject(cuidadores);
            System.out.println("Cuidadores guardados.");
        } catch (IOException e) {
            System.out.println("Error al guardar cuidadores.");
            e.printStackTrace();
        }
    }

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
        guardarAnimales();
    }

    public void agregarCuidador(Cuidador cuidador) {
        cuidadores.add(cuidador);
        guardarCuidadores();
    }

    public void asignarCuidador(Animal animal, Cuidador cuidador) {
        cuidador.cuidarAnimal(animal);
    }

    public void mostrarInfoAnimales() {
        System.out.println("----- Animales en el zoo -----");
        for (Animal animal : animales) {
            System.out.println(animal);
            if (animal instanceof Sonido) {
                ((Sonido) animal).hacerSonido();
            }
            if (animal instanceof Volador) {
                ((Volador) animal).volar();
            }
            System.out.println("--------------------");
        }
    }

    public void mostrarInfoCuidadores() {
        System.out.println("----- Cuidadores en el zoo -----");
        for (Cuidador cuidador : cuidadores) {
            System.out.println("Nombre del Cuidador: " + cuidador);
        }
    }

    public static void main(String[] args) {
        InterfazZoo interfazZoo = new InterfazZoo();

        Mamifero leon = new Mamifero("León", 5, "Savana", "Pelaje corto");
        Ave aguila = new Ave("Águila", 3, "Montañas", "Plumaje dorado");
        Cuidador cuidador1 = new Cuidador("Juan");

        interfazZoo.agregarAnimal(leon);
        interfazZoo.agregarAnimal(aguila);
        interfazZoo.agregarCuidador(cuidador1);
        interfazZoo.asignarCuidador(leon, cuidador1);

        interfazZoo.mostrarInfoAnimales();
        interfazZoo.mostrarInfoCuidadores();
    }
}

