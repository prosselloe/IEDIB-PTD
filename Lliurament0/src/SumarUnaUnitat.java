import java.util.Scanner;

public class SumarUnaUnitat {
    public static void main(String[] args) {
        // Creem un objecte Scanner per llegir l'entrada de l'usuari
        Scanner scanner = new Scanner(System.in);
        
        // Demanem a l'usuari un nombre
        System.out.print("Introdueix un nombre: ");
        int num = scanner.nextInt();
        
        // Sumem una unitat al nombre
        int resultat = num + 1;
        
        // Mostrem el resultat
        System.out.println("El resultat de sumar una unitat a " + num + " és: " + resultat);
        
        // Tanquem l'objecte Scanner
        scanner.close();
    }
}  