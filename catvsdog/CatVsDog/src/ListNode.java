
public class ListNode {
	private ListNode up;
	private ListNode down;
	private int left;
	private int right;
	private int num;
	private boolean close;
	
	public ListNode(int l, int r) {
		up = null;
		down = null;
		left = l;
		right = r;
	}
	
	public ListNode(int n) {
		up = null;
		down = null;
		num = n;
		close = false;
	}
	
	public void setUp(ListNode a) {
		up = a;
	}
	
	public void setDown(ListNode b) {
		down = b;
	}
	
	public void setClose() {
		close = true;
	}
	
	public ListNode getUp() {
		return up;
	}
	
	public ListNode getDown() {
		return down;
	}
	
	public int getL() {
		return left;
	}
	
	public int getR() {
		return right;
	}
	
	public int getNum() {
		return num;
	}
	
	public boolean getClose() {
		return close;
	}
	


}
