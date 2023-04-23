package view;

import entites.Reservation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReservationView extends JPanel {
    private JTable reservationTable;
    private JScrollPane scrollPane;

    public ReservationView(List<Reservation> reservations) {
        setLayout(new BorderLayout());

        String[] columnNames = {"Type", "ID Article", "Date et Heure", "ID Client"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        for (Reservation reservation : reservations) {
            Object[] rowData = {
                    reservation.getType(),
                    reservation.getIdArticle(),
                    sdf.format(reservation.getDateEtHeure()),
                    reservation.getIdClient()
            };
            tableModel.addRow(rowData);
        }

        reservationTable = new JTable(tableModel);
        reservationTable.setFillsViewportHeight(true);
        reservationTable.setRowHeight(30);
        reservationTable.setFont(new Font("Arial", Font.PLAIN, 14));
        reservationTable.setAutoCreateRowSorter(true);

        // Set table header font and size
        reservationTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        scrollPane = new JScrollPane(reservationTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}