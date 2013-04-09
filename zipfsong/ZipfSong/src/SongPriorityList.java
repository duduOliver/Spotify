
public class SongPriorityList {
	private SongListNode head;
	private SongListNode cursor;
	
	public SongPriorityList(int order, long times, String name) {
		head = new SongListNode(order, times, name);
		head.setUp(null);
		head.setDown(null);
		cursor = null;
	}
	
	public SongListNode getHead() {
		return head;
	}
	
	public SongListNode getCursor() {
		return cursor;
	}
	
	public void setCursor(SongListNode node) {
		cursor = node;
	}
	
	public void insertNode(SongListNode cursorNode, SongListNode newNode) {
		cursor = cursorNode;
		if(newNode.getData().getTimesTorder() > cursor.getData().getTimesTorder()) {
			if(cursor == head) {
				head.setUp(newNode);
				newNode.setDown(head);
				head = newNode;
			}
			else {
				newNode.setUp(cursor.getUp());
				newNode.setDown(cursor);
				cursor.getUp().setDown(newNode);
				cursor.setUp(newNode);
			}	
		}
		else if(cursor.getDown() == null){
			newNode.setUp(cursor);
			cursor.setDown(newNode);
		}
		else insertNode(cursor.getDown(), newNode);
	}
}
