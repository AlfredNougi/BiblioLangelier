package view;

import javax.swing.*;

import entites.ExcelUtil;
import entites.ObjetEmprunt;
import entites.TypeObjetEmprunt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddObjetEmpruntDialog extends JDialog {
    private JTextField titreField;
    private JTextField auteurField;
    private JComboBox<TypeObjetEmprunt> typeComboBox;
    private JTextArea descriptionArea;
    private JButton addButton;
    private JButton cancelButton;

    public AddObjetEmpruntDialog(JFrame parentFrame) {
        super(parentFrame, "Ajouter un article", true);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("Titre:"));
        titreField = new JTextField();
        formPanel.add(titreField);

        formPanel.add(new JLabel("Auteur:"));
        auteurField = new JTextField();
        formPanel.add(auteurField);

        formPanel.add(new JLabel("Type:"));
        typeComboBox = new JComboBox<>(TypeObjetEmprunt.values());
        formPanel.add(typeComboBox);

        formPanel.add(new JLabel("Description:"));
        descriptionArea = new JTextArea();
        formPanel.add(descriptionArea);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Ajouter");
        buttonPanel.add(addButton);
        

        cancelButton = new JButton("Annuler");
        buttonPanel.add(cancelButton);

        

        add(buttonPanel, BorderLayout.SOUTH);
        setupAddButtonListener();

    }

    private void setupAddButtonListener(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titre = titreField.getText();
                String auteur = auteurField.getText();
                TypeObjetEmprunt type = (TypeObjetEmprunt) typeComboBox.getSelectedItem();
                String description = descriptionArea.getText();
                int id = ExcelUtil.generateUniqueId();
                ObjetEmprunt newObjetEmprunt = new ObjetEmprunt(titre, auteur, type, id, description, false);
                ExcelUtil.addObjetEmpruntToExcel(newObjetEmprunt);
                dispose();
            }
        });
    }
}
