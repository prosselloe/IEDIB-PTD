public class JugadorBlackJack extends Jugador {
    private Carta[] Ma = new Carta[11];
    private byte numCartes = 0;

    public byte getNumCartes() {
        return numCartes;
    }

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

    public void novaMa() {
        Ma = new Carta[11];
        numCartes = 0;
    }
}
