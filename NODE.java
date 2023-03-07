import java.util.LinkedList;

public class NODE {
    String country;
    double aver_mag;
    NODE Next;

    public NODE() {

    }

    public NODE(String c, double a) {
        country = c;
        aver_mag = a;
    }

    public static NODE average_quake_yearly(LinkedList<LinkedStack> l) {

        LinkedStack obj = l.get(0);
        double aver = obj.size() / 52;

        NODE n = new NODE(obj.Country_name, aver);
        NODE temp = n;

        for (int i = 1; i < l.size(); i++) {

            obj = l.get(i);
            aver = obj.size() / 52;

            temp.Next = new NODE(obj.Country_name, aver);
            temp = temp.Next;

        }

        return n;

    }

    public NODE most_vulnerable(NODE n) {

        double a = 0.0;
        NODE h = new NODE();

        for (NODE temp = n; temp != null; temp = temp.Next) {
            if (a < temp.aver_mag) {
                a = temp.aver_mag;
                h = temp;
            }
        }

        return h;
    }
}
