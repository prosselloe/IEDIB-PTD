import java.util.Arrays;
import java.util.Scanner;

public class Mediana {
    public static void main(String[] args) {
        // Creem un objecte Scanner per llegir l'entrada de l'usuari
        Scanner scanner = new Scanner(System.in);
        
        // Demanem a l'usuari el nombre de valors
        System.out.print("Introdueix el nombre de valors: ");
        int n = scanner.nextInt();
        
        // Creem un array per emmagatzemar els valors
        double[] valors = new double[n];
        
        // Demanem a l'usuari que introdueixi els valors
        for (int i = 0; i < n; i++) {
            System.out.print("Introdueix el valor " + (i + 1) + ": ");
            valors[i] = scanner.nextDouble();
        }
        
        // Ordenem l'array de valors
        Arrays.sort(valors);
        
        // Calculem la mediana
        double mediana;
        if (n % 2 == 0) {
            int index1 = n / 2 - 1;
            int index2 = n / 2;
            mediana = (valors[index1] + valors[index2]) / 2;
        } else {
            int index = n / 2;
            mediana = valors[index];
        }
        
        // Mostrem la mediana
        System.out.println("La mediana és: " + mediana);
        
        // Tanquem l'objecte Scanner
        scanner.close();
    }
}  