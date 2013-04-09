
public class CatLoverGroup {
	private CatLover[] catLG;
	private int length;
	
	public CatLoverGroup(CatLover[] c) {
		catLG = c;
		length = 0;
		trim(c.length);
	}
	
	public void trim(int len) {
		int adi = 0;
		for(int i = 0; i < len; i++) {
			if(catLG[i] != null) length++;
		}
		if(length == 0)
			catLG = null;
		else {
			CatLover[] newcatLG = new CatLover[length];
			for(int i = 0; i < len; i++) {
				if(catLG[i] != null) {
					newcatLG[adi] = catLG[i];
					adi++;
				}			
			}
			catLG = newcatLG;	
		}
	}
	
	public CatLover[] getCatLG() {
		return catLG;
	}
	
	public int getLength() {
		return length;
	}
}
