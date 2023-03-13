import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Database {

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