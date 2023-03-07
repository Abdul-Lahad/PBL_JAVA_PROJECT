import java.util.LinkedList;

public class Linked_list {
     Object country_name;
     Object magnitude;
     Object date;
     Linked_list next;

     public Linked_list(Object c, Object m, Object d) {
          country_name = c;
          magnitude = m;
          date = d;
     }

     public Linked_list(Object c, Object m, Object d, Linked_list n) {
          country_name = c;
          magnitude = m;
          date = d;
          next = n;
     }

     public void store_recently_quake(LinkedList<LinkedStack> l) {

          Linked_list temp = this;

               LinkedStack ls = l.get(0);
               Object[] obj = ls.peek();
               temp=new Linked_list(ls.Country_name,obj[0], obj[1]);

          for (int i = 0; i < l.size(); i++) {
                ls = l.get(i);
                obj = ls.peek();
                temp.next=new Linked_list(ls.Country_name,obj[0], obj[1]);             
                temp=temp.next;
          }

     }

     
     public String toString() {
          StringBuffer b = new StringBuffer("[");
  
          for (Linked_list temp = this; temp != null; temp = temp.next) {
              b.append("{" + temp.country_name + " , " + temp.date + " , " + temp.magnitude + "}");
              if (temp.next != null) {
                  b.append("\n");
              }
          }
          b.append("]");
          String s = b.toString();
          return s;
      }

}
