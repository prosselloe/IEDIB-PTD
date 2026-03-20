//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SumaMatrius {
    public static void main(String[] args) {
        // Definim dues matrius
        int[][] matriu1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matriu2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        // Cridem una funció per a sumar les dues matrius
        int[][] resultat = sumarMatrius(matriu1, matriu2);

        // Mostrem el resultat
        mostrarMatriu(resultat);
    }

    // Funció per a sumar dues matrius
    public static int[][] sumarMatrius(int[][] matriu1, int[][] matriu2) {
        int files = matriu1.length;
        int columnes = matriu1[0].length;

        int[][] resultat = new int[files][columnes];

        int j = 0;
        for (int i = 0; i < files; i++) {
            // for (int j = 0; j < columnes; j++) {
            for (int numero : matriu2[i]) {
                resultat[i][j] = matriu1[i][j] + numero;
                j++;
            }
        }

        return resultat;
    }

    // Funció per a mostrar una matriu
    public static void mostrarMatriu(int[][] matriu) {
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                System.out.print(matriu[i][j] + " ");
            }
            System.out.println(); // Nova línia per a cada fila
        }
    }
}