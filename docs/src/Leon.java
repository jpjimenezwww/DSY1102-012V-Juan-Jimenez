public class Leon extends Salvaje {

    public Leon(String nombre, int edad, double peso,
                String estadoSalud, String procedencia) {
        // "Leon" va fijo por la misma razón
        super(nombre, "Leon", edad, peso, estadoSalud, procedencia);
    }

    // Diferencia propia del león
    @Override
    public String emitirSonido() {
        return "Rugido!";
    }
}