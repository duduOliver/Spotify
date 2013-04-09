
public class Song {
	private long timesTorder;
	private String name;
	private int order;
	
	public Song(int sOrder, long times, String n) {
		order = sOrder;
		timesTorder = times*sOrder;
		name = n;		
	}
	
	public int getOrder() {
		return order;
	}
	
	public long getTimesTorder() {
		return timesTorder;
	}
	
	public String getName() {
		return name;
	}
}
