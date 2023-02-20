class node {

	Object data;
	node next;

	node(Object data)
	{
        this.data = data;
		this.next = null;
	}
}

class list {

	node head;
    private node tail;
	private int length = 0;

	list() { this.head = null; }
	Object first(){
        return head.data;
    }
    void add(Object data)
	{

		node temp = new node(data);

		if (this.head == null) {
		tail = head = temp;
		}

		else {			
            tail.next=temp;
            tail=tail.next;			
		}
		length++;
	}

	void add(int position, Object data)
	{

		if (position > length + 1) {

			System.out.println(
				"Position Unavailable in LinkedList");
			return;
		}

		if (position == 1) {

			node temp = head;

			head = new node(data);

			head.next = temp;

			return;
		}

		node temp = head;

		node prev = new node(null);
		while (position - 1 > 0) {
			prev = temp;
			temp = temp.next;
			// decreasing position counter
			position--;
		}
		// previous node now points to new value
		prev.next = new node(data);
		// new value now points to former current node
		prev.next.next = temp;
	}
	void remove(Object key)
	{

		node prev = new node(null);
		prev.next = head;
		node next = head.next;
        node temp = head;
		boolean exists = false;

		if (head.data.equals(key)) {
			head = head.next;

			exists = true;
		}

		while (temp.next != null) {

			if (String.valueOf(temp.data).equals(
					String.valueOf(key))) {

				prev.next = next;
				exists = true;

				break;
			}

			prev = temp;

			temp = temp.next;

			next = temp.next;
		}

		if (exists == false
			&& String.valueOf(temp.data).equals(
				String.valueOf(key))) {

			prev.next = null;
			exists = true;
		}
		if (exists) {

			length--;
		}

		else {

			System.out.println(
				"Given Value is not present in linked list");
		}
	}

	void clear()
	{
		head = null;
		length = 0;
	}
	boolean empty()
	{
		if (head == null) {
			return true;
		}
		return false;
	}
	int length() { return this.length; }
	public String toString()
	{
        StringBuilder b=new StringBuilder("[");

		String S;

		node X = head;

		while (X != null) {
			b.append(String.valueOf(X.data));
             if(X.next!= null)
                b.append(" -> "); 
			X = X.next;
		}
        b.append("]");
        S=b.toString();
                 
		return S ;
	}


	// list date(list l,int year){
		
	// 	list temp=new list();
	// 	node t=l.head.next;
	// 	while(t!=null){
	// 		String y=String.valueOf(t.data);
	// 		y=y.substring(6);
	// 		int a=Integer.parseInt(y);
	// 		if(a==year){
	// 			break;
	// 		}
	// 		t=t.next;
			
	// 	}
	// 	temp.head=new node(t.data);
	// 	node tt=temp.head;
	// 	t=t.next;
	// 	while(t!=null){
	// 		String y=String.valueOf(t.data);
	// 		y=y.substring(6);
	// 		int a=Integer.parseInt(y);
	// 		if(a!=year){
	// 			break;
	// 		}
	// 		tt.next=new node(t.data);
	// 		tt=tt.next;
	// 		t=t.next;
		
	// 	}
		
		
	// 	return temp;
	// }



}

