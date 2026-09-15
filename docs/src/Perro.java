public class Perro extends Mascota {

    public Perro(String nombre, int edad, double peso,
                 String estadoSalud, String dueno) {
        // "Perro" va fijo: la especie ya no se pregunta, la define la subclase
        super(nombre, "Perro", edad, peso, estadoSalud, dueno);
    }

    // Diferencia propia del perro
    public String emitirSonido() {
        return "Guau!";
    }
}