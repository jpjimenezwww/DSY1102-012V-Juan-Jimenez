public class SegundoEjemplo {
    public static double calculoAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    public static void main(String[] args) {
        double area = calculoAreaRectangulo(10.5, 20.4);
        System.out.println("El área es: " + area);
    }
}