import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        JugadorBlackJack1 jugador1 = new JugadorBlackJack1((String) "Pere Rosselló", (String) "Esp");
        Carta carta1 = new Carta('C', (byte) 0);
        jugador1.agafaCarta(carta1);
        Carta carta2 = new Carta('P', (byte) 13);
        jugador1.agafaCarta(carta2);

        // Creació d'objectes Carta1
        /*
        Carta carta1 = new Carta('C', (byte) 0);
        carta1.mostraCarta();
        Carta carta2 = new Carta('P', (byte) 13, true);
        carta2.mostraCarta();
        */

        /*
        boolean classificat;
        Mundial mundial = new Mundial((short)2026);
        byte numNoClassificats = 0;

        Cromo cromo1 = new Cromo((String) "ESP", (short) 2023, (float) 1.80, (float) 72,
                (String) "Davanter", (String) "Lamine Yamal", (LocalDate)
                LocalDate.of(2007, 7, 13));
        System.out.println(cromo1.getseleccioPais() + " - " +
                mundial.Classificat(cromo1.getseleccioPais()));
        if (!mundial.Classificat(cromo1.getseleccioPais())) {numNoClassificats++;};

        Cromo cromo2 = new Cromo((String) "ARG", (short) 2005, (float) 1.70, (float) 72,
                (String) "Davanter", (String) "Leo Messi", (LocalDate)
                LocalDate.of(1987, 6, 24));
        System.out.println(cromo2.getseleccioPais() + " - " +
                mundial.Classificat(cromo2.getseleccioPais()));
        if (!mundial.Classificat(cromo2.getseleccioPais())) {numNoClassificats++;};

        Cromo cromo3 = new Cromo((String) "POL", (short) 2008, (float) 1.85, (float) 81,
            (String) "Davanter", (String) "Robert Lewandowski", (LocalDate)
            LocalDate.of(1988, 8, 21));
        System.out.println(cromo3.getseleccioPais() + " - " +
                mundial.Classificat(cromo3.getseleccioPais()));
        if (!mundial.Classificat(cromo3.getseleccioPais())) {numNoClassificats++;};

        Cromo cromo4 = new Cromo((String) "FRA", (short) 2016, (float) 1.78, (float) 67,
                (String) "Davanter", (String) "Ousmane Dembélé", (LocalDate)
                LocalDate.of(1997, 5, 15));
        System.out.println(cromo4.getseleccioPais() + " - " +
                mundial.Classificat(cromo4.getseleccioPais()));
        if (!mundial.Classificat(cromo4.getseleccioPais())) {numNoClassificats++;};

        Cromo cromo5 = new Cromo((String) "ESP", (short) 2018, (float) 1.90, (float) 82,
                (String) "Mig", (String) "Rodri Hernández", (LocalDate)
                LocalDate.of(1996, 6, 22));
        System.out.println(cromo5.getseleccioPais() + " - " +
                mundial.Classificat(cromo5.getseleccioPais()));
        if (!mundial.Classificat(cromo5.getseleccioPais())) {numNoClassificats++;};

        System.out.println(numNoClassificats);
        */
    }
}