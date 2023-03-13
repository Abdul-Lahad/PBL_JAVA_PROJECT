import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    // collection along with magnitude.
    // (Collection of each year means 52 collections)
    LinkedList<Collections> col = new LinkedList<Collections>(); // step 1

    // queue storing biggest (with highest magnitude)
    // quake of each year with magnitude and
    // country, starting from 1965 to 2016.
    Queue q = new Queue(); // step 2

    // stack from the collections,
    // one for each country which stores earthquake and its magnitude
    // in the order of the event (the most recent event on top).
    LinkedList<LinkedStack> scol = new LinkedList<LinkedStack>(); // step 3

    // linked list which saves the one most recent
    // earthquake with magnitude and country name
    // from each country
    Linked_list ll; // step 4

    Scanner sc = new Scanner(System.in);
    list date, time, country, city, stat, mag = new list(), lat, lon;
    Database d = new Database();
    Location lo = new Location();

    public static void main(String[] args) {

        Main m = new Main();
        m.step_1(); // making yearly collection of earthquake
        m.step_2(); // Make a queue storing biggest quake of each year
        m.step_3(); // Make a stack, one for each country
        m.step_4(); // Make a linked list which saves the one most
                    // recent earthquake from each country

        int num = 0;
        do {
            num = m.me();
            if (num == 2) {
                int n;
                do {
                    n = m.problems();
                    switch (n) {
                        case 1: {
                            m.problem_1();
                            break;
                        }
                        case 2: {
                            m.problem_2();
                            break;
                        }
                        case 3: {
                            m.problem_3();
                            break;
                        }
                        case 4: {
                            m.problem_4();
                            break;
                        }
                        case 0: {
                            break;
                        }
                        default:
                            System.out.println("\ninvalid input ;");
                    }
                } while (n != 0);

            } else if (num == 1) {
                int n;
                do {
                    n = m.steps();
                    switch (n) {
                        case 1: {
                            m.s1();
                            break;
                        }
                        case 2: {
                            m.s2();
                            break;
                        }
                        case 3: {
                            m.s3();
                            break;
                        }
                        case 4: {
                            m.s4();
                            break;
                        }
                        case 0: {
                            break;
                        }
                        default:
                            System.out.println("\ninvalid input ;");
                    }
                } while (n != 0);

            }

        } while (num != 0);

    }

    public void s1() {
        int pos = -1;
        while (pos != 0) {
            System.out.print("Enter year : ");
            pos = sc.nextInt();
            pos -= 1965;
            Collections c = col.get(pos);
            System.out.println(c);

            System.out.print("press 0 to exit step_1 or 1 to continue : ");
            pos = sc.nextInt();

        }

    }

    public void s2() {
        System.out.println(q);
    }

    public void s3() {

        int pos = -1;
        while (pos != 0) {
            System.out.print("Enter number between 0 to " + (scol.size() - 1) + " : ");
            pos = sc.nextInt();
            LinkedStack s = scol.get(pos);
            System.out.println("Country : " + s.Country_name);
            System.out.println(s);
            System.out.print("press 0 to exit step_3 or 1 to continue : ");
            pos = sc.nextInt();

        }

    }

    public void s4() {
        System.out.println(ll);
    }

    public int problems() {
        System.out.println("\n");

        System.out.println(
                "1 > problem 1 (average number of earthquakes per year for each country and which country is most vulnerable to earthquakes)");
        System.out.println("2 > problem 2 (biggest earthquakes from 2005 to 2015 )");
        System.out.println("3 > problem 3 (recent 5 earthquakes from each country)");
        System.out.println("4 > problem 4 (recent above 6 magnitude earthquakes)");
        System.out.println("0 > Go back");

        System.out.print("\nEnter your choice : ");

        int num = sc.nextInt();

        System.out.println("\n");

        return num;
    }

    public int me() {
        System.out.println("\n");

        System.out.println("1 > data structurs");
        System.out.println("2 > problems");
        System.out.println("0 > Exit");

        System.out.print("\nEnter your choice : ");

        int num = sc.nextInt();

        System.out.println("\n");

        return num;
    }

    public int steps() {
        System.out.println("\n");

        System.out.println("1 > step 1 [yearly earthquake collection]");
        System.out.println("2 > step 2 [queue storing biggest (with highest magnitude) quake of each year]");
        System.out.println("3 > step 3 [stack , one for each country (the most recent event on top)]");
        System.out.println(
                "4 > step 4 [linked list, which saves the one most recent earthquake with magnitude and country name from each country]");
        System.out.println("0 > Go back");

        System.out.print("\nEnter your choice : ");

        int num = sc.nextInt();

        System.out.println("\n");

        return num;
    }

    public void step_1() {

        // ------making collections yearly--------

        for (int i = 1965; i <= 2016; i++) {
            col.add(new Collections(i)); // initilizing objects yearly
        }
        // fatching data from database
        date = d.column_return(0, "Writesheet");
        time = d.column_return(1, "Writesheet");
        country = d.column_return(2, "Writesheet");
        city = d.column_return(4, "Writesheet");
        mag = d.column_return(5, "Writesheet");

        for (int i = 0; i < col.size(); i++) {

            Collections c = col.get(i); // get objects from collection

            c.yearly_insert(date, time, country, city, mag);

            col.set(i, c); // setting object again in collection
        }
        // ------ending of collections yearly--------

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

    }

    public void step_4() {
        LinkedStack d = scol.getFirst();
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
        double highest_avr = 0.0;
        int j = 0, t = 0;

        for (int i = 0; i < scol.size(); i++) {

            LinkedStack lStack = scol.get(i);

            double avr = lStack.size();
            avr /= 52;

            System.out.println("Country : " + lStack.Country_name + " \t| TOTAL NO. of magnitudes :" + lStack.size()
                    + " \t| AVERAGE NO. of magnitude : " + avr);

            t += lStack.size();
            if (highest_avr < avr) {
                highest_avr = avr;
                j = i;
            }

        }
        System.out.println("TOTAL NUMBER OF MAGNITUD OF ALL COUNTRYS : " + t);

        System.out.println("\nMost vulnerable country to earthquakes : ");
        System.out.print(scol.get(j).Country_name + "\t| TOTAL NO. of magnitudes :" + scol.get(j).size()
                + "\t| HIGHEST AVERAGE Magnitude : " + highest_avr);

    }

    public void problem_2() {
        q.high_Quake_2005_to_2015();
    }

    public void problem_3() {
        for (int i = 0; i < scol.size(); i++) {

            LinkedStack lStack = scol.get(i);

            lStack.most_5_recent();

        }

        System.out.println("\nThe total number of country : " + scol.size());
    }

    public void problem_4() {
        Linked_list tempList = ll;

        while (tempList != null) {
            if ((Double) tempList.magnitude > 6) {
                System.out.print("| COUNTRY : " + tempList.country_name);
                System.out.print(" | DATE : " + tempList.date);
                System.out.println(" | MAGNITUDE : " + tempList.magnitude + " |");

            }
            tempList = tempList.next;

        }

    }

}
