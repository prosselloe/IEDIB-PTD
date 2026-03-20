public class Carta {

    // Propietats o atributs de la Carta
    private char figura;
    private byte valor;
    private boolean mostra;

    // Constructor per inicialitzar els atributs
    public Carta(char figura, byte valor, boolean mostra) {
        this.figura = figura;
        this.valor = valor;
        this.mostra = mostra;
    }

    // Constructor per inicialitzar els atributs
    public Carta(char figura, byte valor) {
        this.figura = figura;
        this.valor = valor;
        this.mostra = false;
    }

    // Mètodes per accedir i modificar les dades de la Carta
    public char getFigura() {
        return figura;
    }

    public void setFigura(char figura) {
        this.figura = figura;
    }

    public byte getValor() {
        return valor;
    }

    public void setValor(byte valor) {
        this.valor = valor;
    }

    public boolean getMostra() {
        return mostra;
    }

    public void setMostra(boolean mostra) {
        this.mostra = mostra;
    }

    public void mostraCarta() {
        // Mostra el contingut de la carta si aquesta es pot mostrar (segons la propietat de la instància)
        String textFigura="X";
        String textValor ="X";
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
                    textValor = String.valueOf(valor);
            }

            System.out.println(textValor + " de " + textFigura);
        }
    }
}
