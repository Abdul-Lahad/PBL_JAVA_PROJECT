import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;

public class Database {

    public void Display_All_data() {

        try {
            File file = new File("database.xlsx"); // creating a new file instance
            FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
            // creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator(); // iterating over excel file
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING: // field that represents string cell type
                            System.out.print(cell.getStringCellValue() + "\t\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
                            System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                    }
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ReadCellData(int vRow, int vColumn) {
        String value = null; // variable for storing the cell value
        Workbook wb = null; // initialize Workbook null
        try {
            // reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("database.xlsx");
            // constructs an XSSFWorkbook object, by buffering the whole stream into the
            // memory
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0); // getting the XSSFSheet object at given index
        Row row = sheet.getRow(vRow); // returns the logical row
        Cell cell = row.getCell(vColumn); // getting the cell representing the given column

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING: // field that represents string cell type
                System.out.print(cell.getStringCellValue() + "\t\t\t");
                break;
            case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
                System.out.print(cell.getNumericCellValue() + "\t\t\t");
                break;
            default:
        }

    }

    public void column_display(int column_no) {
        Workbook wb = null; // initialize Workbook null
        try {
            FileInputStream fis = new FileInputStream("database.xlsx");
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0); // getting the XSSFSheet object at given index

        Iterator<Row> itr = sheet.iterator(); // iterating over excel file

        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column

            Cell cell = row.getCell(column_no);

            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING: // field that represents string cell type
                    System.out.print(cell.getStringCellValue() + "\t\t\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
                    System.out.print(cell.getNumericCellValue() + "\t\t\t");
                    break;
                default:
            }

        }

    }

    public double highest_valu_of_NO(int column_no) {
        double high = 0.0;
        String value = null; // variable for storing the cell value
        Workbook wb = null; // initialize Workbook null
        try {
            // reading data from a file in the form of bytes
            FileInputStream fis = new FileInputStream("database.xlsx");
            // constructs an XSSFWorkbook object, by buffering the whole stream into the
            // memory
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0); // getting the XSSFSheet object at given index

        Iterator<Row> itr = sheet.iterator(); // iterating over excel file

        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column

            Cell cell = row.getCell(column_no);

            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING: // field that represents string cell type
                    System.out.print(cell.getStringCellValue() + "\t\t\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
                    if (cell.getNumericCellValue() > high) {
                        high = cell.getNumericCellValue();
                    }
                    break;
                default:
            }

        }

        return high;
    }

    public list column_return(int column_no) {

        list l1 = new list();

        Workbook wb = null; // initialize Workbook null
        try {
            FileInputStream fis = new FileInputStream("database.xlsx");
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0); // getting the XSSFSheet object at given index

        Iterator<Row> itr = sheet.iterator(); // iterating over excel file

        while (itr.hasNext()) {
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
            Cell cell = row.getCell(column_no);

            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_STRING: // field that represents string cell type
                    l1.add(cell.getStringCellValue());

                    break;
                case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
                    l1.add(cell.getNumericCellValue());
                    break;
                default:
            }

        }
        return l1;

    }
    
    public void inserting_data() {
        // File xlsxFile = new File("C:\\Users\\aa\\Desktop\\test.xlsx");
        

    }

}