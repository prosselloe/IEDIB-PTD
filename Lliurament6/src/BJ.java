import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BJ {
    private JLabel Carta1;
    private JLabel Carta2;
    private JLabel Carta3;
    private JLabel Carta4;
    private JPanel root;
    private JLabel Croupier1;
    private JLabel Croupier2;
    private JLabel Croupier3;
    private JLabel Croupier4;
    private JButton inicialitzarButton;
    private JPanel rootPrin;
    private JButton novaCartaButton;
    private JButton plantarButton;
    private JLabel nomJugador;
    private JLabel nomCroupier;
    private int partida = 0;
    private int jugadors = 0;

    JocCartes joc = new JocCartes();
    JugadorBlackJack jugador = new JugadorBlackJack("Jugador", "Espanya");
    Croupier croupier = new Croupier("Croupier", "Italia");

    public static void main(String[] args) {
        JFrame frame = new JFrame("BJ");
        frame.setSize(800, 600);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new BJ().rootPrin);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public BJ() {
        inicialitzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joc.novaPartida();
                jugador.novaMa();
                croupier.novaMa();

                // Comprovam que el número de partida no superi al de possibles jugadors
                if (partida >= jugadors) { partida = 0; }
                partida++;

                // Ruta del fitxer amb els registres
                String rutaFitxer = "src/partida.txt";

                // Carregam l'arxiu "partida.txt"
                try (BufferedReader lectorBuffer = new BufferedReader(new FileReader(rutaFitxer))) {
                    String linia;

                    // Llegir cada línia del fitxer
                    int i = 0;
                    while ((linia = lectorBuffer.readLine()) != null) {
                        // Separar els camps utilitzant el punt i coma com a delimitador
                        String[] camps = linia.split(";");

                        // Processar els camps
                        String nom = camps[0];
                        String pais = camps[1];
                        float alçada = Float.parseFloat(camps[2]);
                        float pes = Float.parseFloat(camps[3]);
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                        LocalDate dataNaixement = LocalDate.parse(camps[4], dateFormatter);

                        // El Croupier és sempre el primer (0), el Jugador canvia cada nova partida
                        if (i == 0) {
                            croupier.setNom(nom);
                            croupier.setPais(pais);
                        } else if (i == partida) {
                            jugador.setNom(nom);
                            jugador.setPais(pais);
                        }

                        /*
                        // Imprimir les dades del registre
                        System.out.println();
                        System.out.println("Nom: " + nom);
                        System.out.println("Codi Pais: " + pais);
                        System.out.println("Alçada: " + alçada);
                        System.out.println("Pes: " + pes);
                        System.out.println("Data Naixement: " + dataNaixement);
                        */

                        jugadors = i;
                        i++;
                    }
                } catch (IOException e1) {
                    // Capturar i gestionar l'excepció en cas que hi hagi problemes amb la lectura del fitxer
                    e1.printStackTrace();
                }

                // Assignam el nom del Jugador i el del Croupier
                nomJugador.setText(jugador.getNom());
                nomCroupier.setText(croupier.getNom());

                Carta cartaJugador1 = joc.repartir();
                Carta cartaJugador2 = joc.repartir();
                jugador.agafaCarta(cartaJugador1);
                jugador.agafaCarta(cartaJugador2);

                Carta3.setIcon(null);
                Carta4.setIcon(null);
                Croupier3.setIcon(null);
                Croupier4.setIcon(null);

                URL url = this.getClass().getResource("/imatges/" + cartaJugador1.getImatge());
                ImageIcon icon1 = new ImageIcon(url);

                Carta1.setIcon(icon1);
                URL url2 = this.getClass().getResource("/imatges/" + cartaJugador2.getImatge());
                ImageIcon icon2 = new ImageIcon(url2);
                Carta2.setIcon(icon2);

                //Carta2.setText(cartaJugador2.getImatge());

                Carta cartaCroupier1 = joc.repartir();
                Carta cartaCroupier2 = joc.repartir();

                URL url3 = this.getClass().getResource("/imatges/" + cartaCroupier1.getImatge());
                ImageIcon icon1C = new ImageIcon(url3);
                Croupier1.setIcon(icon1C);

                URL url4 = this.getClass().getResource("/imatges/dorso.png");
                ImageIcon icon2C = new ImageIcon(url4);

                Croupier2.setIcon(icon2C);

                croupier.agafaCarta( cartaCroupier1);
                croupier.agafaCarta( cartaCroupier2);
                Carta1.setText("");
                Carta2.setText("");
                Carta3.setText("");
                Carta4.setText("");

                Croupier1.setText("");
                Croupier2.setText("");
                Croupier3.setText("");
                Croupier4.setText("");
                novaCartaButton.setEnabled(true);
                plantarButton.setEnabled(true);
            }
        });
        plantarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                novaCartaButton.setEnabled(false);
                plantarButton.setEnabled(false);
                Carta cartaCroupier2 = croupier.getMa()[1];
                URL url = this.getClass().getResource("/imatges/" + cartaCroupier2.getImatge());
                ImageIcon icon2C = new ImageIcon(url);
                Croupier2.setIcon(icon2C);
                croupier.getMa()[1].setMostra(true);

                byte puntuacioJugador = joc.calcularPuntuacio(jugador.getMa(), jugador.getNumCartes());
                byte puntuacioCroupier = joc.calcularPuntuacio(croupier.getMa(), croupier.getNumCartes());

                while (puntuacioCroupier < 17) {
                    Carta cartaCroupier3 = joc.repartir();
                    croupier.agafaCarta(cartaCroupier3);
                    url = this.getClass().getResource("/imatges/" + cartaCroupier3.getImatge());
                    ImageIcon icon3C = new ImageIcon(url);
                    switch (croupier.getNumCartes())
                    {
                        case 3:
                            Croupier3.setIcon(icon3C);
                            break;
                        case 4:
                            Croupier4.setIcon(icon3C);
                            break;
                    }
                    puntuacioCroupier = joc.calcularPuntuacio(croupier.getMa(), croupier.getNumCartes());
                }
                if (puntuacioCroupier > 21 || puntuacioJugador > puntuacioCroupier) {
                    JOptionPane.showMessageDialog(null, "Has guanyat!");
                } else if (puntuacioJugador == puntuacioCroupier) {
                    JOptionPane.showMessageDialog(null, "Empat!");
                } else {
                    JOptionPane.showMessageDialog(null, "Has perdut!");
                }
            }
        });

        novaCartaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Carta cartaJugador3 = joc.repartir();

                jugador.agafaCarta(cartaJugador3);
                URL url = this.getClass().getResource("/imatges/" + cartaJugador3.getImatge());

                ImageIcon icon3 = new ImageIcon(url);

                switch (jugador.getNumCartes())
                {
                    case 3:
                        Carta3.setIcon(icon3);
                        break;
                    case 4:
                        Carta4.setIcon(icon3);
                        break;
                }
                byte puntuacioJugador = joc.calcularPuntuacio(jugador.getMa(), jugador.getNumCartes());
                if (puntuacioJugador > 21) {
                    JOptionPane.showMessageDialog(null, "Has perdut!");
                    novaCartaButton.setEnabled(false);
                    plantarButton.setEnabled(false);
                }
            }
        });
    }
}
