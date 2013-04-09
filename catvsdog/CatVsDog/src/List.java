
public class List {
	private ListNode head;
	private ListNode tail;
	
	public List() {
		head = null;
		tail = null;
	}
	
	public ListNode getHead() {
		return head;
	}
	
	public ListNode getTail() {
		return tail;
	}
	
	public void addNode(ListNode newNode) {
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else{
			tail.setDown(newNode);
			newNode.setUp(tail);
			tail = tail.getDown();
		}
	}
	
	public boolean vExist(int num) {
		boolean exi = false;
		if(head == null) {
			return exi;
		}
		else {
			ListNode cursor = head;
			while(cursor != null) {
				if(cursor.getNum() == num) {
					exi = true;
				}
				cursor = cursor.getDown();
			}
		}
		return exi;
	}
	
	public boolean eExist(int l, int r) {
		boolean exi = false;
		if(head == null) {
			return exi;
		}
		else {
			ListNode cursor = head;
			while(cursor != null) {
				if(cursor.getL() == l && cursor.getR() == r) {
					exi = true;
				}
				cursor = cursor.getDown();
			}
		}
		return exi;
	}
	
	public ListNode tellLeft(int rNum) {
		ListNode cursor = head;
		ListNode left = null;
		while(cursor != null) {
			if(cursor.getR() == rNum) {
				left = new ListNode(cursor.getL());
			}
			cursor = cursor.getDown();
		}
		return left;
	}
	
	public void del(ListNode delNode) {
		ListNode cursor = head;
		while(cursor != null) {
			if(cursor.getNum() == delNode.getNum()) {
				if(cursor == head) {
					head = head.getDown();
				}
				else {
					cursor.getUp().setDown(cursor.getDown());
				}
			}
			cursor = cursor.getDown();
		}
	}
	
	public void delEdge(int l, int r) {
		ListNode cursor = head;
		while(cursor != null) {
			if(cursor.getL() == l && cursor.getR() == r) {
				if(cursor == head) {
					head = head.getDown();
				}
				else {
					cursor.getUp().setDown(cursor.getDown());
				}
			}
			cursor = cursor.getDown();
		}
	}
	
	public void copyList(List li) {
		ListNode cursor = li.getHead();
		while(cursor != null) {
			this.addNode(new ListNode(cursor.getNum()));
			cursor = cursor.getDown();
		}
		
	}


}
