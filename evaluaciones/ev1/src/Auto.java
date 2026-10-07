

// Parte 5:
// No se sobrescribe toString(): el listado final usa el de Vehiculo.

//Parte 4: Sin cambios.

// parte 3
// • Auto debe implementar Garantizable; Furgon no debe implementarla.
//• Agrega a Auto el atributo private boolean garantiaActiva con valor inicial false.




 // Auto ES UN Vehiculo (herencia) y además (PUEDE!!) tener garantía del taller


    // (interfaz Garantizable).
    public class Auto extends Vehiculo implements Garantizable {


    private static final double COSTO_BASE = 25000;
    private static final double RECARGO_SIN_GARANTIA_FABRICA = 0.30;

    private String modelo;
    private boolean garantiaFabricaVigente;



    // PARTE 3: GARANTIA DESACTIVADA...


    private boolean garantiaActiva = false; // garantía del taller: parte desactivada

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




    public void setGarantiaActiva(boolean garantiaActiva) {
          this.garantiaActiva = garantiaActiva;
    }



    //contrato Garantizable

    @Override
    public boolean tieneGarantiaActiva() {
              return garantiaActiva;
    }

    @Override
    public void activarGarantia() {
       setGarantiaActiva(true); // reutiliza el setter
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

    @Override
    public String obtenerTipo() {
        return "Auto";
        }

// Reutiliza el detalle común y le agrega lo propio del Auto.
// No se sobrescribe toString(): el listado final usa el de Vehiculo.

    @Override
    public String obtenerDetalle() {
        return super.obtenerDetalle()
              + " | Modelo: " + modelo
              + " | Garantia vigente: " + textoSiNo(garantiaFabricaVigente)
              + "\n  Garantia activa: " + textoSiNo(tieneGarantiaActiva());
    }

    private String textoSiNo(boolean valor) {
        return valor ? "Si" : "No";

    }
}