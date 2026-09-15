public class Animal {
    // Atributos comunes a todo animal
    private String nombre;
    private String especie;
    private int edad;           // años
    private double peso;        // kg
    private String estadoSalud;
    private String tipo;        // "mascota" o "salvaje"

    // Constructor: deja el objeto en estado válido o no lo crea
    public Animal(String nombre, String especie, int edad, double peso,
                  String estadoSalud, String tipo) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        if (especie == null || especie.isBlank())
            throw new IllegalArgumentException("La especie no puede estar vacía.");
        if (edad < 0)
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        if (peso <= 0)
            throw new IllegalArgumentException("El peso debe ser mayor que 0.");
        if (estadoSalud == null || estadoSalud.isBlank())
            throw new IllegalArgumentException("El estado de salud no puede estar vacío.");
        if (tipo == null ||
                (!tipo.equalsIgnoreCase("mascota") && !tipo.equalsIgnoreCase("salvaje")))
            throw new IllegalArgumentException("El tipo debe ser 'mascota' o 'salvaje'.");

        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.estadoSalud = estadoSalud;
        this.tipo = tipo;
    }

    // Getters: leer el estado sin exponer los atributos directamente
    public String getNombre()      { return nombre; }
    public String getEspecie()     { return especie; }
    public int getEdad()           { return edad; }
    public double getPeso()        { return peso; }
    public String getEstadoSalud() { return estadoSalud; }
    public String getTipo()        { return tipo; }
}