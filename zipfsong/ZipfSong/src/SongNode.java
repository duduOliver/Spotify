
public class SongNode {
	private Song data;
	private SongNode left;
	private SongNode right;

	
	public SongNode(int order, long times, String name) {
		data = new Song(order, times, name);
		left = null;
		right = null;		
	}
	
	public Song getData() {
		return data;
	}
	
	public SongNode getLeft() {
		return left;
	}
	
	public SongNode getRight() {
		return right;
	}
	
	public void setLeft(SongNode newLeft) {
		left = newLeft;
	}
	
	public void setRight(SongNode newRight) {
		right = newRight;
	}
}
