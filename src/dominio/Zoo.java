package dominio;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zoo implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Animal> animales = new ArrayList<>();
    private List<Cuidador> cuidadores = new ArrayList<>();

    public void agregarAnimal(Animal animal) {
        animales.add(animal);
    }

    public void agregarCuidador(Cuidador cuidador) {
        cuidadores.add(cuidador);
    }

    public void asignarCuidador(Animal animal, Cuidador cuidador) {
        cuidador.cuidarAnimal(animal);
    }

    public void mostrarAnimales() {
        for (Animal animal : animales) {
            animal.informacion();
            if (animal instanceof Sonido) {
                ((Sonido) animal).hacerSonido();
            }
            if (animal instanceof Volador) {
                ((Volador) animal).volar();
            }
            System.out.println();
        }
    }

    public void mostrarCuidadores() {
        System.out.println("Cuidadores en el zoo:");
        for (Cuidador cuidador : cuidadores) {
            System.out.println("Nombre del Cuidador: " + cuidador);
        }
    }

    public void guardarZoo(String archivo) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(this);
            System.out.println("Zoo guardado exitosamente en " + archivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Zoo cargarZoo(String archivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Zoo) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
