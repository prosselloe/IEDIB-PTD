import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Mundial {

    private static Pais[] paisosClassificats = {
            new Pais("USA"), new Pais("CAN"), new Pais("MEX"), new Pais("JPN"),
            new Pais("IRN"), new Pais("KOR"), new Pais("AUS"), new Pais("JOR"),
            new Pais("QAT"), new Pais("KSA"), new Pais("UZB"), new Pais("ALG"),
            new Pais("CPV"), new Pais("EGY"), new Pais("GHA"), new Pais("CIV"),
            new Pais("MAR"), new Pais("SEN"), new Pais("RSA"), new Pais("TUN"),
            new Pais("ENG"), new Pais("NZL"), new Pais("ARG"), new Pais("BRA"),
            new Pais("COL"), new Pais("ECU"), new Pais("PAR"), new Pais("URU"),
            null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null,
            null, null, null, null
    };

    public Mundial(){
        // Ruta del fitxer amb els registres
        String rutaFitxer = "mundial_2026_classificats.csv";

        try (BufferedReader lectorBuffer = new BufferedReader(new FileReader(rutaFitxer))) {
            String linia;

            // Llegir cada línia del fitxer
            int i = 0;
            while ((linia = lectorBuffer.readLine()) != null) {
                // Separar els camps utilitzant la coma com a delimitador
                String[] camps = linia.split(",");

                // Processar els camps
                String codi = camps[0];
                String grup = camps[1];

                paisosClassificats[i] = new Pais(codi, grup.charAt(0));
                i++;

                // Imprimir les dades del registre
                System.out.println("Codi: " + codi);
                System.out.println("Grup: " + grup);
                System.out.println();
            }

        } catch (IOException e) {
            // Capturar i gestionar l'excepció en cas que hi hagi problemes amb la lectura del fitxer
            // e.printStackTrace();
            System.err.println("S'ha produït un error d'E/S: " + e.getMessage());

        } finally {
            // fr.close();
        }

        // Inserim l'array paisosClassificats amb les dades carregades del fitxer .csv
        // a la taula paisos de la base de dades lliurament6
        inserirBD(new ArrayList<>(Arrays.asList(paisosClassificats)));
    }

    public static boolean participaAlMundial2026(String codiPais) {
        for (Pais pais : paisosClassificats) {
            if (pais != null) {
                if (pais.getCodi().equalsIgnoreCase(codiPais)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static short nombrePaisosClassificats() {
        // Retorna el nombre de paisos classificats
        return (short) paisosClassificats.length;
    }

    public static Pais getPais (short pais) {
        // Donat un index de pais retorna la codificació
        return paisosClassificats[pais];
    }

    public static boolean assignarPaisEnPosicio(Pais nouPais, int posicio) {
        if (nouPais == null) return false;
        if (posicio < 0 || posicio >= paisosClassificats.length)
            return false;

        paisosClassificats[posicio] = nouPais;
           return true;
    }

    public static void inserirBD (ArrayList<Pais> p_paisos) {

        final String URL = "jdbc:mysql://localhost:3306/lliurament6";
        final String USUARI = "root";
        // final String CONTRASENYA = "*";
        final String CONTRASENYA = "";

        // Crear la connexió a la base de dades
        try (Connection conn = DriverManager.getConnection(URL, USUARI, CONTRASENYA)) {
            // Crear la sentència SQL per inserir dades
            String sql = "INSERT INTO paisos (codi, nom, grup) VALUES (?, ?, ?)";

            // Crear un objecte PreparedStatement per executar la sentència SQL

            PreparedStatement stmt = conn.prepareStatement(sql);
            for (Pais pais: p_paisos) {
                try {   // Establir els paràmetres de la sentència SQL
                    if (pais != null) {
                        stmt.setString(1, pais.getCodi());
                        stmt.setString(2, pais.getNom());
                        stmt.setString(3, Character.toString(pais.getGrup()));

                        System.out.println(pais.getCodi() + ", " +
                                pais.getNom() + ", " +
                                Character.toString(pais.getGrup()));   // Mostram les dades del pais

                        // Executar la sentència SQL per inserir dades
                        int filesInserides = stmt.executeUpdate();
                        if (filesInserides > 0) {
                            System.out.println("S'han inserit les dades correctament.");
                        }
                    }
                } catch (SQLException e) {
                    // Capturar i gestionar errors de connexió o execució de SQL
                    e.printStackTrace();
                    System.out.println("No s'han pogut inserir les dades.");
                }

            }
        }
        catch (SQLException e) {
            // Capturar i gestionar errors de connexió o execució de SQL
            e.printStackTrace();
            System.out.println("No s'han pogut inserir les dades.");
        }
    }
}