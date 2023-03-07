import java.util.LinkedList;

interface Queue_bluePrint {
    public void add(Object a, Object b, Object c);

    public Object[] first();

    public Object[] remove();

    public int size();
}

public class Queue implements Queue_bluePrint {
    private Node head = new Node(null, null, null);
    private int size;

    private class Node {
        Object year;
        Object country;
        Object magnitude;
        Node next = this, prev = this;

        public Node(Object obj, Object mag, Object y) {
            country = obj;
            magnitude = mag;
            year = y;
        }

        public Node(Object obj, Object mag, Object y, Node n, Node p) {
            country = obj;
            magnitude = mag;
            year = y;
            next = n;
            prev = p;
        }
    }

    public int Size() {
        return size;
    }

    public boolean isEpmty() {
        return (size == 0);
    }

    @Override
    public void add(Object country, Object magnitud, Object year) {
        // TODO Auto-generated method stub
        head.prev.next = new Node(country, magnitud, year, head, head.prev);
        head.prev = head.prev.next;
        ++size;
    }

    @Override
    public Object[] first() {
        // TODO Auto-generated method stub
        if (isEpmty()) {
            System.out.println("No elements ");
            return null;
        }
        Object[] obj = { head.next.country, head.next.magnitude, head.next.year };
        return obj;
    }

    @Override
    public Object[] remove() {
        // TODO Auto-generated method stub
        Object[] obj = { head.next.country, head.next.magnitude, head.next.year };
        head.next = head.next.next;
        head.next.prev = head;

        return obj;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    public String toString(){
        StringBuffer b = new StringBuffer("[");

        for (Node temp = head.next; temp != head; temp = temp.next) {
            b.append("{ " + temp.country + " , " + temp.magnitude + " , " + temp.year + " } ");

            if (temp.next != head)
                b.append("\n");
        }
        b.append("]");

        String s = b.toString();

        return s;
    }

    public void highest_magnitudQueue(LinkedList<Collections> l) {

        for (int i = 0; i < l.size(); i++) {
            Collections cl = l.get(i);
            detail_collection high_node, temp = cl.head;
            high_node=cl.head;
            double high_mag = 0.0;

            while (temp != null) {
                double mag = (Double) temp.magnitude;
                if (high_mag < mag) {
                    high_mag = mag;
                    high_node = temp;
                }
                temp = temp.next;
            }

            this.add(high_node.country, high_node.magnitude, cl.year);

        }

    }

    public void high_Quake_2005_to_2015() {

        for (Node temp = this.head.next; temp != this.head; temp = temp.next) {
            int num = Integer.parseInt(String.valueOf(temp.year));

            if (num >= 2005 && num <= 2015) {

                System.out.print("Year : " + temp.year);
                System.out.print("| Country : " + temp.country);
                System.out.println("| highest Magnitude of Earthquake : " + temp.magnitude);

            }

        }
    }

}
