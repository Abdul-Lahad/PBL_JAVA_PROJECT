import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filing {

    public list read_file(String File_name) {
        list ls=new list();
        ls.head=new node("");
        node temp=ls.head;
        try {
            File Obj = new File(File_name+".txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                temp.next=new node(data);
                temp=temp.next;
                System.out.println(data);
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return ls;
    }

    public void write_file(list ls,String File_name) {
        node temp=ls.head;
        try {
            File Obj = new File(File_name+".txt");
            if (Obj.createNewFile()) {
                System.out.println("File created: " + Obj.getName());
            } else {
                System.out.println("File already exists.");
            }

            BufferedWriter Writer = new BufferedWriter(new FileWriter(Obj,true));

            // FileWriter Writer = new FileWriter(Obj);
            while (temp!=null) {
                String s=String.valueOf(temp.data);
                
                if(s.equals("") || !isLetter(s.charAt(0))){
                    s="Unable to geocode";
                }
                Writer.write(s+",\n");
               temp=temp.next; 
            }
            Writer.close();
            
            // Writer.write("Files in Java are seriously good!!");
            // Writer.close();
            System.out.println("Successfully written.");
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    boolean isLetter(char ch){
      return (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z');       
    }

}
