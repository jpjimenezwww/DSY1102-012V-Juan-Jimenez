public class Main {
    public static void main(String[] args) {
        // 1. Llegan animales de distintas especies a la veterinaria
        Perro perro = new Perro("Rex", 3, 12.5, "sano", "Juan Pérez");
        Gato  gato  = new Gato("Michi", 2, 4.0, "control anual", "Ana Soto");
        Tigre tigre = new Tigre("Rajá", 6, 180.0, "herida en pata", "Reserva Los Andes");
        Leon  leon  = new Leon("Simba", 5, 190.0, "chequeo", "Zoológico Nacional");

        // 2. La veterinaria los guarda a TODOS como Animal: aquí vive el polimorfismo
        Animal[] animales = { perro, gato, tigre, leon };

        // 3. Recorre la lista y atiende a cada uno con el MISMO mensaje.
        //    Cada objeto decide su propia atención según su tipo.
        System.out.println("=== Veterinaria: atención del día ===");
        for (Animal a : animales) {
            System.out.println("- " + a.getNombre() + " [" + a.getTipo() + "]");
            System.out.println("    " + a.atender());
        }
    }
}