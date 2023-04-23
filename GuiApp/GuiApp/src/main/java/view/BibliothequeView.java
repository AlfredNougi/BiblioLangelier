package view;

import entites.Bibliotheque;
import entites.Reservation;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BibliothequeView extends JPanel {
    private JLabel nomLabel;
    private JLabel adresseLabel;
    private JLabel numeroTelLabel;
    private JLabel heuresOuvertureLabel;
    private JLabel lienGoogleMapLabel;
    private Image backgroundImage;
    private JButton politiqueButton;
    private JButton objetEmpruntButton;
    private JButton gestionAbonnesButton;
    private JButton reservationsButton;
    private JButton activitesButton;

    public BibliothequeView(ImageIcon backgroundImage) {
        setLayout(new BorderLayout());

        nomLabel = new JLabel();
        adresseLabel = new JLabel();
        numeroTelLabel = new JLabel();
        heuresOuvertureLabel = new JLabel();
        lienGoogleMapLabel = new JLabel();
        politiqueButton = new JButton("Politique de la bibliothèque");
        objetEmpruntButton = new JButton("Articles à emprunté");
        gestionAbonnesButton = new JButton("Gestion des abonnés");
        reservationsButton = new JButton("Gestion des reservations");
        activitesButton = new JButton("Gestion des activités");
        

        JPanel textPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(0, 0, 0, 127)); // Translucent black color
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };

        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        textPanel.setOpaque(false);
        textPanel.add(nomLabel);
        textPanel.add(adresseLabel);
        textPanel.add(numeroTelLabel);
        textPanel.add(heuresOuvertureLabel);
        textPanel.add(lienGoogleMapLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 50)));

        politiqueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        politiqueButton.setPreferredSize(new Dimension(250, 50));
        buttonPanel.add(politiqueButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        objetEmpruntButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        objetEmpruntButton.setPreferredSize(new Dimension(250, 50));
        buttonPanel.add(objetEmpruntButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        gestionAbonnesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        gestionAbonnesButton.setPreferredSize(new Dimension(250, 50));
        buttonPanel.add(gestionAbonnesButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        activitesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        activitesButton.setPreferredSize(new Dimension(250, 50));
        buttonPanel.add(activitesButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        reservationsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        reservationsButton.setPreferredSize(new Dimension(250, 50));
        buttonPanel.add(reservationsButton);

        //modification de la police des buttons pour une meilleure ergonomie
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        politiqueButton.setFont(buttonFont);
        objetEmpruntButton.setFont(buttonFont);
        gestionAbonnesButton.setFont(buttonFont);
        activitesButton.setFont(buttonFont);
        reservationsButton.setFont(buttonFont);

        add(textPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setOpaque(false);
        this.backgroundImage = backgroundImage.getImage();

        // customisation de l'affichage de l'ecriture
        Font font = new Font("Arial", Font.BOLD, 18);
        Color textColor = Color.WHITE;
        nomLabel.setFont(font);
        nomLabel.setForeground(textColor);
        adresseLabel.setFont(font);
        adresseLabel.setForeground(textColor);
        numeroTelLabel.setFont(font);
        numeroTelLabel.setForeground(textColor);
        heuresOuvertureLabel.setFont(font);
        heuresOuvertureLabel.setForeground(textColor);
        lienGoogleMapLabel.setFont(font);
        lienGoogleMapLabel.setForeground(textColor);

        setupPolitiqueButtonActionListener();
        setupObjetsEmpruntButtonListener();
        setupGestionAbonnesButtonListener();
        setupRservationsButtonListener();
    }

    public void setBibliotheque(Bibliotheque bibliotheque) {
        nomLabel.setText("Nom : " + bibliotheque.getNom());
        adresseLabel.setText("Adresse : " + bibliotheque.getAdresse());
        numeroTelLabel.setText("Numéro de téléphone : " + bibliotheque.getNumeroTel());
        heuresOuvertureLabel.setText("Horaires d'ouverture : " + bibliotheque.getHeuresOuverture());
        lienGoogleMapLabel.setText("Lien google maps : " + bibliotheque.getLienGoogleMaps());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void setupPolitiqueButtonActionListener() {
        politiqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame politiqueFrame = new JFrame("Politique de la bibliothèque");
                PolitiqueView politiqueView = new PolitiqueView();
                politiqueFrame.add(politiqueView);
                politiqueFrame.setSize(800, 500);
                politiqueFrame.setLocationRelativeTo(null);
                politiqueFrame.setVisible(true);
            }
        });
    }

    private void setupObjetsEmpruntButtonListener() {
        objetEmpruntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame objetEmpruntFrame = new JFrame("Liste des articles empruntables");
                ObjetEmpruntView objetEmpruntView = new ObjetEmpruntView();
                objetEmpruntFrame.add(objetEmpruntView);
                objetEmpruntFrame.setSize(800, 600);
                objetEmpruntFrame.setLocationRelativeTo(null);
                objetEmpruntFrame.setVisible(true);
            }
        });
    }

    private void setupGestionAbonnesButtonListener() {
        gestionAbonnesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame abonneFrame = new JFrame("Gestion des abonnés");
                AbonneView abonneView = new AbonneView();
                abonneFrame.add(abonneView);
                abonneFrame.setSize(800, 600);
                abonneFrame.setLocationRelativeTo(null);
                abonneFrame.setVisible(true);
            }
        });
    }

    private void setupRservationsButtonListener() {
        reservationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // creer un liste de reservations
                List<Reservation> reservations = new ArrayList<>();
                reservations.add(new Reservation("Ipad", 1001, new Date(), 101));
                reservations.add(new Reservation("Ordinateur", 2002, new Date(), 102));
                reservations.add(new Reservation("Tablette", 3003, new Date(), 103));
                reservations.add(new Reservation("Casque VR", 1004, new Date(), 104));

                JFrame reservationFrame = new JFrame("Liste des réservations");
                ReservationView reservationView = new ReservationView(reservations);
                reservationFrame.add(reservationView);
                reservationFrame.setSize(800, 600);
                reservationFrame.setLocationRelativeTo(null);
                reservationFrame.setVisible(true);
            }
        });
    }
}



