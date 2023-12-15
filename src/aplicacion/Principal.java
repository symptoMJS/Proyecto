package aplicacion;
import dominio.*;

public class Principal {
    public static void main(String[] args) {
        Zoo miZoo = new Zoo();

        Mamifero leon = new Mamifero("León", 5, "Savana", "Pelaje corto");
        Ave aguila = new Ave("Aguila", 3, "Montañas", "Plumaje dorado");

        Cuidador cuidador1 = new Cuidador("Juan");
        Cuidador cuidador2 = new Cuidador("Ana");

        miZoo.agregarAnimal(leon);
        miZoo.agregarAnimal(aguila);

        miZoo.agregarCuidador(cuidador1);
        miZoo.agregarCuidador(cuidador2);

        miZoo.asignarCuidador(leon, cuidador1);
        miZoo.asignarCuidador(aguila, cuidador2);

        System.out.println("Animales en el zoo:");
        miZoo.mostrarAnimales();

        System.out.println("\nCuidadores en el zoo:");
        miZoo.mostrarCuidadores();

        // Guardar el Zoo en un archivo
        miZoo.guardarZoo("miZoo.ser");

        // Cargar el Zoo desde el archivo
        Zoo zooCargado = Zoo.cargarZoo("miZoo.ser");

        if (zooCargado != null) {
            System.out.println("\nZoo cargado desde el archivo:");
            zooCargado.mostrarAnimales();
            System.out.println("\nCuidadores en el zoo:");
            zooCargado.mostrarCuidadores();
        }
    }
}
