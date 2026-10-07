// Parte 4

// Main de la parte 3: Gestor, colección y búsqueda

// El for recorre referencias Vehiculo: pide el costo sin preguntar el tipo.

// Hay que administrar vehículos de distintos subtipos en una sola colección

// registrarlos informando por consola, buscarlos por marca y recorrerlos,
// pudiendo pedir el costo desde referencias del tipo base.

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GestorTaller gestor = new GestorTaller();

        // Una sola colección recibe Autos y Furgones.
        gestor.registrarVehiculo(new Auto("Toyota", 2022, 18000, "Yaris", true));
        gestor.registrarVehiculo(new Furgon("Toyota", 2020, 45000, 2.0));
        gestor.registrarVehiculo(new Furgon("Hyundai", 2023, 12000, 1.0));

        // Búsqueda: el gestor devuelve una lista del tipo base.
        List<Vehiculo> encontrados = gestor.buscarPorMarca("Toyota");
        System.out.println("Coincidencias para Toyota: " + encontrados.size());

        // Recorrido polimórfico: no se pregunta el tipo, cada objeto calcula su costo.
        for (Vehiculo vehiculo : gestor.obtenerVehiculos()) {
            System.out.println(vehiculo
                    + " | Costo: " + vehiculo.calcularCostoServicio());
        }

        gestor.listarVehiculos();
    }
}


