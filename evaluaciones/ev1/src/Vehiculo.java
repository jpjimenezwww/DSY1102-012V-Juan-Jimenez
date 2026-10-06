/*
 * IL 1.1 - Solcución orientada a objetos vs solución estructurada
 * OPINIÓN:
 *
 * En un programa estructurado los datos y las funciones van por separado,
 * y cualquier parte del codigo puede modificar un dato y dejarlo malo.
 * Con la solución orientada a objetos es distinto... la clase vehiculo junta los datos (marca, anio,
 * kilometraje) con los metodos que los cuidan (los setters que validan),
 * asi el mismo objeto se encarga de que sus datos sean validos.
 *
 * Otra diferencia es que Java usa tipos explicitos: cada variable se declara
 * con su tipo (String marca, int anioFabricacion) y ese tipo no cambia. En
 * lenguajes como Python la variable no declara el tipo y puede guardar cualquier
 * cosa.
 *
 * Ademas Java compila antes de ejecutar, asi que si me equivoco de tipo
 * (por ejemplo poner texto donde va un numero) el error aparece al compilar
 * y no cuando el programa ya esta corriendo.
 */


public class Vehiculo {

    //rango valido del año de fabricación.
    private static final int ANIO_MINIMO = 1990;
    private static final int ANIO_MAXIMO = 2026;


    // PEDIDOS EXPLICITOS PARTE 1:
    //    • Declara private String marca.
    //    • Declara private int anioFabricacion.
    //    • Declara private double kilometraje.


    private String marca;
    private int anioFabricacion;
    private double kilometraje;




    // CREACIÓN DE CONSTRUCTORES
    //LOS PEDIDOS PARTE 1 ( GET + SET):
    // getMarca
    // getAnioFabricacion
    // getKilometraje



// • El constructor debe delegar la asignación de valores a los setters,
    // La marca no puede ser nula ni vacia
    // El año de fabricacion debe estar entre 1990 - 2026
    // El kilometraje debe ser mayor que cero



    public Vehiculo(String marca, int anioFabricacion, double kilometraje) {
        setMarca(marca);
        setAnioFabricacion(anioFabricacion);
        setKilometraje(kilometraje);
    }

    public String getMarca() {
        return marca;
    }




    //regla: la marca no puede ser nula ni vacía.
    public void setMarca(String marca) {
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede ser nula ni vacia.");
        }
        this.marca = marca.trim(); // se guarda sin espacios
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }





    // regla: el año de fabricación debe estar entre 1990 y 2026.
    public void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < ANIO_MINIMO || anioFabricacion > ANIO_MAXIMO) {
            throw new IllegalArgumentException("El año de fabricacion debe estar entre "
                    + ANIO_MINIMO + " y " + ANIO_MAXIMO
                    + ". Valor recibido: " + anioFabricacion);
        }
        this.anioFabricacion = anioFabricacion;
    }


    public double getKilometraje() {
        return kilometraje;
    }




    //Regla: el kilometraje debe ser mayor que cero.
    public void setKilometraje(double kilometraje) {
        if (kilometraje <= 0) {
            throw new IllegalArgumentException(
                    "El kilometraje debe ser mayor que cero. Valor recibido: "
                            + kilometraje);
        }
        this.kilometraje = kilometraje;
    }



    // PARTE 1 DIRECTAMENTE PIDE UN OVERRIDE
    // Sobrescribe toString() para incluir únicamentemarcayañodefabricación.



    // únicamente marca y año de fabricación.
    @Override
    public String toString() {
        return "Marca: " + marca + " | Año: " + anioFabricacion;
    }
}
