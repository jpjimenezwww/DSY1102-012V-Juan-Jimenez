
// Parte 6: creacióm lectura de entrada.
// Contiene el único Scanner del programa


//leerEnteroEnRango repite dentro de un while: lee la línea como texto,
// la convierte con Integer.parseInt dentro de un try y revisa el rango;
// si la conversión falla, catch
//NumberFormatException) informa y el ciclo vuelve a pedir

//leerDecimalEnRango hace lo mismo con Double.parseDouble,
// y leerTexto repite mientras el texto esté vacío.


import java.util.Scanner;

public class LecturaEntrada {

    private final Scanner scanner = new Scanner(System.in);

    // Repite la solicitud hasta recibir un entero dentro del rango indicado.
    // Lee la línea completa y la convierte a mano: si el texto no es un número,
    // Integer.parseInt lanza NumberFormatException y se vuelve a pedir.
    public int leerEnteroEnRango(String mensaje, int minimo, int maximo) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(texto);
                if (valor >= minimo && valor <= maximo) {
                    valido = true;
                } else {
                    System.out.println("Error: el valor debe estar entre " + minimo
                            + " y " + maximo + ". Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + texto
                        + "\" no es un numero entero. Intente nuevamente.");
            }
        }
        return valor;
    }

    // Igual que el anterior, pero acepta números con decimales.
    public double leerDecimalEnRango(String mensaje, double minimo, double maximo) {
        double valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            try {
                // Se acepta coma decimal (12,5) además de punto (12.5).
                valor = Double.parseDouble(texto.replace(',', '.'));
                if (valor >= minimo && valor <= maximo) {
                    valido = true;
                } else {
                    System.out.println("Error: el valor debe estar entre " + minimo
                            + " y " + maximo + ". Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: \"" + texto
                        + "\" no es un numero valido. Intente nuevamente.");
            }
        }
        return valor;
    }

    // Repite la solicitud hasta recibir un texto que no esté vacío.
    public String leerTexto(String mensaje) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: el texto no puede estar vacio."
                        + " Intente nuevamente.");
            }
        }
        return texto;
    }

    public void cerrar() {
        scanner.close();
    }
}
