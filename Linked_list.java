public class Linked_list {
    Object country_name;
    Object magnitude;
    Object date;
    Linked_list next;

   public Linked_list(Object c,Object m,Object d){
        country_name = c;
        magnitude = m;
        date = d;        
   }
   public Linked_list(Object c,Object m,Object d,Linked_list n){
    country_name = c;
    magnitude = m;
    date = d;        
    next = n;
   }

}
