package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PolitiqueView extends JScrollPane {

    private static final String INFOS_POLITIQUES_BIBLIO = 
    """
                                        POLITIQUES DE LA BIBLIOTHEQUE LANGELIER

    Limite d’emprunts:
        Les abonnés peuvent emprunter jusqu'à 5 documents à la fois pour une durée de 3 semaines.

    Renouvellement:
        Les documents peuvent être renouvelés une fois pour une durée supplémentaire de 3 semaines, à condition qu'ils ne soient pas réservés par un autre abonné.

    Retour de document:
        Les documents doivent être retournés dans la boîte de retour située à l'entrée de la bibliothèque ou directement au comptoir.

    Réservation:
        Les abonnés peuvent réserver jusqu'à 3 documents en même temps. Les documents réservés seront mis de côté pendant 7 jours avant d'être remis en circulation.

    Retard:
        En cas de retard, des pénalités de 0,50 $ par jour et par document seront appliquées. L'accès aux services de la bibliothèque peut être suspendu en cas de retard important.

    Documents perdus ou endommagés:
        Les abonnés sont responsables des documents empruntés. En cas de perte ou de dommage, des frais de remplacement ou de réparation seront exigés.
    """;

    public PolitiqueView() {
        Font font = new Font("Arial", Font.BOLD, 18);
        Color textColor = Color.WHITE;
        JTextArea politiqueTextArea = new JTextArea(INFOS_POLITIQUES_BIBLIO);
        politiqueTextArea.setFont(font);
        politiqueTextArea.setCaretColor(textColor);
        setViewportView(politiqueTextArea);
    }
}
