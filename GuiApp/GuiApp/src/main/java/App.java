import java.awt.Dimension;
import javax.swing.*;

import view.BibliothequeView;
import entites.Bibliotheque;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageIcon backgroundImage = new ImageIcon(".\\ressources\\images\\biblio_langelier.jpg");

            BibliothequeView mainView = new BibliothequeView(backgroundImage);
            mainView.setBibliotheque(new Bibliotheque("Bibliotheque Langelier", "514-872-2640", " 6473 Rue Sherbrooke E, Montreal, QC H1N 1C5", "https://goo.gl/maps/veJAf4mCVVqHS26b9", "Lundi - Vendredi: 9h - 18h, Samedi: 10h - 14h"));
            JFrame frame = new JFrame("Gestion de la bibliothque Langelier");
            mainView.setPreferredSize(new Dimension(950, 700));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(mainView);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
