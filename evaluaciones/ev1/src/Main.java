
// Parte 6:
// Entrada de usuario, excepciones y menú
// Creación LecturaEntrada
// Agregar el menú a Main
// Usaciclos para repetir la solicitud hasta obtener un valor válido.


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
import java.util.NoSuchElementException;

public class Main {

    private static final int OPCION_LISTAR = 1;
    private static final int OPCION_BUSCAR = 2;
    private static final int OPCION_SIMULAR = 3;
    private static final int OPCION_SALIR = 4;


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





        //Parte6: menú por consola
        LecturaEntrada entrada = new LecturaEntrada();
        try {
            ejecutarMenu(gestor, entrada);
        } catch (NoSuchElementException e) {
            // Se cerró la entrada (Ctrl+D o Ctrl+Z): ya no queda nada que leer.
            System.out.println("\nEntrada cerrada. Programa finalizado.");
        }
        entrada.cerrar();
    }

    // Repite el menú hasta que el usuario elige salir. Solo coordina: cada
    // opción delega en el gestor, en los vehículos o en LecturaEntrada.
    private static void ejecutarMenu(GestorTaller gestor, LecturaEntrada entrada) {
        int opcion;
        do {
            System.out.println();
            System.out.println("=== MENU AUTOFIX ===");
            System.out.println("1. Listar todos los vehiculos");
            System.out.println("2. Buscar por marca");
            System.out.println("3. Simular costo del servicio con descuento");
            System.out.println("4. Salir");
            opcion = entrada.leerEnteroEnRango("Seleccione una opcion: ",
                    OPCION_LISTAR, OPCION_SALIR);
            System.out.println();

            switch (opcion) {
                case OPCION_LISTAR:
                    gestor.listarVehiculos();
                    break;
                case OPCION_BUSCAR:
                    mostrarBusqueda(gestor, entrada.leerTexto("Marca a buscar: "));
                    break;
                case OPCION_SIMULAR:
                    simularCostoConDescuento(gestor, entrada);
                    break;
                case OPCION_SALIR:
                    System.out.println("Programa finalizado.");
                    break;
            }
        } while (opcion != OPCION_SALIR);
    }

    // Opción 3: el usuario elige un vehículo y un porcentaje, y se usa la
    // sobrecarga calcularCostoServicio(double) de la Parte 2.
    private static void simularCostoConDescuento(GestorTaller gestor,
                                                 LecturaEntrada entrada) {
        List<Vehiculo> vehiculos = gestor.obtenerVehiculos();
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }

        System.out.println("=== SIMULAR COSTO CON DESCUENTO ===");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo vehiculo = vehiculos.get(i);
            System.out.println((i + 1) + ". " + vehiculo.obtenerTipo()
                    + " | " + vehiculo);
        }

        int numero = entrada.leerEnteroEnRango("Numero de vehiculo: ",
                1, vehiculos.size());
        Vehiculo elegido = vehiculos.get(numero - 1);

        // La lectura filtra tipo y rango para poder volver a pedir el dato.
        // Vehiculo valida el porcentaje de todos modos: no confía en quien lo llama.
        double porcentaje = entrada.leerDecimalEnRango(
                "Porcentaje de descuento (0 a 100): ", 0, 100);

        double costoNormal = elegido.calcularCostoServicio();
        double costoConDescuento = elegido.calcularCostoServicio(porcentaje);

        System.out.println("Vehiculo: " + elegido.obtenerTipo() + " | " + elegido);
        System.out.println("Costo normal: " + formatearPesos(costoNormal));
        System.out.println("Descuento aplicado: " + porcentaje + "%");
        System.out.println("Costo con descuento: " + formatearPesos(costoConDescuento));
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