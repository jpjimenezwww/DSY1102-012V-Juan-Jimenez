public class Gato extends Mascota {

    public Gato(String nombre, int edad, double peso,
                String estadoSalud, String dueno) {
        // "Gato" va fijo por la misma razón
        super(nombre, "Gato", edad, peso, estadoSalud, dueno);
    }

    // Diferencia propia del gato
    @Override
    public String emitirSonido() {
        return "Miau!";
    }
}