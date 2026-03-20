import java.time.LocalDate;

public class Mundial {

    // Propietats o atributs del Mundial
    private short anyMundial;

    // Constructor per inicialitzar els atributs
    public Mundial(short anyMundial) {
        this.anyMundial = anyMundial;
    }

    public short getanyMundial() {
        return anyMundial;
    }

    public void setanyMundial(short anyMundial) {
        this.anyMundial = anyMundial;
    }

    public static boolean Classificat(String Pais) {
        String[] paisosClassificats = {"USA","CAN","MEX","JPN","IRN","KOR","AUS","JOR","QAT","KSA","UZB",
                "ALG","CPV","EGY","GHA","CIV","MAR","SEN","RSA","TUN","ENG","NZL","ARG","BRA","COL","ECU",
                "PAR","URU"};
        boolean classificat = false;
        for (String pais : paisosClassificats) {
            if (pais.equals(Pais)) {classificat = true;}
        }
        return classificat;
    }
}
