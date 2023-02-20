
class detail_collection {
    Object country;
    Object city;
    Object magnitude;
    Object date;
    Object time;
    detail_collection next;

    public detail_collection(Object co, Object ci, Object m, Object d, Object t) {
        country = co;
        city = ci;
        magnitude = m;
        date = d;
        time = t;
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
}

public class Collections {
    int year;
    detail_collection head;

    Collections(int year){
        this.year=year;
    }
   
    void yearly_insert(list l,list l2,list l3){
		
		node t=l.head.next;
        node t1=l2.head.next;
        node t2=l3.head.next;

		while(t!=null){
			String y=String.valueOf(t.data);
			y=y.substring(6);
			int a=Integer.parseInt(y);
			if(a==year){
				break;
			}
			t=t.next;
            t1=t1.next;
            t2=t2.next;
			
		}
		
        this.head=new detail_collection(t1.data, t.data, t2.data);
        detail_collection temp1=this.head;

        
        t=t.next;
        t1=t1.next;
        t2=t2.next;
			
		while(t!=null){
			String y=String.valueOf(t.data);
			y=y.substring(6);
			int a=Integer.parseInt(y);
			if(a!=year){
				break;
			}
			temp1.next=new detail_collection(t1.data, t.data, t2.data);
            temp1=temp1.next;
            
    
            t=t.next;
            t1=t1.next;
            t2=t2.next;
		
		}
		
		
		
	}    

    public String toString()
	{
        StringBuilder b=new StringBuilder("[");

		String S;

		detail_collection X = head;

		while (X != null) {
			b.append("{"+X.date+" , "+X.magnitude+" , "+X.time+"}");
             if(X.next!= null)
                b.append(" -> "); 
			X = X.next;
		}
        b.append("]");
        S=b.toString();
                 
		return S ;
	}

    Queue yearly_high_mag(){
        Queue q=new Queue();






        return q;
    }


}
