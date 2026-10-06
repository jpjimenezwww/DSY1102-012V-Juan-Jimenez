

//Furgon ES UN Vehiculo: hereda sus datos y validaciones y aporta su regla de costo.

public class Furgon extends Vehiculo {

    private static final double COSTO_BASE = 35000;
    private static final double LIMITE_CARGA_TONELADAS = 1.5;
    private static final double RECARGO_CARGA_ALTA = 0.25;

    private double capacidadCargaToneladas;

    public Furgon(String marca, int anioFabricacion, double kilometraje,
                  double capacidadCargaToneladas) {
        super(marca, anioFabricacion, kilometraje); // inicializa la parte común
        setCapacidadCargaToneladas(capacidadCargaToneladas);
    }

    public double getCapacidadCargaToneladas() {
        return capacidadCargaToneladas;
    }

    public void setCapacidadCargaToneladas(double capacidadCargaToneladas) {
        if (capacidadCargaToneladas <= 0) {
            throw new IllegalArgumentException(
                    "La capacidad de carga debe ser mayor que cero. Valor recibido: "
                            + capacidadCargaToneladas);
        }
        this.capacidadCargaToneladas = capacidadCargaToneladas;
    }

    //Regla de Furgon: base $35.000, si la carga supera 1.5 toneladas sube un 25%.
    @Override
    public double calcularCostoServicio() {
        double costo = COSTO_BASE;
        if (capacidadCargaToneladas > LIMITE_CARGA_TONELADAS) {
            costo = costo * (1 + RECARGO_CARGA_ALTA);
        }
        return costo;
    }
}
