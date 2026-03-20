import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paquet {
    private static final int CAPACITAT = 5;
    private  ArrayList<Cromo> cromos;
    private final String paisos[] = { "USA","MEX","CAN","JPN", "IRN", "UZB",
            "KOR", "JOR", "AUS","ARG", "BRA", "ECU","COL",  "URY",
            "PAR", "MAR","TUN", "EGY","ALG",
            "GHA", "CPV","ZAF", "SEN",
            "AUT","BEL","CRO",  "ENG",
            "FRA","GER","NED", "NOR",
            "POR","ESP","SUI","SCO"};

    public Paquet() {
    // Constructor que genera un paquet amb 5 cromos aleatoris
        cromos = new ArrayList<>();

        for (int i = 0; i < CAPACITAT; i++) {
            short pais = (short) (Math.random() * 864);
            Cromo c1 = new Cromo((short) (pais+1), this.pais(pais));
            cromos.add(c1);
        }
    }

    public List<Cromo> getCromos() {
        return cromos;
    }

    private String pais(short numero) {
     // Donat un nombre de cromo, ens retorna el pais corresponent
        byte index = (byte) (numero / 18);
        if (index > paisos.length - 1)
            index = 0;
        return paisos[index];
    }
}