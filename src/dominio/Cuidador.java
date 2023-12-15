package dominio;
import java.io.Serializable;

public class Cuidador implements Serializable {
    private String nombre;

    public Cuidador(String nombre) {
        this.nombre = nombre;
    }

    public void cuidarAnimal(Animal animal) {
        System.out.println(nombre + " está cuidando a:");
        animal.informacion();
        if (animal instanceof Sonido) {
            ((Sonido) animal).hacerSonido();
        }
        System.out.println();
    }
}
