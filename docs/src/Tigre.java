public class Tigre extends Salvaje {

    public Tigre(String nombre, int edad, double peso,
                 String estadoSalud, String procedencia) {
        // "Tigre" va fijo; la especie la define la subclase
        super(nombre, "Tigre", edad, peso, estadoSalud, procedencia);
    }

    // Diferencia propia del tigre
    public String emitirSonido() {
        return "Grrr!";
    }
}