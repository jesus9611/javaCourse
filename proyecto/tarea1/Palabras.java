import java.util.*;

public class Palabras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Pedir al usuario que escriba una frase
        System.out.println("Escribe una frase:");
        String frase = scanner.nextLine();

        // 2. Convertir la frase a minúsculas para evitar duplicados por mayúsculas
        frase = frase.toLowerCase();

        // 3. Quitar signos de puntuación básicos (opcional)
        frase = frase.replaceAll("[.,;:!?]", "");

        // 4. Separar la frase en palabras usando split
        String[] palabras = frase.split(" ");

        // 5. Crear un mapa para contar la frecuencia de cada palabra
        Map<String, Integer> frecuencia = new HashMap<>();

        // 6. Llenar el mapa con los conteos
        for (String palabra : palabras) {
            // Evitar palabras vacías o espacios
            if (palabra.trim().isEmpty()) continue;

            // Si la palabra ya está en el mapa, se suma 1
            if (frecuencia.containsKey(palabra)) {
                frecuencia.put(palabra, frecuencia.get(palabra) + 1);
            } else {
                // Si no está, la agregamos con valor 1
                frecuencia.put(palabra, 1);
            }
        }

        // 7. Mostrar cantidad de palabras únicas
        System.out.println("Palabras únicas: " + frecuencia.size());

        // 8. Mostrar frecuencia de cada palabra
        System.out.println("Frecuencia:");
        for (Map.Entry<String, Integer> entrada : frecuencia.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }

        // 9. Buscar las palabras que aparecen solo una vez
        List<String> soloUnaVez = new ArrayList<>();
        for (Map.Entry<String, Integer> entrada : frecuencia.entrySet()) {
            if (entrada.getValue() == 1) {
                soloUnaVez.add(entrada.getKey());
            }
        }

        // 10. Mostrar palabras únicas
        System.out.println("Palabras que aparecen solo una vez:");
        System.out.println(String.join(", ", soloUnaVez));
    }
}
