
public class myLinkedList extends MElement {
	private node head;
	private node tail;
	private int nodes;
	
	///////////////////
	//	   NODE		 //
	///////////////////
	private class node{
		private MElement data;
		private node prev;
		private node next;
		
		public node(MElement obj) {
			data=obj;
			next=null;
			prev=null;
		}
		
		public node getNext() {
			return next;
		}
		
		public node getPrev() {
			return prev;
		}
		
		public boolean equals(MElement obj) {
			return data.equals(obj);
		}
		
		public MElement getData() {
			return data;
		}
		
		public boolean hasNext() {
			if (next == null) {
				return false;
			}
			else {
				return true;
			}
		}
				
	}
	
	////////////////////////////
	//			LIST		  //
	////////////////////////////
	
	public myLinkedList() {
		nodes=0;
	}
	
	public boolean add(MElement obj) {
		node newNode= new node(obj);
		if(nodes == 0) {
			head=newNode;
			tail=newNode;
			nodes++;
			return true;
		}
		else {
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
			return true;
		}
	}
	
	public MElement find(MElement obj) {
		node current=head;
		while (current.hasNext()) {
			if (current.getData().equals(obj)){
				break;
			}
			else {
				current=current.next;
			}
		}
		return current.data;	
	}
	
	public MElement remove(MElement obj) {
		node current=head;
		while (current.hasNext()) {
			if(current.getData().equals(obj)) {
				current.prev.next=current.next;
				current.next.prev=current.prev;
				break;
			}
			else {
				current=current.next;
			}
		}
		nodes--;
		return current.getData();
	}
	
	public int size() {
		return nodes;
	}
	
	public boolean isLinkedList() {
		return true;
	}
	
}
