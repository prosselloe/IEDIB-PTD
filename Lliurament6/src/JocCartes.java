import java.util.Random;
import java.util.Scanner;

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

    public void novaPartida() {
        index = 0;
        escapçar();
    }

    public void mostrarCartes(Carta[] cartes) {
        for (int i = 0; i < cartes.length; i++) {
            if (cartes[i] != null) {
                cartes[i].mostraCarta();
            }
        }
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

    public byte calcularPuntuacio(Carta[] cartes, byte numCartes) {
        int total = 0;
        int numAsos = 0;
        for (int i = 0; i < numCartes; i++) {
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

    public static void main(String[] args) {
        JocCartes baralla = new JocCartes();
        baralla.escapçar();
        JugadorBlackJack jugador = new JugadorBlackJack("Jugador", "Pais");
        Croupier croupier = new Croupier("Croupier", "Casino");

        // Deal 2 cards to the player
        Carta cartaJugador1 = baralla.repartir();
        Carta cartaJugador2 = baralla.repartir();
        jugador.agafaCarta(cartaJugador1);
        jugador.agafaCarta(cartaJugador2);

        // Show player's cards
        cartaJugador1.setMostra(true);
        cartaJugador2.setMostra(true);
        System.out.println("Cartes del jugador:");
        baralla.mostrarCartes(jugador.getMa());

        // Deal 2 cards to the dealer
        Carta cartaCroupier1 = baralla.repartir();
        Carta cartaCroupier2 = baralla.repartir();
        croupier.agafaCarta(cartaCroupier1);
        croupier.agafaCarta(cartaCroupier2);

        // Show dealer's cards
        cartaCroupier1.setMostra(true);
        System.out.println("Cartes Croupier:");
        baralla.mostrarCartes(croupier.getMa());

        // Ask the player if they want another card while their score is less than 21
        Scanner scanner = new Scanner(System.in);
        while (baralla.calcularPuntuacio(jugador.getMa(), jugador.getNumCartes()) < 21) {
            System.out.print("Vols una altra carta? (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (resposta.equals("S")) {
                Carta novaCarta = baralla.repartir();
                jugador.agafaCarta(novaCarta);
                novaCarta.setMostra(true);
                System.out.println("Cartes del jugador:");
                baralla.mostrarCartes(jugador.getMa());
            } else if (resposta.equals("N")) {
                break;
            } else {
                System.out.println("Resposta no vàlida. Si us plau, respon amb 'S' o 'N'.");
            }
        }
        cartaCroupier2.setMostra(true);
        System.out.println("Cartes Croupier:");
        baralla.mostrarCartes(croupier.getMa());

        // Calculate player's score
        byte puntuacioJugador = baralla.calcularPuntuacio(jugador.getMa(), jugador.getNumCartes());
        byte puntuacioCroupier = baralla.calcularPuntuacio(croupier.getMa(), croupier.getNumCartes());

        // Determine the winner
        baralla.mostrarGuanyador(puntuacioJugador, puntuacioCroupier);
        scanner.close();
    }
}
