import java.time.LocalDate;
import java.util.Date;

public class Jugador {
    private String pais;
    private float alçada;
    private float pes;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getAlçada() {
        return alçada;
    }

    public void setAlçada(float alçada) {
        this.alçada = alçada;
    }

    public float getPes() {
        return pes;
    }

    public void setPes(float pes) {
        this.pes = pes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    private String nom;
    private LocalDate dataNaixement;

    public Jugador(String p_nom, String p_pais, float p_alçada, float p_pes, LocalDate p_dataNaixemnt) {
        pais = p_pais;
        alçada = p_alçada;
        nom = p_nom;
        pes = p_pes;
        dataNaixement = p_dataNaixemnt;

    }

    public Jugador(String p_nom , String p_pais) {
        nom = p_nom;
        pais = p_pais;
    }
}
