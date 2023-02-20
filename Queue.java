interface Queue_bluePrint{
    public  void add(Object a,Object b,Object c);
    public Object[] first();
    public Object[] remove();
    public int size(); 
}
public class Queue implements Queue_bluePrint{ 
   private Node head=new Node(null,null,null);
   private int size;
  
    private class Node{
        Object year;
        Object country;
        Object magnitude;
        Node next=this,prev=this;

        public Node (Object obj,Object mag,Object y){
            country=obj;
            magnitude=mag;
            year=y;
                                        }
        public Node (Object obj,Object mag,Object y,Node n,Node p){
            country=obj;
             magnitude=mag;
             year = y;
            next=n;
            prev=p;}
    }

    public int Size(){return size;}

    public boolean isEpmty(){return (size==0);}


    @Override
    public void add(Object country,Object magnitud,Object year) {
        // TODO Auto-generated method stub
        head.prev.next=new Node(country,magnitud,year,head, head.prev);
        head.prev=head.prev.next;
        ++size;    
    }

    @Override
    public Object[] first() {
        // TODO Auto-generated method stub
        if(isEpmty()){
             System.out.println("No elements ");
             return null;
        }
        Object[] obj={head.next.country,head.next.magnitude,head.next.year};
        return  obj;
    }

    @Override
    public Object[] remove() {
        // TODO Auto-generated method stub
        Object[] obj={head.next.country,head.next.magnitude,head.next.year};
        head.next=head.next.next;
        head.next.prev=head;

        return obj;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }
    public String toString(){
        StringBuffer b=new StringBuffer("[");
        
        for(Node temp=head.next;temp!=head;temp=temp.next){
            b.append("{ "+temp.country+" , "+temp.magnitude+" , "+temp.year+" } ");

            if(temp.next!=head)
                b.append(" , ");
                }
            b.append("]");
            
            String s=b.toString();

            return s;
    }
    
//    public ArrayStack toArrayStack(){
//             ArrayStack arr=new ArrayStack(size);
//             for(Node temp=head.next;temp!=head;temp=temp.next){
//                 arr.push(temp.object);
//             }

//             return arr;
//    }
//    public LinkedStack toLinkedStack(){
//            LinkedStack l=new LinkedStack();

//            for(Node temp=head.next;temp!=head;temp=temp.next){
//                l.push(temp.object);
//            }
//            return l;
//    }
    
}
