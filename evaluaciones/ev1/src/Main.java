// Parte 2

// Main de la parte 2: herencia, costo polimórfico y sobrecarga.

// valida porcentaje de 0 a 100 y aplica el descuento correspondiente.



public class Main {

    public static void main(String[] args) {
        // Vehiculo ahora es abstracta: ya no se puede escribir new Vehiculo(...).
        // Se crean los subtipos y se manejan con referencias del tipo base.
        Vehiculo auto = new Auto("Lamborghini", 2018, 1500, "Urus", false);
        Vehiculo furgon = new Furgon("Toyota", 2020, 45000, 2.0);

        mostrarCostos(auto);
        mostrarCostos(furgon);

        // La sobrecarga valida el porcentaje (0 a 100).
        try {
            auto.calcularCostoServicio(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }

        // Las validaciones de la Parte 1 siguen vigentes a través de super(...).
        try {
            new Furgon("Toyota", 1980, 45000, 2.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }
    }

    // Recibe el tipo base: cada objeto responde con su propia regla de costo.
    private static void mostrarCostos(Vehiculo vehiculo) {
        System.out.println(vehiculo
                + " | Costo: " + vehiculo.calcularCostoServicio()
                + " | Con 10% de descuento: " + vehiculo.calcularCostoServicio(10));
    }
}

