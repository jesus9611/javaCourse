import java.util.Scanner;
import java.util.Random;

public class NumerosAleatorios {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Ingresa un número del 1 al 100:");
        int cantidad = scanner.nextInt();

        // Validación básica
        if (cantidad < 1 || cantidad > 100) {
            System.out.println("Número inválido. Debe ser entre 1 y 100.");
            return;
        }

        System.out.println("Generando " + cantidad + " números aleatorios:");

        // Generación de números aleatorios
        for (int i = 0; i < cantidad; i++) {
            int numero = random.nextInt(100) + 1; // números entre 1 y 100
            System.out.println(numero);
        }

        scanner.close();  // Cierra el scanner
    }
}
