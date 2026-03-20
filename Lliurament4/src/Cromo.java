import java.time.LocalDate;

public class Cromo {
    private static int cromosNoMundial = 0;

    private final short posicioAlbum;
    private final String pais;
    private final int anyIncorporacio;
    private final double alcada; // in meters
    private final double pes; // in kilograms
    private final String posicio; // davanter, mig, defensa, porter
    private final String nom;
    private final LocalDate dataNaixement;

    // Constructor
    public Cromo(short posicioAlbum, String pais, int anyIncorporacio,
                 double alcada, double pes, String posicio, String nom, LocalDate dataNaixement) {
        this.posicioAlbum = posicioAlbum;
        if (Mundial.participaAlMundial2026(pais)){
            this.pais = pais;
            System.out.println("pais:" + pais + " Classificat");
        }
        else {
            this.pais ="XXX";
            cromosNoMundial++;
        }
        this.anyIncorporacio = anyIncorporacio;
        this.alcada = alcada;
        this.pes = pes;
        this.posicio = posicio;
        this.nom = nom;
        this.dataNaixement = dataNaixement;
    }

    public Cromo(short posicioAlbum, String pais) {
        this.posicioAlbum = posicioAlbum;
        this.pais = pais;
        this.anyIncorporacio = 0;
        this.alcada = 0;
        this.pes = 0;
        this.posicio = null;
        this.nom = null;
        this.dataNaixement = null;
    }

    // Getters
    public short getposicioAlbum() {
        return posicioAlbum;
    }

    public String getPais() {
        return pais;
    }

    public int getAnyIncorporacio() {
        return anyIncorporacio;
    }

    public double getAlcada() {
        return alcada;
    }

    public double getPes() {
        return pes;
    }

    public String getPosicio() {
        return posicio;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public static int getCromosNoMundial() {
    return cromosNoMundial;
}

    // toString method
    @Override
    public String toString() {
        return "Cromo{" +
                "pais='" + pais + '\'' +
                ", anyIncorporacio=" + anyIncorporacio +
                ", alcada=" + alcada +
                ", pes=" + pes +
                ", posicio='" + posicio + '\'' +
                ", nom='" + nom + '\'' +
                ", dataNaixement=" + dataNaixement +
                '}';
    }

    public static void main(String args[]) {
        Cromo c1, c2, c3, c4, c5;
        c1 = new Cromo ((short) 0, "esp", 2025, 1.76, 67,"P", "Pichford", LocalDate.of(2023, 12, 25));
        c2 = new Cromo ((short) 0, "ITL", 2025, 1.76, 67,"D", "Mbappe", LocalDate.of(2023, 12, 25));
        c3 = new Cromo ((short) 0, "USA", 2025, 1.76, 67,"M", "xxxx", LocalDate.of(2023, 12, 25));
        c4 = new Cromo ((short) 0, "MEX", 2025, 1.76, 67,"M", "M", LocalDate.of(2023, 12, 25));
        c5 = new Cromo ((short) 0, "CAN", 2025, 1.76, 67,"p", "M", LocalDate.of(2023, 12, 25));
        System.out.println("No classificats " + Cromo.getCromosNoMundial());
    }
}