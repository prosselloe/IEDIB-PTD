//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        char[] figures;
        byte[] cartes;
        figures = new char[52];
        cartes = new byte[52];
        char[] figuresJugador = new char[2];
        byte[] valorsJugador = new byte[2];
        char[] figuresCroupier = new char[2];
        byte[] valorsCroupier = new byte[2];
        char figuresAsignar[] = {'C', 'D', 'T', 'P'};
        // Generam cartes
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 13; j++) {
                figures[i * 13 + j] = figuresAsignar[i];
                cartes[i * 13 + j] = (byte) (j + 1);
            }
        escapca(cartes, figures);
        repartir(figures, cartes, (byte) 0, figuresJugador, valorsJugador);
        repartir(figures, cartes, (byte) 2, figuresCroupier, valorsCroupier);
        byte puntsJugador = puntua(valorsJugador);
        System.out.println("punts Jugador: " + puntsJugador);
        byte puntsCroupier = puntua(valorsCroupier);
        System.out.println("punts Croupier; " + puntsCroupier);
        System.out.println(guanyador(puntsCroupier, puntsJugador));
    }

    public static byte puntua(byte valors[]) {
        byte punts = 0;
        for (int i = 0; i < 2; i++) {
            switch (valors[i]) {
                case 1:
                    punts = (byte) (punts + 11);
                    break;
                case 11:
                    punts = (byte) (punts + 10);
                    break;
                case 12:
                    punts = (byte) (punts + 10);
                    break;
                case 13:
                    punts = (byte) (punts + 10);
                    break;
                default:
                    punts = (byte) (punts + valors[i]);
                    break;
            }
        }
        return punts;
    }

    public static void repartir(char[] figuresBaralla, byte[] valorsBaralla, byte index, char[] figuresMa, byte[] valorsMa) {
        for (int i = 0; i < 2; i++) {
            figuresMa[i] = figuresBaralla[index + i];
            valorsMa[i] = valorsBaralla[index + i];
        }
    }

    public static void escapca(byte[] p_cartes, char[] p_figures) {
        byte posicio1, posicio2, aux;
        char figura;
        for (byte i = 0; i < 100; i++) {
            posicio1 = (byte) (Math.random() * 52);
            posicio2 = (byte) (Math.random() * 52);
            aux = p_cartes[posicio2];
            figura = p_figures[posicio2];
            p_cartes[posicio2] = p_cartes[posicio1];
            p_cartes[posicio1] = aux;
            p_figures[posicio2] = p_figures[posicio1];
            p_figures[posicio1] = figura;
            // System.out.println(aux);
        }
    }

    public static String guanyador(byte puntsCroupier, byte puntsJugador) {
        if (puntsCroupier > puntsJugador)
            return ("Croupier");
        else if (puntsJugador > puntsCroupier)
            return ("Jugador");
        else return ("Empat");
    }
}
