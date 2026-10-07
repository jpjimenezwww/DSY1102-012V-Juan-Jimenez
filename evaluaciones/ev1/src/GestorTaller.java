

// Parte 4:
// solicita: Declara una colección List<Vehiculo> e inicialízala con ArrayList<>.

// registrarVehiculo (adición, con aviso por consola)

// buscarPorMarca (filtrado con un for; compara con equalsIgnoreCase,
// que no distingue mayúsculas, y devuelve una lista nueva, vacía si no hay coincidencias)

// obtenerVehiculos (consulta: entrega una copia)

// listarVehiculos (listado con toString())


import java.util.ArrayList;
import java.util.List;

// Administra los vehículos del taller. La colección es privada: desde afuera
// solo se puede registrar, buscar y consultar mediante estos métodos.
public class GestorTaller {

    // Parametrizada con el tipo base: guarda Autos y Furgones en la misma lista.
    private final List<Vehiculo> vehiculos = new ArrayList<>();

    // Adición: registra el vehículo e informa por consola.
    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException(
                    "No se puede registrar un vehiculo nulo.");
        }
        vehiculos.add(vehiculo);
        System.out.println(vehiculo.getMarca() + " (" + vehiculo.obtenerTipo()
                + ") registrado correctamente.");
    }

    // Filtrado: retorna todas las coincidencias (lista vacía si no hay ninguna).
    public List<Vehiculo> buscarPorMarca(String criterio) {
        List<Vehiculo> coincidencias = new ArrayList<>();
        if (criterio == null) {
            return coincidencias;
        }
        String marcaBuscada = criterio.trim();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMarca().equalsIgnoreCase(marcaBuscada)) {
                coincidencias.add(vehiculo);
            }
        }
        return coincidencias;
    }

    // Consulta: entrega una copia, así nadie modifica la colección interna.

    public List<Vehiculo> obtenerVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    // Listado institucional: usa el toString() de cada vehículo.

    public void listarVehiculos() {
        System.out.println("=== LISTADO DE VEHICULOS ===");
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
            return;
        }
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }
    }
}
