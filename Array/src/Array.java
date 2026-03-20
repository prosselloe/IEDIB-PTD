//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Array {
    public static void main(String[] args) {
        byte serie = 52;
        byte[] serieNombres = new byte[serie];
        int i;

        // Inserció
        for (i = 0; i < serie; i = i + 1) {
            serieNombres[i] = (byte) ((serie - 1) - i);
        }

        // Consulta
        for (i = 0; i < serie; i = i + 1) {
            System.out.println(serieNombres[i]);
        }
    }
}