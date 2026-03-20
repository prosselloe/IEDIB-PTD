//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte serie = 20;
        boolean[] ColeccioGalactica = new boolean[serie];
        String SiNo = "";
        int i;
        byte Cromo;

        // byte[] Repetits = {};
        byte[] Repetits = new byte[serie];
        int j = 0;

        // Inserció de valors per defecte
        // No és necessària ja que ho fa automàticament pels booleans!
        /*
        for (i = 0; i < serie; i = i + 1) {
            ColeccioGalactica[i] = false;
        }
        */

        // Creem un objecte Scanner per llegir l'entrada de l'usuari
        Scanner scanner = new Scanner(System.in);

        String comprar = "S";
        while (comprar.equals("S") || comprar.equals("s")) {

            // Comprar paquet de cromos
            for (i = 0; i < 5; i = i + 1) {
                byte randomNum = (byte) (Math.random() * (serie - 1)); // 0 to serie - 1
                Cromo = (byte) (randomNum + 1);
                if (randomNum % 5 == 0) {
                    System.out.println("Cromo defectuós: " + randomNum);
                } else {
                    if (ColeccioGalactica[randomNum]) {
                        // Repetits = Arrays.copyOf(Repetits, Repetits.length + 1);
                        // Repetits[Repetits.length - 1] = randomNum;
                        Repetits[j] = Cromo;
                        System.out.println("Cromo repetit[" + j + "]:" + randomNum);

                        // Prevenim el desbordament de l'array Repetits.
                        if (j < (serie - 1)) {j++;} else {j = 0;};
                    } else {
                        ColeccioGalactica[randomNum] = true;
                    }
                }
            }

            // Llegim resposta introduida per l'usuari
            System.out.print("Vols comprar més cromos (S/N)? ");
            comprar = scanner.nextLine();
        }

        // Tancam l'objecte Scanner
        scanner.close();

        // Estat de l'àlbum:
        System.out.println("Estat de l'àlbum:");
        for (i = 0; i < serie; i = i + 1) {
            if (ColeccioGalactica[i]) {SiNo = "Si";} else {SiNo = "No";};
            // System.out.println(format( "%02d", i + 1) + ": " + SiNo);
            System.out.println(i + 1 + ": " + SiNo);
        }

        // Cromos repetits:
        System.out.println("Cromos repetits:");
        // for (i = 0; i < Repetits.length; i = i + 1) {
        // for (i = 0; i < j; i = i + 1) {

        // Per si s'ha produit el desbordament de l'array Repetits i < serie en lloc de i < j;.
        for (i = 0; i < serie; i = i + 1) {
            // System.out.print((Repetits[i] + 1) + ", ");
            // System.out.println(format("%02d", Repetits[i] + 1));

            // Per imprimir només els Repetits amb valor (recordar que 0 és defectuós).
            if (Repetits[i] != 0) {
                System.out.println(Repetits[i] + 1);
            }
        }
    }
}