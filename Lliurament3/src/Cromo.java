import java.time.LocalDate;

public class Cromo {

    // Propietats o atributs del Cromo
    private String seleccioPais;
    private short anySeleccio;
    private float alcada;
    private float pes;
    private String posicio;
    private String nom;
    private LocalDate dataNaixement; // LocalDate.of(2023, 12, 25)

    // Constructor per inicialitzar els atributs
    public Cromo(String seleccioPais, short anySeleccio, float alcada, float pes,
                 String posicio, String nom, LocalDate dataNaixement) {
        this.seleccioPais = seleccioPais;
        this.anySeleccio = anySeleccio;
        this.alcada = alcada;
        this.pes = pes;
        this.posicio = posicio;
        this.nom = nom;
        this.dataNaixement = dataNaixement;
    }

    // Mètodes per accedir i modificar les dades del Cromo
    public String getseleccioPais() {
        return seleccioPais;
    }

    public void setseleccioPais(String seleccioPais) {
        this.seleccioPais = seleccioPais;
    }

    public short getanySeleccio() {
        return anySeleccio;
    }

    public void setanySeleccio(short anySeleccio) {
        this.anySeleccio = anySeleccio;
    }

    public float getalcada() {
        return alcada;
    }

    public void setalcada(float alcada) {
        this.alcada = alcada;
    }

    public float getpes() {
        return pes;
    }

    public void setpes(float pes) {
        this.pes = pes;
    }

    public String getposicio() {
        return posicio;
    }

    public void setposicio(String posicio) {
        this.posicio = posicio;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public LocalDate getdataNaixement() {
        return dataNaixement;
    }

    public void setdataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    public boolean anyIncorporacio(short anyMundial) {
        boolean incorporat = false;
        if (this.anySeleccio <= anyMundial) {incorporat = true;}
        return incorporat;
    }
}
