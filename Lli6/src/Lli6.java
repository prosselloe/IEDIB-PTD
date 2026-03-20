//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lli6 {

    public static boolean tempsCorrecte(float temps) {
        if (temps > 0) {
            return true;
        }
        else {
            System.out.println("El temps ha de ser mayor que zero!");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        String[] Corredors = new String[4];
        float[] Temps = new float[4];

        /*
        if (args.length < 4) {
            System.out.println("Número incorrecte de paràmetres!");
        } else {

            Corredors[0] = args[0];
            Temps[0] = Float.parseFloat(args[1]);
            Corredors[1] = args[2];
            Temps[1] = Float.parseFloat(args[3]);
            */

            Corredors[0] = "Pep";
            Temps[0] = Float.parseFloat("6");
            Corredors[1] = "Joan";
            Temps[1] = Float.parseFloat("5.5");
            Corredors[2] = "Lluis";
            Temps[2] = Float.parseFloat("7");
            Corredors[3] = "Pere";
            Temps[3] = Float.parseFloat("5");

            System.out.println("Correcte Temps[0] = : " + tempsCorrecte(Temps[0]));
            System.out.println("Correcte Temps[1] = : " + tempsCorrecte(Temps[1]));

            // Ordenam els arrays amb el mètode de la bimbolla.
            for (int i = 0; i < Temps.length - 1; i++) {
                for (int j = 0; j < Temps.length - 1 - i; j++) {
                    if (Temps[j] > Temps[j + 1]) {
                        float tempTemps = Temps[j];
                        String tempCorredors = Corredors[j];
                        Temps[j] = Temps[j + 1];
                        Corredors[j] = Corredors[j + 1];
                        Temps[j + 1] = tempTemps;
                        Corredors[j + 1] = tempCorredors;
                    }
                }
            }

            // Classificació ordenada de la carrera.
            for (int i = 0; i < Temps.length; i++) {
                System.out.println("Posició " + (i + 1) + ": " + Corredors[i] + " amb un temps de " + Temps[i]);
            }

            if ((Temps[0] < 0) || (Temps[1] < 0)) {
                System.out.println("El temps no pot tenir valors negatius!");
            } else {
                if (Temps[0] > Temps[1]) {
                    System.out.println("El guanyador és: " + Corredors[1] +
                            " amb un temps de: " + Float.toString(Temps[1]));
                    for (int i = 0; i < Temps.length; i++) {
                        if ((Temps[i] == Temps[1]) && (i != 1)) {
                            System.out.println("El guanyador és: " + Corredors[i] +
                                    " amb un temps de: " + Float.toString(Temps[i]));
                        }
                    }
                } else {
                    System.out.println("El guanyador és: " + Corredors[0] +
                            " amb un temps de: " + Float.toString(Temps[0]));
                    for (int i = 0; i < Temps.length; i++) {
                        if ((Temps[i] == Temps[0]) && (i != 0)) {
                            System.out.println("El guanyador és: " + Corredors[i] +
                                    " amb un temps de: " + Float.toString(Temps[i]));
                        }
                    }
                }
            }
        // }
    }
}