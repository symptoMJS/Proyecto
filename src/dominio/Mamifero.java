package dominio;

public class Mamifero extends Animal implements Sonido {
    private String tipoPiel;

    public Mamifero(String nombre, int edad, String habitat, String tipoPiel) {
        super(nombre, edad, habitat);
        this.tipoPiel = tipoPiel;
    }

    @Override
    public void hacerSonido() {
        System.out.println("El mamífero hace un sonido");
    }

    public void mostrarTipoPiel() {
        System.out.println("Tipo de piel: " + tipoPiel);
    }
}
