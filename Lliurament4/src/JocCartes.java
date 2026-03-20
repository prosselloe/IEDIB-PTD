import java.util.Random;

public class JocCartes {
    private Carta[] cartes;
    private int index;

    public JocCartes() {
        cartes = new Carta[52];
        char[] figures = {'C', 'D', 'P', 'T'};
        int k = 0;
        for (char figura : figures) {
            for (byte valor = 0; valor < 13; valor++) {
                cartes[k++] = new Carta(figura, valor);
            }
        }
        index = 0;
        barrejar();
    }

    public void barrejar() {
        Random random = new Random();
        for (int i = cartes.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Carta temp = cartes[i];
            cartes[i] = cartes[j];
            cartes[j] = temp;
        }
    }

    public Carta repartir() {
        if (index < cartes.length) {
            return cartes[index++];
        } else {
            return null; // o llençar una excepció
        }
    }
public void escapçar() {
    for (int i = cartes.length - 1; i > 0; i--) {
        int j = (int) (Math.random() * (i + 1));
        Carta temp = cartes[i];
        cartes[i] = cartes[j];
        cartes[j] = temp;
    }
}
public byte calcularPuntuacio(Carta[] cartes) {
        int total = 0;
        int numAsos = 0;

        for (int i = 0; i < cartes.length; i++) {
            Carta carta = cartes[i];
            if (carta != null) {
                byte valor = carta.getValor();
                if (valor >= 10) {
                    total += 10; // J, Q, K valen 10 punts
                } else if (valor == 0) {
                    numAsos++;
                    total += 11; // Inicialment, comptem l'As com 11 punts
                } else {
                    total += valor + 1; // Les cartes de 2 a 10 valen el seu valor + 1
                }
            }
        }

        // Ajustem el valor dels Asos si el total supera 21
        while (total > 21 && numAsos > 0) {
            total -= 10;
            numAsos--;
        }

        return (byte) total;
    }
 public void mostrarGuanyador(byte puntuacioJugador, byte puntuacioCroupier) {
        if (puntuacioJugador > 21) {
            System.out.println("Jugador perd.");
        } else if (puntuacioCroupier > 21 || puntuacioJugador > puntuacioCroupier) {
            System.out.println("Jugador guanya.");
        } else if (puntuacioJugador < puntuacioCroupier) {
            System.out.println("Croupier guanya.");
        } else {
            System.out.println("Empat. Croupier guanya.");
        }
    }
}

