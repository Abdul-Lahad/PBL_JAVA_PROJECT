import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Object> linkedList=new LinkedList<>();

        list l1, l2, l3, l4;
        Object[] obj;
        Database d = new Database();
        Location lo = new Location();
        Filing f = new Filing();
        Collections c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;
        
        
        lo.address=lo.n1.getAdress(27.357,87.867);
        System.out.println(lo.address.getCountry());
        System.out.println(lo.address.getCity());
       
        
        
        // l1=d.column_return(2);
        // l2=d.column_return(3);
        // System.out.println(l1.length());
        
        // obj=lo.city_country(l1, l2, 1,l1.length());
        // l3=(list) obj[0];
        // f.write_file(l3, "country");
        // l3=(list) obj[1];
        // f.write_file(l3, "city");
        // l3=(list) obj[2];
        // f.write_file(l3, "state");

       
        

       
    }
}
