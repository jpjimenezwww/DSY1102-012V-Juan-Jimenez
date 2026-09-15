public class Mascota extends Animal {
    // Dato particular de una mascota
    private String dueno;

    public Mascota(String nombre, String especie, int edad, double peso,
                   String estadoSalud, String dueno) {
        // super(...) construye primero la parte Animal
        super(nombre, especie, edad, peso, estadoSalud, "mascota");

        if (dueno == null || dueno.isBlank())
            throw new IllegalArgumentException("Una mascota debe tener dueño.");
        this.dueno = dueno;
    }

    public String getDueno() { return dueno; }

    @Override
    public String atender() {
        return super.atender() + " Atención estándar de mascota; se avisa al dueño (" + dueno + ").";
    }
}