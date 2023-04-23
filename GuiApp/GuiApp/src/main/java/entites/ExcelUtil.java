package entites;

import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    private final static String EXCEL_FILE_PATH=".\\ressources\\biblio_langelier.xlsx";

    public static List<ObjetEmprunt> loadObjetsEmpruntFromExcel() {
        List<ObjetEmprunt> objetsEmprunt = new LinkedList<>();
        try (FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));
            Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("articles");
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                // columns: ID, Type, Title, estEmprunte  (change as needed)
                int id = (int) row.getCell(0).getNumericCellValue();
                TypeObjetEmprunt type = TypeObjetEmprunt.valueOf(row.getCell(1).getStringCellValue());
                String titre = row.getCell(2).getStringCellValue();
                String auteur = row.getCell(3).getStringCellValue();
                String desc = row.getCell(4).getStringCellValue();
                boolean estEmprunte = row.getCell(5).getBooleanCellValue();

                ObjetEmprunt objetEmprunt = new ObjetEmprunt(titre, auteur, type, id, desc, estEmprunte);
                objetsEmprunt.add(objetEmprunt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return objetsEmprunt;
    }

    public static void addObjetEmpruntToExcel(ObjetEmprunt objetEmprunt) {
        try (FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));
            Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("articles");
            int lastRowNum = sheet.getLastRowNum();
            Row newRow = sheet.createRow(lastRowNum + 1);

            newRow.createCell(0).setCellValue(objetEmprunt.getId());
            newRow.createCell(1).setCellValue(objetEmprunt.getType().toString());
            newRow.createCell(2).setCellValue(objetEmprunt.getTitre());
            newRow.createCell(3).setCellValue(objetEmprunt.getAuteur());
            newRow.createCell(4).setCellValue(objetEmprunt.getDescription());
            newRow.createCell(5).setCellValue(objetEmprunt.isEstEmprunte());

            try (FileOutputStream fos = new FileOutputStream(new File(EXCEL_FILE_PATH))) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int generateUniqueId(){
            int maxId = 0;
            for (ObjetEmprunt objetEmprunt : loadObjetsEmpruntFromExcel()) {
                maxId = Math.max(maxId, objetEmprunt.getId());
            }
            return maxId + 1;
    }
    

    public static void deleteObjetEmpruntById(int id) {
        try (FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));
            Workbook workbook = new XSSFWorkbook(fis)) {
    
            Sheet sheet = workbook.getSheet("articles");
            int rowNumToDelete = -1;
    
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                int rowId = (int) row.getCell(0).getNumericCellValue();
                if (rowId == id) {
                    rowNumToDelete = rowIndex;
                    break;
                }
            }
    
            if (rowNumToDelete != -1) {
                sheet.removeRow(sheet.getRow(rowNumToDelete));
                int lastRowNum = sheet.getLastRowNum();
                if (rowNumToDelete < lastRowNum) {
                    sheet.shiftRows(rowNumToDelete + 1, lastRowNum, -1);
                }
            }
    
            try (FileOutputStream fos = new FileOutputStream(new File(EXCEL_FILE_PATH))) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Abonne> loadAbonnesFromExcel() {
        List<Abonne> abonnes = new LinkedList<>();
        try (FileInputStream fis = new FileInputStream(new File(EXCEL_FILE_PATH));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet("abonnes");
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
    
                int id = (int) row.getCell(0).getNumericCellValue();
                String  firstName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                String email = row.getCell(4).getStringCellValue();
                String phoneNumber = row.getCell(4).getStringCellValue();
                String address = row.getCell(5).getStringCellValue();

                Abonne abonne = new Abonne(id, firstName, lastName, email, phoneNumber, address);
                abonnes.add(abonne);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return abonnes;
    }
}
