import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Mexicano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nacionalidad = "";

        // Valida nacionalidad
        while (true) {
            System.out.print("¿Cuál es tu nacionalidad?: ");
            nacionalidad = scanner.nextLine();
            if (nacionalidad.equalsIgnoreCase("mexicano")) {
                System.out.println("Bienvenido, mexicano.");
                break;
            } else {
                System.out.println("Este programa es solo para mexicanos. Intenta de nuevo.\n");
            }
        }

        // Valida nombre y apellido
        String nombre = "";
        String apellido = "";
        while (true) {
            System.out.print("¿Cuál es tu nombre o nombres? ");
            nombre = scanner.nextLine();

            System.out.print("¿Cuál es tu apellido o apellidos? ");
            apellido = scanner.nextLine();

            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+") &&
                apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                System.out.println("Nombre completo aceptado: " + nombre + " " + "\n");
                break;
            } else {
                System.out.println("Error: El nombre o apellido no deben contener números ni símbolos. Intenta de nuevo.\n");
            }
        }

        // Valida fecha completa (año, mes, día)
        LocalDate nacimiento = null;
        while (true) {
            int anio = 0, mes = 0, dia = 0;

            // Año
            while (true) {
                System.out.print("¿En qué año naciste? ");
                if (scanner.hasNextInt()) {
                    anio = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Error: Ingresa solo números.");
                    scanner.next();
                }
            }

            // Mes
            while (true) {
                System.out.print("¿En qué mes naciste? (1-12): ");
                if (scanner.hasNextInt()) {
                    mes = scanner.nextInt();
                    if (mes >= 1 && mes <= 12) {
                        break;
                    } else {
                        System.out.println("Error: El mes debe estar entre 1 y 12.");
                    }
                } else {
                    System.out.println("Error: Ingresa solo números.");
                    scanner.next();
                }
            }

            // Día
            while (true) {
                System.out.print("¿En qué día naciste? ");
                if (scanner.hasNextInt()) {
                    dia = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Error: Ingresa solo números.");
                    scanner.next();
                }
            }

            // Valida fecha
            try {
                nacimiento = LocalDate.of(anio, mes, dia);
                break; // Fecha válida, sal del bucle
            } catch (Exception e) {
                System.out.println("La fecha ingresada no es válida. Por favor, vuelve a ingresarla.\n");
                scanner.nextLine(); // limpia el buffer
            }
        }

        // Calcula edad
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(nacimiento, hoy);

        // Calcula días y segundos vividos
        long diasVividos = ChronoUnit.DAYS.between(nacimiento, hoy);
        long segundosVividos = diasVividos * 24 * 60 * 60;

        // Muestra el resultado 
        System.out.println("\nHola " + nombre + " " + apellido + ", has vivido:");
        System.out.println(edad.getYears() + " años, " + edad.getMonths() + " meses y " + edad.getDays() + " días.");
        System.out.println("En total has vivido " + diasVividos + " días.");
        System.out.println("Y aproximadamente " + segundosVividos + " segundos.");

        scanner.close();
    }
}
