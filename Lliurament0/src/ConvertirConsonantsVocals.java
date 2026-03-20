import java.util.Scanner;

public class ConvertirConsonantsVocals {
    public static void main(String[] args) {
        // Creem un objecte Scanner per llegir l'entrada de l'usuari
        Scanner scanner = new Scanner(System.in);

        // Demanem a l'usuari que introdueixi una seqüència de caràcters
        System.out.print("Introdueix una seqüència de caràcters: ");
        String sequencia = scanner.nextLine();

        // Convertim les consonants en majúscules i les vocals en minúscules
        String resultat = convertirConsonantsVocals(sequencia);

        // Mostrem el resultat
        System.out.println("El resultat és: " + resultat);

        // Tanquem l'objecte Scanner
        scanner.close();
    }

    public static String convertirConsonantsVocals(String sequencia) {
        StringBuilder resultat = new StringBuilder();

        for (int i = 0; i < sequencia.length(); i++) {
            char caracter = sequencia.charAt(i);

            if (esConsonant(caracter)) {
                caracter = Character.toUpperCase(caracter);
            } else {
                caracter = Character.toLowerCase(caracter);
            }

            resultat.append(caracter);
        }

        return resultat.toString();
    }

    public static boolean esConsonant(char caracter) {
        caracter = Character.toLowerCase(caracter);

        return !(caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') &&
                Character.isLetter(caracter);
    }
}  