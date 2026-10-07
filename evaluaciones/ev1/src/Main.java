
//Parte 5: Integración con los datos institucionales
// Main coordina: crea los objetos, le pide las consultas al gestor y muestra
// los resultados. Las fórmulas, validaciones y la búsqueda viven en sus clases.


// Parte 4: Registrar, buscar y recorrer.


// Main de la parte 3: Gestor, colección y búsqueda
// El for recorre referencias Vehiculo: pide el costo sin preguntar el tipo.
// Hay que administrar vehículos de distintos subtipos en una sola colección

// registrarlos informando por consola, buscarlos por marca y recorrerlos,
// pudiendo pedir el costo desde referencias del tipo base.

import java.util.List;


public class Main {

    public static void main(String[] args) {
        GestorTaller gestor = new GestorTaller();

        // ----- Parte 5: demostración con los datos institucionales -----
        Auto autoToyota = new Auto("Toyota", 2022, 18000, "Yaris", true);
        autoToyota.activarGarantia(); // operación del contrato Garantizable

        Vehiculo autoChevrolet = new Auto("Chevrolet", 2018, 62000, "Sail", false);
        Vehiculo furgonToyota = new Furgon("Toyota", 2020, 45000, 2.0);
        Vehiculo furgonHyundai = new Furgon("Hyundai", 2023, 12000, 1.0);

        gestor.registrarVehiculo(autoToyota);
        gestor.registrarVehiculo(autoChevrolet);
        gestor.registrarVehiculo(furgonToyota);
        gestor.registrarVehiculo(furgonHyundai);

        System.out.println();
        mostrarBusqueda(gestor, "Toyota");

        System.out.println();
        gestor.listarVehiculos();
    }

    // Pide la búsqueda al gestor y recorre el resultado con referencias del tipo base.
    private static void mostrarBusqueda(GestorTaller gestor, String marca) {
        System.out.println("=== BUSQUEDA POR MARCA: \"" + marca + "\" ===");
        List<Vehiculo> resultados = gestor.buscarPorMarca(marca);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron vehiculos de esa marca.");
            return;
        }
        for (Vehiculo vehiculo : resultados) {
            // Polimorfismo: cada objeto responde con su detalle y su regla de costo.
            double costo = vehiculo.calcularCostoServicio();
            System.out.println(vehiculo.obtenerDetalle()
                    + " | Costo servicio: " + formatearPesos(costo));
            System.out.println("---");
        }
    }

    // Pesos sin decimales, por ejemplo $43750.
    private static String formatearPesos(double monto) {
        return String.format("$%.0f", monto);
    }
}



