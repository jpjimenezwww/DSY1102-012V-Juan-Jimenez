// Parte 3

// Main de la parte 3: Capacidad opcional mediante interfaz

// valida porcentaje de 0 a 100 y aplica el descuento correspondiente.

// Main de verificación de la Parte 3: garantía del taller mediante la interfaz.


public class Main {

    public static void main(String[] args) {
        Auto auto = new Auto("Toyota", 2022, 18000, "Yaris", true);

        // La garantía del taller parte desactivada...
        System.out.println("Garantia al crear: " + auto.tieneGarantiaActiva());

        // ...y se activa a través del contrato Garantizable.
        Garantizable garantizable = auto;
        garantizable.activarGarantia();
        System.out.println("Garantia tras activarla: " + auto.tieneGarantiaActiva());

        // Lo anterior sigue funcionando: el costo no depende de esta garantía.
        Vehiculo vehiculo = auto;
        System.out.println(vehiculo + " | Costo: " + vehiculo.calcularCostoServicio());

        // Furgon no implementa Garantizable: sigue siendo solo un Vehiculo.
        Vehiculo furgon = new Furgon("Toyota", 2020, 45000, 2.0);
        System.out.println(furgon + " | Costo: " + furgon.calcularCostoServicio());
    }
}

