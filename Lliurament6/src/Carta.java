public class Carta {
    private final char figura;
    private final byte valor;
    private boolean mostra;
    private final String imatge;

    public String getImatge() {
        return imatge;
    }

    public byte getValor() {
        return valor;
    }

    public Carta(char p_fig, byte p_val) {
        figura = p_fig;
        valor = p_val;
        setMostra(false);
        String valor = Byte.toString((byte) (p_val + 1 ));
        imatge =  valor + Character.toLowerCase(p_fig) + ".png";
        System.out.println(imatge);

    }

    public void setMostra(boolean mostra) {
        this.mostra = mostra;
    }

    public void mostraCarta() {
    // Mostra el contingut de la carta si aquesta es pot mostrar (segons la propietat de la instància)
        String textFigura = "X";
        String textValor = "X";
        if (mostra) {
            switch (figura) {
                case 'C':
                    textFigura = "Cor";
                    break;
                case 'D':
                    textFigura = "Diamant";
                    break;
                case 'P':
                    textFigura = "Piques";
                    break;
                case 'T':
                    textFigura = "Trèvol";
                    break;
            }
            switch (valor) {
                case 0:
                    textValor = "As";
                    break;
                case 10:
                    textValor = "Figura";
                    break;
                case 11:
                    textValor = "Figura";
                    break;
                case 12:
                    textValor = "Figura";
                    break;
                default:
                    textValor = String.valueOf(valor + 1);
            }
            System.out.println(textValor + " de " + textFigura);
        }
    }

    public boolean isMostra() {
        return mostra;
    }

    public static void main(String[] args) {
        Carta c1 = new Carta('C', (byte) 0);
        System.out.println(c1.imatge);
    }
}
