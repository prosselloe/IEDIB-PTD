public class JugadorBlackJack1 extends Jugador {
    private Carta[] cartesMa = new Carta[11];
    private int index;

    public JugadorBlackJack1 (String p_nom , String p_pais){
        super(p_nom, p_pais);

    }

    public void agafaCarta(Carta carta){
        System.out.println("Carta: " + carta.getValor() + ", posició: " + index);
        cartesMa[index] = carta;
        index++;

    }
}
