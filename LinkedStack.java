import java.util.LinkedList;

interface Stack {

    Object peek();

    Object pop();

    void push(Object obj1, Object obj2, Object obj3);

    int size();
}

public class LinkedStack implements Stack {
    public String Country_name;
    private Node node;
    private int size;

    public LinkedStack(){
        
    }
    public LinkedStack(String c){
        Country_name=c;
    }

    private class Node {
        Object magnitude;
        Object date;
        Object time;
        Node next;

        Node(Object mag, Object d, Object t, Node n) {
            magnitude = mag;
            date = d;
            time = t;
            next = n;
        }
    }

    @Override
    public Object[] peek() {
        // TODO Auto-generated method stub
        Object[] obj = { node.magnitude , node.date , node.time };
        return obj;
    }

    @Override
    public Object[] pop() {
        // TODO Auto-generated method stub

        Object[] o = { node.magnitude, node.date, node.time };
        node = node.next;
        --size;
        return o;
    }

    @Override
    public void push(Object magnitude, Object date, Object time) {
        // TODO Auto-generated method stub
        node = new Node(magnitude, date, time, node);
        size++;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    public String toString() {
        StringBuffer b = new StringBuffer("[");

        for (Node temp = node; temp != null; temp = temp.next) {
            b.append("{" + temp.magnitude + " , " + temp.date + " , " + temp.time + "}");
            if (temp.next != null) {
                b.append("\n");
            }
        }
        b.append("]");
        String s = b.toString();
        return s;
    }

    public void country_stack(LinkedList<Collections> l) {

        // System.out.println("outer");
        for (int i = 0; i < l.size(); i++) {
            
            // System.out.println(i+"loop in");

            Collections cl = l.get(i);
            detail_collection temp = cl.head;

            while (temp != null) {
                // System.out.println(i+"while in ");
                String s = String.valueOf(temp.country);
                if (this.Country_name.equals(s)) {
                    this.push(temp.magnitude, temp.date, temp.time);
                }
                temp=temp.next;
            }
            
            // System.out.println(i+"while out");
        
        }
        // System.out.println("loop out");

    }

    public void most_5_recent(){
        Node n=node;
        System.out.println("COUNTRY : " + Country_name);
        for(int i=0 ; i<5;i++){

            System.out.print("| DATE "+n.date);
            System.out.println("| MAGNITUDE "+n.magnitude+" |");

            if(n.next==null)
              break;
              
             n=n.next;
        }
    }

    
}
