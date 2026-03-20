//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lli5 {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        String[] Corredors = new String[2];
        float[] Temps = new float[2];

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
            Temps[0] = Float.parseFloat("-6");
            Corredors[1] = "Joan";
            Temps[1] = Float.parseFloat("5.5");

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