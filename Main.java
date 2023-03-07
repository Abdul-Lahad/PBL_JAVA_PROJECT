import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // 1019 , 1890, 1897 ,1542 ,1540 ,1876 ,2230, 4163 ,4297 , 4631, 5815 , 5829
    // 8218 ----- 6936

    LinkedList<Collections> col = new LinkedList<Collections>(); // step 1
    Queue q = new Queue(); // step 2
    LinkedList<LinkedStack> scol = new LinkedList<LinkedStack>(); // step 3
    Linked_list ll; // step 4

    Scanner sc = new Scanner(System.in);
    list date, time, country, city, stat, mag = new list(), lat, lon;
    Database d = new Database();
    Location lo = new Location();
    Object[] obj;

    public static void main(String[] args) {

        Main m = new Main();

        m.step_1();
        System.out.println("yearly collection is created");

        m.step_2();
        System.out.println("Queue is created");

        m.step_3();
        System.out.println("Size of country collection " + m.scol.size());

        m.step_4();
        System.out.println("linked list is created");
        System.out.println("done\n\n\n stack");

        // m.problem_1();

        // m.problem_2();

        // m.problem_3();

        m.problem_4();

        // LinkedStack d=m.scol.getLast();
        // Object[] oo = d.peek();
        // System.out.println(d.Country_name+" , "+oo[0]+" , "+oo[1]+" , "+oo[2]);
        // m.ll=new Linked_list(d.Country_name, oo[0], oo[1]);
        // Linked_list t=m.ll;

        // for(int i=1;i<m.scol.size();i++){
        // d=m.scol.get(i);
        // oo = d.peek();
        // System.out.println(i+" "+d.Country_name+" , "+oo[0]+" , "+oo[1]+" , "+oo[2]);
        // t.next=new Linked_list(d.Country_name, oo[0], oo[1]);
        // t=t.next;
        // }

        // date = d.column_return(0, "Writesheet");
        // time = d.column_return(1, "Writesheet");
        // country = d.column_return(2, "Writesheet");
        // city = d.column_return(3, "Writesheet");
        // stat = d.column_return(4, "Writesheet");
        // lat = d.column_return(6, "Writesheet");
        // lon = d.column_return(7, "Writesheet");
        // mag = d.column_return(5, "Writesheet");

        // System.out.println("retrive");

        // node t1, t2, t3, t4, t5, t6, t7, t8, p1, p2, p3, p4, p5, p6, p7, p8;

        // t1 = country.head.next;
        // t2 = city.head.next;
        // t3 = mag.head.next;
        // t4 = date.head.next;
        // t5 = time.head.next;
        // t6 = lat.head.next;
        // t7 = lon.head.next;
        // t8 = stat.head.next;

        // p1 = country.head;
        // p2 = city.head;
        // p3 = mag.head;
        // p4 = date.head;
        // p5 = time.head;
        // p6 = lat.head;
        // p7 = lon.head;
        // p8 = stat.head;

        // int counter = 0, num = 0;

        // while (t1 != null) {

        // counter++;

        // String s = String.valueOf(t1.data);

        // if (s.equals("NOT")) {
        // p1.next = t1.next;
        // p2.next = t2.next;
        // p3.next = t3.next;
        // p4.next = t4.next;
        // p5.next = t5.next;
        // p6.next = t6.next;
        // p7.next = t7.next;
        // p8.next = t8.next;
        // num++;
        // System.out.print(" change : " + num + " ; " + s);
        // }

        // System.out.println(s + " ; " + "row : " + counter);

        // p1 = t1;
        // p2 = t2;
        // p3 = t3;
        // p4 = t4;
        // p5 = t5;
        // p6 = t6;
        // p7 = t7;
        // p8 = t8;

        // t1 = t1.next;
        // t2 = t2.next;
        // t3 = t3.next;
        // t4 = t4.next;
        // t5 = t5.next;
        // t6 = t6.next;
        // t7 = t7.next;
        // t8 = t8.next;

        // }
        // 5723
        // country.replace("TÃ¼rkmenistan", "Turkmenistan");
        // // 1200
        // // country.replace("RomÃ¢nia", "Romania");

        // try {
        // d.insert_excel(date, time, country, city, stat, mag, lat, lon);
        // System.out.println("insrtion is successfull.....");

        // } catch (Exception e) {
        // e.printStackTrace();

        // // TODO: handle exception
        // }

        // country=d.column_return(0, "Writesheet"); //country
        // city=d.column_return(1, "Writesheet"); //city
        // stat=d.column_return(2, "Writesheet");// state

        // System.out.println("list are retrive....");

        // date=d.column_return(0);//date
        // time=d.column_return(1);//time
        // lat=d.column_return(2);//latitude
        // lon=d.column_return(3);//longitude
        // mag=d.column_return(8);//magnitude

        // try {
        // d.insert_excel(date, time, country, city, stat, mag, lat, lon);
        // System.out.println("insrtion is successfull.....");

        // } catch (Exception e) {
        // e.printStackTrace();

        // // TODO: handle exception
        // }

        // l1=d.column_return(0);
        // l2=d.column_return(1);
        // l3=d.column_return(8);
        // cl.yearly_insert(l1, l2, l3);
        // System.out.println(cl);

        // lo.address=lo.n1.getAdress(27.357,87.867);
        // System.out.println(lo.address.getCountry());
        // System.out.println(lo.address.getCity());

        // System.out.println(l1.length());

        // obj=lo.city_country(l1, l2, 1,l1.length());
        // l3=(list) obj[0];
        // f.write_file(l3, "country");
        // l3=(list) obj[1];
        // f.write_file(l3, "city");
        // l3=(list) obj[2];
        // f.write_file(l3, "state");

    }

    public void step_1() {

        // ------making collections yearly--------

        for (int i = 1965; i <= 2016; i++) {
            col.add(new Collections(i));
        }
        date = d.column_return(0, "Writesheet");
        time = d.column_return(1, "Writesheet");
        country = d.column_return(2, "Writesheet");
        city = d.column_return(4, "Writesheet");
        mag = d.column_return(5, "Writesheet");

        for (int i = 0; i < col.size(); i++) {
            Collections c = col.get(i);
            // filtered record
            c.yearly_insert(date, time, country, city, mag);
            col.set(i, c);
        }

        // int pos = 0;
        // while (pos != -1) {
        // System.out.print("Enter year : ");
        // pos = sc.nextInt();
        // pos-=1965;
        // Collections c = col.get(pos);
        // System.out.println(c);

        // System.out.print("press -1 to exit or 0 to continue : ");
        // pos = sc.nextInt();

        // }

        // ------ending of collections yearly--------

    }

    public void rep(String p, String n) {

        date = d.column_return(0, "Writesheet");
        time = d.column_return(1, "Writesheet");
        country = d.column_return(2, "Writesheet");
        city = d.column_return(3, "Writesheet");
        stat = d.column_return(4, "Writesheet");
        lat = d.column_return(6, "Writesheet");
        lon = d.column_return(7, "Writesheet");
        mag = d.column_return(5, "Writesheet");

        country.replace(p, n);

        try {
            d.insert_excel(date, time, country, city, stat, mag, lat, lon);
            System.out.println("insrtion is successfull.....");

        } catch (Exception e) {
            e.printStackTrace();

            // TODO: handle exception
        }

    }

    public void step_2() {

        q.highest_magnitudQueue(col);

    }

    public void step_3() {

        country = d.column_return(2, "Writesheet");

        for (node temp = country.head; temp != null; temp = temp.next) {

            String s = String.valueOf(temp.data);
            boolean boool = true;
            if (scol.size() > 0) {
                for (int i = 0; i < scol.size(); i++) {
                    LinkedStack l = scol.get(i);
                    if (l.Country_name.equals(s)) {
                        boool = false;
                        break;
                    }

                }
            }
            if (boool) {
                LinkedStack st = new LinkedStack(s);
                scol.addFirst(st);

            }
        }

        System.out.println("completed country insertion into collection");

        // collection of country is ready

        for (int i = 0; i < scol.size(); i++) {
            LinkedStack ls = scol.get(i);

            // populating the stack

            ls.country_stack(col);

            // seting stack again to collection
            scol.set(i, ls);

        }
        scol.remove(scol.size() - 1);
        // System.out.println("removed");

        // System.out.println(scol.size());

        // int pos = 0;
        // while (pos != -1) {
        // System.out.print("Enter position : ");
        // pos = sc.nextInt();
        // LinkedStack c = scol.get(pos);
        // System.out.println(c.Country_name);
        // System.out.println(c);

        // System.out.print("press -1 to exit or 0 to continue : ");
        // pos = sc.nextInt();

        // }

    }

    public void step_4() {
        LinkedStack d = scol.getLast();
        Object[] oo = d.peek();
        ll = new Linked_list(d.Country_name, oo[0], oo[1]);
        Linked_list t = ll;

        for (int i = 1; i < scol.size(); i++) {
            d = scol.get(i);
            oo = d.peek();
            t.next = new Linked_list(d.Country_name, oo[0], oo[1]);
            t = t.next;
        }

    }

    public void problem_1() {
        list avrList = new list();
        double highest_avr = 0.0;
        int j = 0, t = 0;

        for (int i = 0; i < scol.size(); i++) {
            LinkedStack lStack = scol.get(i);

            double avr = lStack.size() / 52;

            avrList.add("Country : " + lStack.Country_name +
                    " average number of magnitude : " + avr);
            System.out.println("Country : " + lStack.Country_name + " | total number of magnitudes :" + lStack.size()
                    + " | average number of magnitude : " + avr);
            t += lStack.size();
            if (highest_avr < avr) {
                highest_avr = avr;
                j = i;
            }

        }

        // System.out.println(avrList);

        System.out.println("Total number of magnitudes : " + t);

        System.out.println("Most vulnerable country to earthquakes : ");
        System.out.print(
                scol.get(j).Country_name + " , " + scol.get(j).size() + " highest average magnitude : " + highest_avr);

    }

    public void problem_2() {
        q.high_Quake_2005_to_2015();
    }

    public void problem_3() {
        for (int i = 0; i < scol.size(); i++) {
            
            LinkedStack lStack = scol.get(i);

            lStack.most_5_recent();

        }
    }

    public void problem_4(){
        Linked_list tempList=ll;

        while(tempList!=null){
            if((Double)tempList.magnitude>6){
                System.out.print("| COUNTRY : "+tempList.country_name );
                System.out.print(" | DATE : "+tempList.date );
                System.out.println(" | MAGNITUDE : "+tempList.magnitude +" |");

            }
            tempList=tempList.next;

        }

    }

}
