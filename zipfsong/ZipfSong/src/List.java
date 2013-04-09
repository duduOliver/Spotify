
public class List {
	private SongNode head;
	
	public List() {
		head = null;
	}
	
	public SongNode getHead() {
		return head;
	}
	
	public void insertNode(String newNode) {
		SongNode cursor = head;
		if(head == null) {
			head = new SongNode(0,0,newNode);
		}
		else {
			while(cursor.getRight() != null) {
				cursor = cursor.getRight();
			}	
			cursor.setRight(new SongNode(0,0,newNode));
		}
		cursor = null;
	}

}
