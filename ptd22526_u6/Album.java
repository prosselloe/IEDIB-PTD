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

        /*
        System.out.println("paisos: " + Mundial.nombrePaisosClassificats());
        if (args.length == 1) {
            // Ens passen un argument
            try {
                FileReader llegir = new FileReader(args[0]);
                BufferedReader br = new BufferedReader(llegir);
                String linia;
                int pos =0;
                while ((linia = br.readLine()) != null) {
                    // Separar els camps utilitzant la coma com a delimitador
                    String[] camps = linia.split(",");
                    System.out.println(camps[0] + " - " + camps[1]);
                    Pais p1 = new Pais(camps[0], camps[1].charAt(0));
                    Mundial.assignarPaisEnPosicio(p1, pos);
                    pos++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("No s'ha trobat el fitxer: " + args[0]);
            } catch (IOException e) {
                System.out.println("Error en llegir línia: ");
            }
        }
        */

        Mundial M1 = new Mundial();   // Cream mundial
        System.out.println("ESP:" + Mundial.participaAlMundial2026("ESP"));

        Paquet P1 = new Paquet();   // Cream paquet
        System.out.println(P1.getCromos().size());   // Mostram el nombre de cromos del paquet
        Album A1 = new Album();
        Album A2 = new Album();
        A1.aferrarPaquet(P1);

        System.out.println(P1.getCromos().size());    // Mostram el nombre de cromos del paquet

        A2.aferrarPaquet(P1);
        System.out.println("Cromos aferrats:");
        System.out.println("Album1:" + A1.getCromosAferrats());
        System.out.println("Album2:" + A2.getCromosAferrats());
    }
}

