//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int N = 5;
        int P = 1;
        System.out.println("Calcular factorial del número: " + N);

        if (N < 0) {
            // If the number is less than 0, reject it.
            System.out.println("Número negativo. Prueba con positivos.");
        } else if (N == 0) {
            // If the number is 0, its factorial is 1.
            System.out.println("Factorial de 0 igual a 1.");
        } else {
            for (int i = N; i > 1; i--) {
                //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
                // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
                P = P * N;
                N = N - 1;
            }
            System.out.println("Factorial = " + P);
        }
    }
}