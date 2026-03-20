//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] p_args) {
        byte[] cartes = new byte[52];
        for (int i = 0; i < 52; i++) {
            cartes[i] = (byte) i;
        }
        mostrar(cartes[0]);
        escapca(cartes);
        mostrar(cartes[0]);
        System.out.println(cartes[0]);
    }

    public static void escapca(byte[] p_cartes) {
        byte posicio1, posicio2, aux;
        for (byte i = 0; i < 100; i++) {
            posicio1 = (byte) (Math.random() * 52);
            posicio2 = (byte) (Math.random() * 52);
            aux = p_cartes[posicio2];
            p_cartes[posicio2] = p_cartes[posicio1];
            p_cartes[posicio1] = aux;
            // System.out.println(aux);
        }
    }

    public static void mostrar(byte p_carta) {
        byte figura = (byte) (p_carta / 13);
        switch (figura) {
            case 0:
                System.out.println("Cor");
                break;
            case 1:
                System.out.println("Diamant");
                break;
            case 2:
                System.out.println("Piques");
                break;
            case 3:
                System.out.println("Trebol");
                break;
        }
        byte valor = (byte) (p_carta % 13);
        switch (valor) {
            case 0:
                System.out.println("As");
                break;
            case 10:
                System.out.println("Figura");
                break;
            case 11:
                System.out.println("Figura");
                break;
            case 12:
                System.out.println("Figura");
                break;
            default:
                System.out.println(valor + 1);
        }
    }
}
