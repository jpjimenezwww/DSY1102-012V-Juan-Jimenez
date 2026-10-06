

// Auto pertenece a Vehiculo: hereda sus datos y validaciones y aporta su regla de costo.
public class Auto extends Vehiculo {

    private static final double COSTO_BASE = 25000;
    private static final double RECARGO_SIN_GARANTIA_FABRICA = 0.30;

    private String modelo;
    private boolean garantiaFabricaVigente;

    public Auto(String marca, int anioFabricacion, double kilometraje,
                String modelo, boolean garantiaFabricaVigente) {
        super(marca, anioFabricacion, kilometraje); // inicializa la parte común
        setModelo(modelo);
        setGarantiaFabricaVigente(garantiaFabricaVigente);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo ni vacio.");
        }
        this.modelo = modelo.trim();
    }

    public boolean isGarantiaFabricaVigente() {
        return garantiaFabricaVigente;
    }

    public void setGarantiaFabricaVigente(boolean garantiaFabricaVigente) {
        this.garantiaFabricaVigente = garantiaFabricaVigente;
    }



    //Regla de Auto: base $25.000... sin garantia de fábrica vigente sube un 30%.
    @Override
    public double calcularCostoServicio() {
        double costo = COSTO_BASE;
        if (!garantiaFabricaVigente) {
            costo = costo * (1 + RECARGO_SIN_GARANTIA_FABRICA);
        }
        return costo;
    }
}
