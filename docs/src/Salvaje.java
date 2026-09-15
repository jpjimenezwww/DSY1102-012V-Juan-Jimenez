public class Salvaje extends Animal {
    // Dato particular de un animal salvaje
    private String procedencia;

    public Salvaje(String nombre, String especie, int edad, double peso,
                   String estadoSalud, String procedencia) {
        // super(...) construye primero la parte Animal
        super(nombre, especie, edad, peso, estadoSalud, "salvaje");

        if (procedencia == null || procedencia.isBlank())
            throw new IllegalArgumentException("Un animal salvaje debe tener procedencia.");
        this.procedencia = procedencia;
    }

    public String getProcedencia() { return procedencia; }
    @Override
    public String atender() {
        return super.atender() + " Atención con protocolo de seguridad; procedencia: " + procedencia + ".";
    }
}