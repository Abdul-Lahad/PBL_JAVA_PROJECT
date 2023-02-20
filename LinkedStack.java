interface Stack{
    
    Object peek();
    Object pop();
    void push(Object obj1,Object obj2,Object obj3);
    int size();
}

public class LinkedStack implements Stack{
    public String Country_name;
    private Node node;
    private int size;
 
     private class Node{
         Object magnitude;
         Object date;
         Object time;
         Node next;
         
 
         Node(Object mag,Object d,Object t,Node n){
             magnitude=mag;
             date=d;
             time=t;
             next=n;
         }
     }
     @Override
     public Object[] peek() {
         // TODO Auto-generated method stub
        Object[] obj={node.magnitude,node.date,node.time};
         return obj;
     }
 
     @Override
     public Object[] pop() {
         // TODO Auto-generated method stub
      
         Object[] o={node.magnitude,node.date,node.time};
         node=node.next;
         --size;
         return o;
     }
 
     @Override
     public void push(Object magnitude,Object date,Object time) {
         // TODO Auto-generated method stub
         node=new Node(magnitude,date,time,node);
         size++;    
     }
 
     @Override
     public int size() {
         // TODO Auto-generated method stub
         return size;
     }
 
     boolean isEmpty(){
         return (size==0);
     }
     void reverse(){
         Node temp1,temp2,head;
         head=this.node;
 
         temp2=head.next;
         temp1=head;
 
         head.next=null;
         
         while(temp2!=null){
 
             head=temp2;
             temp2=temp2.next;
             head.next=temp1;
             temp1=head;
             
         }
     
         this.node=head;
 
     }
   public String toString(){
         StringBuffer b=new StringBuffer("[");
 
         for(Node temp=node;temp!=null;temp=temp.next){
             b.append("{"+temp.magnitude+" , "+temp.date+" , "+temp.time+"}");
             if(temp.next!=null){
                 b.append(" , ");
             }
         }
         b.append("]");
         String s=b.toString();
          return s;
   }
  
     
 }
 