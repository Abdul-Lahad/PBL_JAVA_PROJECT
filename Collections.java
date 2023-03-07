
class detail_collection {
    Object country;
    Object city;
    Object magnitude;
    Object date;
    Object time;
    Object lat;
    Object lon;
    Object stat;
    detail_collection next;

    public detail_collection(Object co, Object ci, Object m, Object d, Object t) {
        country = co;
        city = ci;
        magnitude = m;
        date = d;
        time = t;
    }
    public detail_collection(Object co, Object ci, Object m, Object d, Object t, Object la, Object lo, Object s) {
        country = co;
        city = ci;
        magnitude = m;
        date = d;
        time = t;
        stat=s;
        lat=la;
        lon=lo;
    }

    public detail_collection(Object m, Object d, Object t) {
        magnitude = m;
        date = d;
        time = t;
    }
    

    public detail_collection(Object co, Object ci, Object m, Object d, Object t, detail_collection n) {
        country = co;
        city = ci;
        magnitude = m;
        date = d;
        time = t;
        next = n;
    }

    public detail_collection filter(){
        
        detail_collection co=this;

        int counter=1,num=0;
        
        if(this.country.equals("NOT")){
            System.out.println("working head");
            co=co.next;
        }
        detail_collection temp=co,n=co.next;
        
        while(n!=null){
            
            counter++;
            System.out.print("row : "+counter);
            
            String s=String.valueOf(n.country);

            if(s.equals("NOT")){                  
                    temp.next=n.next;
                    num++;
                    System.out.println("      change : "+num+" ; "+s);
                }
                
        }

        

        return co;

    }

}

public class Collections {
    int year;
    detail_collection head;

    Collections(int year) {
        this.year = year;
    }

    void yearly_insert(list date_List, list l2, list l3) {

        node t = date_List.head.next;
        node t1 = l2.head.next;
        node t2 = l3.head.next;

        while (t != null) {
            String y = String.valueOf(t.data);
            y = y.substring(6);
            int a = Integer.parseInt(y);
            if (a == year) {
                break;
            }
            t = t.next;
            t1 = t1.next;
            t2 = t2.next;

        }

        this.head = new detail_collection(t1.data, t.data, t2.data);
        detail_collection temp1 = this.head;

        t = t.next;
        t1 = t1.next;
        t2 = t2.next;

        while (t != null) {
            String y = String.valueOf(t.data);
            y = y.substring(6);
            int a = Integer.parseInt(y);
            if (a != year) {
                break;
            }
            temp1.next = new detail_collection(t1.data, t.data, t2.data);
            temp1 = temp1.next;

            t = t.next;
            t1 = t1.next;
            t2 = t2.next;

        }

    }

    void yearly_insert(list date_List, list time_list, list country_List, list city_List, list magnitude_List) {

        node t, t1, t2, t3, t4;
        t = date_List.head.next;
        t1 = country_List.head.next;
        t2 = city_List.head.next;
        t3 = magnitude_List.head.next;
        t4 = time_list.head.next;

        while (t != null) {
            String y = String.valueOf(t.data);
            y = y.substring(6);
            int a = Integer.parseInt(y);
            if (a == year) {
                break;
            }
            t = t.next;
            t1 = t1.next;
            t2 = t2.next;
            t3 = t3.next;
            t4 = t4.next;

        }

        this.head = new detail_collection(t1.data, t2.data, t3.data, t.data, t4.data);
        detail_collection temp1 = this.head;

        t = t.next;
        t1 = t1.next;
        t2 = t2.next;
        t3 = t3.next;
        t4 = t4.next;

        while (t != null) {
            String y = String.valueOf(t.data);
            y = y.substring(6);
            int a = Integer.parseInt(y);
            if (a != year) {
                break;
            }
            temp1.next = new detail_collection(t1.data, t2.data, t3.data, t.data, t4.data);
            temp1 = temp1.next;

            t = t.next;
            t1 = t1.next;
            t2 = t2.next;
            t3 = t3.next;
            t4 = t4.next;

        }

    }

    public String toString() {
        StringBuilder b = new StringBuilder("[");

        String S;

        detail_collection X = head;

        b.append("{" + " DATE " + " ,   " + " TIME " +"     ,   "+ "COUNTRY " + "  , " + " CITY  " +"   ,   " + " MAGNITUDE "+ "}\n");

        while (X != null) {
            b.append("{" + X.date + " , " + X.time +" , "+ X.country + " , " + X.city +" , " + X.magnitude+ "}");
            if (X.next != null)
                b.append("\n");
            X = X.next;
        }
        b.append("]");
        S = b.toString();

        return S;
    }

    public void filter(){
        
        
        if(this.head.country.equals("NOT")){
           System.out.println("working head");
            // this.head=this.head.next;
        }
        detail_collection temp=this.head,n=this.head.next;
        
        while(n!=null){
            if(n.country.equals("NOT")){
                    System.out.println("Working");
                    // temp.next=n.next;
            }
        }

       System.out.println("filter "+year);

    }

}
