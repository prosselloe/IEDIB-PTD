import java.time.LocalDate;

public class Cromo {
    private  short numero;
    private static int cromosNoMundial = 0;
    private final Pais pais;
    private  int anyIncorporacio;
    private  double alcada; // in meters
    private  double pes; // in kilograms
    private  String posicio; // davanter, mig, defensa, porter
    private  String nom;
    private  LocalDate dataNaixement;

    public short getNumero() {
        return numero;
    }

    // Constructor
    public Cromo(Pais pais, int anyIncorporacio, double alcada, double pes, String posicio, String nom, LocalDate dataNaixement) {

        this.anyIncorporacio = anyIncorporacio;
        this.alcada = alcada;
        this.pes = pes;
        this.posicio = posicio;
        this.nom = nom;
        this.dataNaixement = dataNaixement;
        this.pais = pais;
        this.numero = 0;
    }

    public Cromo(short numero, Pais pais) {

        this.numero = numero;
        this.pais = pais;
    }

    // Getters
    public Pais getPais() {
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
}