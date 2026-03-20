import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Album {
    private Cromo[] album;
    private int cromosAferrats = 0;

    public int getCromosAferrats() {
        return cromosAferrats;
    }

    public Album() {
        album = new Cromo[864]; // Inicialitza l'array amb 864 elements
    }

    public Cromo[] cromosAferrats() {
        int i = 0;
        Cromo[] temp = new Cromo[864];
        for (Cromo cromo : album) {
            if (cromo != null) {
                temp[i] = cromo;
                i++;
            }
        }
        return temp;
    }

    private boolean aferrarCromo(Cromo cromo) {
        int posicio = cromo.getNumero() - 1;
        if (album[posicio] == null) {
            album[posicio] = cromo;
            cromosAferrats++;
            return true;
        }
        else {
            return false;
        }
    }

    public void aferrarPaquet(Paquet paquet) {
        int nombreCromos = paquet.getCromos().size();
        int apuntador = 0;
        for (int i = 0; i < nombreCromos; i++) {
            Cromo cromo = paquet.getCromos().get(apuntador);
            if (aferrarCromo(cromo)) {
                paquet.getCromos().remove(apuntador); // Remove the cromo from the paquet
            } else { apuntador++;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("paisos" + Mundial.nombrePaisosClassificats());
        Mundial.carregarPaisos("mundial_2026_classificats.csv");   // C

        Paquet P1 = new Paquet();   // Cream paquet
        System.out.println(P1.getCromos().size());   // Mostram el nombre de cromos del paquet
        Album A1 = new Album();
        A1.aferrarPaquet(P1);

        System.out.println(P1.getCromos().size());    // Mostram el nombre de cromos del paquet

        System.out.println("Cromos aferrats:");
        System.out.println("Album1:" + A1.getCromosAferrats());
    }
}
