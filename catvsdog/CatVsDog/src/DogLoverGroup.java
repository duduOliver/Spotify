
public class DogLoverGroup {
	private DogLover[] dogLG;
	private int length;
	
	public DogLoverGroup(DogLover[] d) {
		dogLG = d;
		length = 0;
		trim(d.length);
	}
	
	public void trim(int len) {
		int adi = 0;
		for(int i = 0; i < len; i++) {
			if(dogLG[i] != null) length++;
		}
		if(length == 0)
			dogLG = null;
		else {
			DogLover[] newdogLG = new DogLover[length];
			for(int i = 0; i < len; i++) {
				if(dogLG[i] != null) {
					newdogLG[adi] = dogLG[i];
					adi++;
				}
			}
			dogLG = newdogLG;	
		}
	}
	
	public DogLover[] getDogLG() {
		return dogLG;
	}
	
	public int getLength() {
		return length;
	}
}