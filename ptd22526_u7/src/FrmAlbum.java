import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class FrmAlbum {
    private JPanel root;
    private JPanel Esquerra;
    private JPanel Central;
    private JPanel Dreta;
    private JLabel Bandera;
    private JButton Enrera;
    private JLabel CodiPais;
    private JLabel NumCromo;
    private JLabel Grup;
    private JButton Envant;
    int i = 0;

    public FrmAlbum() {
        Album A1 = new Album();              // Cream album
        Paquet P1 = new Paquet();            // Cream paquet
        A1.aferrarPaquet(P1);                // Aferram el paquet a l'album
        Cromo[] temp = A1.cromosAferrats();  // Recuperam només els cromos aferrats
        mostrarCromo(temp[i]);               // Mostram el primer cromo aferrat

        Enrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostram el cromo anterior si no és el primer
                if (i > 0) i--;
                mostrarCromo(temp[i]);
            }
        });

        Envant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostram el crono posterior si no és el darrer
                if (i < (A1.getCromosAferrats() - 1)) i++;
                mostrarCromo(temp[i]);
            }
        });
    }

    private void mostrarCromo(Cromo cromo) {
        URL url = FrmAlbum.class.getResource("/imatges/" + cromo.getPais().getCodi() + ".png");
        assert url != null;
        NumCromo.setText(String.valueOf(cromo.getNumero()));
        CodiPais.setText(cromo.getPais().getCodi());
        Bandera.setIcon(new ImageIcon(url));
        Grup.setText(String.valueOf(cromo.getPais().getGrup()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmAlbum");
        frame.setContentPane(new FrmAlbum().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
