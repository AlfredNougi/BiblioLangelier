package view;

import entites.Abonne;
import entites.ExcelUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AbonneView extends JPanel {
    private JTable abonneTable;
    private JScrollPane scrollPane;

    public AbonneView() {
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Prenom", "Nom", "Email", "Phone", "Adress"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        List<Abonne> abonnes = ExcelUtil.loadAbonnesFromExcel();
        for (Abonne abonne : abonnes) {
            Object[] rowData = {
                    abonne.getId(),
                    abonne.getPrenom(),
                    abonne.getNom(),
                    abonne.getEmail(),
                    abonne.getPhone(),
                    abonne.getAdress()
            };
            tableModel.addRow(rowData);
        }

        abonneTable = new JTable(tableModel);
        abonneTable.setFillsViewportHeight(true);
        abonneTable.setRowHeight(30);
        abonneTable.setFont(new Font("Arial", Font.PLAIN, 14));
        abonneTable.setAutoCreateRowSorter(true);

        // Set table header font and size
        abonneTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        scrollPane = new JScrollPane(abonneTable);
        add(scrollPane, BorderLayout.CENTER);
    }
    
}
