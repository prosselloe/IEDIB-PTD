import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Jugador {
    private  String pais;
    private  float alçada;
    private  float pes;
    private  String nom;
    private  LocalDate dataNaixement;

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

    public  Jugador(String p_nom, String p_pais, float p_alçada, float p_pes, LocalDate p_dataNaixemnt) {
        pais = p_pais;
        alçada = p_alçada;
        nom = p_nom;
        pes = p_pes;
        dataNaixement = p_dataNaixemnt;
    }

    public Jugador(String p_nom , String p_pais){
        nom = p_nom;
        pais = p_pais;
    }

    public void mostraJugador(){
        System.out.println(nom + " " + pais);
    }

    public static ArrayList<Jugador> llegirArxiu()  {
        ArrayList<Jugador> jugadors = new ArrayList<Jugador>();
        File arxiu = new File("src/partida.txt");
        System.out.println(arxiu.getAbsoluteFile());
        FileReader lectorFitxer;
        try {
            lectorFitxer = new FileReader(arxiu);
            BufferedReader lectorBuffer = new BufferedReader(lectorFitxer);
            String linia;
            int index = 0;
            while ((linia = lectorBuffer.readLine()) != null) {
                jugadors.add(llegeixJugador(linia));
                System.out.println(linia);
                index++;
            }
            lectorBuffer.close();  // Tancam arxiu
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }
        return jugadors;
    }

    private static Jugador llegeixJugador(String dades){
        String[] camps = dades.split(";");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaConvertida = null;
        try {
            // Converteix la cadena de data a un objecte LocalDate
            fechaConvertida = LocalDate.parse(camps[4], formatter);

            // Imprimeix el resultat
            System.out.println("Fecha convertida: " + fechaConvertida);
        } catch (Exception e) {
            // Maneja les excepcions si el format de la cadena no és correcte
            System.err.println("Error en la conversió de la cadena de data.");
            e.printStackTrace();
        }

        // Processar cada camp
        return new Jugador (camps[0],camps[1], Float.parseFloat(camps[2]), Float.parseFloat(camps[3]), fechaConvertida);
    }

    public static void main(String[] args) {
        System.out.println("Ara si!");
        Jugador.llegirArxiu();
   }
}
