import com.github.javafaker.Faker;


import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Faker faker = new Faker();
        String pokemonSecreto = faker.pokemon().name().toLowerCase();
        StringBuilder palabraAdivinada = new StringBuilder("_".repeat(pokemonSecreto.length()));
        int intentos = 6;
        boolean palabraCompleta = false;

        System.out.println("Bienvenido al ahorcado de pokemon");
        System.out.println("Tienes " + intentos + " intentos para adivinar el pokemon");

        while (intentos > 0 && !palabraCompleta){
            System.out.println("Palabra actual: " + palabraAdivinada);
            System.out.println("Introduce una letra: ");
            char letra = scanner.next().charAt(0);

            boolean letraAdivinada = false;

            for (int i = 0; i < pokemonSecreto.length(); i++){
                if (pokemonSecreto.charAt(i) == letra) {
                    palabraAdivinada.setCharAt(i, letra);
                    letraAdivinada = true;
                }
            }

            if (!letraAdivinada) {
                intentos--;
                dibujarAhorcado(intentos);
                System.out.println("El pokemon no tiene la palabra indicada. Te quedan "+ intentos + " intentos.");
            }

            if (palabraAdivinada.toString().equals(pokemonSecreto)){
                palabraCompleta = true;
            }
        }

        if (palabraCompleta) {
            System.out.println("¡Felicidades! Has adivinado la palabra: " + pokemonSecreto);
        } else {
            System.out.println("Perdiste. La palabra era: " + pokemonSecreto);
        }
    }

    public static void dibujarAhorcado(int intentos) {
        switch (intentos) {
            case 6 -> System.out.println(" -----\n |   |\n     |\n     |\n     |\n     |\n-------");
            case 5 -> System.out.println(" -----\n |   |\n O   |\n     |\n     |\n     |\n-------");
            case 4 -> System.out.println(" -----\n |   |\n O   |\n |   |\n     |\n     |\n-------");
            case 3 -> System.out.println(" -----\n |   |\n O   |\n/|   |\n     |\n     |\n-------");
            case 2 -> System.out.println(" -----\n |   |\n O   |\n/|\\  |\n     |\n     |\n-------");
            case 1 -> System.out.println(" -----\n |   |\n O   |\n/|\\  |\n/    |\n     |\n-------");
            case 0 -> System.out.println(" -----\n |   |\n O   |\n/|\\  |\n/ \\  |\n     |\n-------");
            default -> {
            }
        }
    }

}
