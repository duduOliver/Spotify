
public class SongListNode {
	private Song data;
	private SongListNode up;
	private SongListNode down;
	
	public SongListNode(int order, long times, String name) {
		data = new Song(order, times, name);
		up = null;
		down = null;		
	}
	
	public Song getData() {
		return data;
	}
	
	public SongListNode getUp() {
		return up;
	}
	
	public SongListNode getDown() {
		return down;
	}
	
	public void setUp(SongListNode upNode) {
		up = upNode;
	}
	
	public void setDown(SongListNode downNode) {
		down = downNode;
	}
}
