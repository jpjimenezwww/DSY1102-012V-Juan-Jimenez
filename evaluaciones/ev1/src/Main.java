// Parte 1
// Construcción de marca, anio, kilometraje
// Un valor inválido provoca IllegalArgumentException.

// • marca: no puede ser nula ni vacía.
//• anioFabricacion: debe estar entre 1990 y 2026.
//• kilometraje: debe ser mayor que cero.


public class Main {

    public static void main(String[] args) {

        // el objeto se construye y se muestra con toString().
        // PARTE 1 SIN INPUTS, SOLO CREACIÓN DE CONSTRUCTORES
        // AQUI AÚN PODEMOS EDITAR LA MARCA, ANIO Y KM PARA MOSTRAR

        Vehiculo vehiculo = new Vehiculo("Lamborghini", 2018, 1500);
        System.out.println("Creado: " + vehiculo);


        // SETTERS:
        // Los setters modifican respetando las mismas reglas... los getters consultan.
        vehiculo.setMarca("Lamborghini");
        vehiculo.setAnioFabricacion(2018);
        vehiculo.setKilometraje(1500);
        System.out.println("Modificado: " + vehiculo.getMarca() + " | "
                + vehiculo.getAnioFabricacion() + " | " + vehiculo.getKilometraje());


        // Un valor inválido lanza IllegalArgumentException al crear...
        try {
            new Vehiculo("", 2022, 18000);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado al crear: " + e.getMessage());
        }


        // ...y también al modificar. El objeto conserva su valor anterior.
        try {
            vehiculo.setAnioFabricacion(1980);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado al modificar: " + e.getMessage());
        }
        System.out.println("Sigue valido: " + vehiculo);
    }
}
