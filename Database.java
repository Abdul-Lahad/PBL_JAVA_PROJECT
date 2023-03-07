import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
import org.apache.poi.xssf.usermodel.XSSFRow;
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

    public list column_return(int column_no,String Filename) {

        list l1 = new list();

        Workbook wb = null; // initialize Workbook null
        try {
            FileInputStream fis = new FileInputStream(Filename+".xlsx");
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
    
    
    

         public void insert_excel(list l1,list l2,list l3) throws Exception
         {          

                node temp1=l1.head, temp2=l2.head , temp3=l3.head;
     
                 //Create blank workbook
                 XSSFWorkbook workbook = new XSSFWorkbook();
                 
                 //Create a blank sheet
                 XSSFSheet spreadsheet = workbook.createSheet( " Employee Info ");
           
                 //Create row object
                 XSSFRow row;
           
                
                 int rowid = 0;
                 Object o="";


                 while(temp3!=null){
                    int col=0;
                    String s;

                    row = spreadsheet.createRow(rowid++);

                        s= String.valueOf(temp1.data);       
                       Cell cell = row.createCell(col);
                       if(s.equals("") || !isLetter(s.charAt(0))){
                        s="NOT";
                         }
                       cell.setCellValue(s);
                    
                       col++;
                      s=String.valueOf(temp2.data);
                       Cell cell1 = row.createCell(col);
                       if(s.equals("") || !isLetter(s.charAt(0))){
                        s="NOT";
                         }
                       cell1.setCellValue(s);

                       col++;
                       s= String.valueOf(temp3.data);
                       Cell cell2 = row.createCell(col);
                       if(s.equals("") || !isLetter(s.charAt(0))){
                            s="NOT";
                             }
                        cell2.setCellValue(s);

                       temp1=temp1.next;
                       temp2=temp2.next;
                       temp3=temp3.next;


                    }

                 //Write the workbook in file system
                 FileOutputStream out = new FileOutputStream(
                    new File("Writesheet.xlsx"));
                 
                 workbook.write(out);
                 out.close();
                 System.out.println("Writesheet.xlsx written successfully");
              }  
              
              boolean isLetter(char ch){
                return (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z');       
              }

              public void insert_excel(list l1,list l2,list l3,list l4,list l5,list l6,list l7,list l8) throws Exception
         {          

                node temp1=l1.head, temp2=l2.head , temp3=l3.head,temp4=l4.head, temp5=l5.head , temp6=l6.head,temp7=l7.head, temp8=l8.head ;
     
                 //Create blank workbook
                 XSSFWorkbook workbook = new XSSFWorkbook();
                 
                 //Create a blank sheet
                 XSSFSheet spreadsheet = workbook.createSheet( " Employee Info ");
           
                 //Create row object
                 XSSFRow row;
           
                
                 int rowid = 0;
                 Object o="";


                 while(temp3!=null){
                    int col=0;
                    String s;

                    row = spreadsheet.createRow(rowid++);

                        s= String.valueOf(temp1.data);       
                       Cell cell = row.createCell(col);
                       cell.setCellValue(s);
                    
                       col++;
                      s=String.valueOf(temp2.data);
                       Cell cell1 = row.createCell(col);
                       cell1.setCellValue(s);

                       col++;
                       s= String.valueOf(temp3.data);
                       Cell cell2 = row.createCell(col);
                        cell2.setCellValue(s);
                      
                        col++;
                       s= String.valueOf(temp4.data);
                       Cell cell3 = row.createCell(col);
                        cell3.setCellValue(s);
                       
                        col++;
                       s= String.valueOf(temp5.data);
                       Cell cell4 = row.createCell(col);
                        cell4.setCellValue(s);
                       
                        col++;
                       s= String.valueOf(temp6.data);
                       Cell cell5 = row.createCell(col);
                        cell5.setCellValue(s);
                       
                        col++;
                       s= String.valueOf(temp7.data);
                       Cell cell6 = row.createCell(col);
                        cell6.setCellValue(s);
                       
                        col++;
                       s= String.valueOf(temp8.data);
                       Cell cell7 = row.createCell(col);
                        cell7.setCellValue(s);
                       
                        

                       temp1=temp1.next;
                       temp2=temp2.next;
                       temp3=temp3.next;
                       temp4=temp4.next;
                       temp5=temp5.next;
                       temp6=temp6.next;
                       temp7=temp7.next;
                       temp8=temp8.next;
                       


                    }

                 //Write the workbook in file system
                 FileOutputStream out = new FileOutputStream(
                    new File("Writesheet.xlsx"));
                 
                 workbook.write(out);
                 out.close();
                 System.out.println("Writesheet.xlsx written successfully");
              }  
 

}