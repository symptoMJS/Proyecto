package dominio;

public class Ave extends Animal implements InterfazAnimal {
    private String tipoPlumaje;

    public Ave(String nombre, int edad, String habitat, String tipoPlumaje) {
        super(nombre, edad, habitat);
        this.tipoPlumaje = tipoPlumaje;
    }

    @Override
    public void hacerSonido() {
        System.out.println("El ave hace un sonido");
    }

    @Override
    public void volar() {
        System.out.println("El ave vuela por el cielo");
    }

    @Override
    public void mostrarInformacion() {
        informacion();
        mostrarTipoPlumaje();
    }

    public void mostrarTipoPlumaje() {
        System.out.println("Tipo de plumaje: " + tipoPlumaje);
    }
}
