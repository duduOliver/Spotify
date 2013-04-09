
public class SongBST {
	private SongNode root;
	private List maxList;

	public SongBST(long times, String name) {
		root = new SongNode(1, times, name);
		maxList = new List();
	}
	
	public SongNode getRoot() {
		return root;
	}
	
	public List getMaxList() {
		return maxList;
	}
	
	public void insertNode(SongNode newNode) {
		SongNode cursor = root;
		long curTimes;
		long newTimes = newNode.getData().getTimesTorder();
		boolean done = false;
		while(!done) {
			
			curTimes = cursor.getData().getTimesTorder();
			if(newTimes > curTimes) {
				if(cursor.getRight() == null) {
					cursor.setRight(newNode);
					done = true;
				}
				else cursor = cursor.getRight();
			}
			else {
				if(cursor.getLeft() == null) {
					cursor.setLeft(newNode);
					done = true;
				}
				else cursor = cursor.getLeft();
			}			
		}
	}
	
	public void inorderTraversalArray(SongNode rt){
		if(rt.getRight()!= null) {inorderTraversalArray(rt.getRight());}
		maxList.insertNode(rt.getData().getName());
		if(rt.getLeft() != null) {inorderTraversalArray(rt.getLeft());}
		
	}
	
}
