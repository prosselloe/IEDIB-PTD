public class JugadorBlackJack extends Jugador {
    private Carta[] Ma = new Carta[11];
    private int numCartes = 0;

    public JugadorBlackJack(String p_nom, String p_pais) {
        super(p_nom, p_pais);
    }

    public void agafaCarta(Carta carta) {
        if (numCartes < Ma.length) {
            Ma[numCartes++] = carta;
        }
    }

    public Carta[] getMa() {
        return Ma;
    }
}