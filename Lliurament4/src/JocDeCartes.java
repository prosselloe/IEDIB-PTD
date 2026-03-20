public class JocDeCartes {
    private Carta[] cartes;
    private int index;

    public JocDeCartes() {
        cartes = new Carta[52];
        char[] figures = {'C', 'D', 'P', 'T'};
        int k = 0;
        for (int i = 0; i < figures.length; i++) {
            for (byte valor = 0; valor <= 12; valor++) {
                cartes[k++] = new Carta(figures[i], valor);
            }
        }
        escapçarCartes();
        index = 0;
    }

    public void escapçarCartes() {
        for (int i = cartes.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Carta temp = cartes[i];
            cartes[i] = cartes[j];
            cartes[j] = temp;
        }
    }

    public Carta donarCarta() {
        if (index < cartes.length) {
            return cartes[index++];
        }
        return null;
    }
}