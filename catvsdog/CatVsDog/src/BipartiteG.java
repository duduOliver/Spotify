
public class BipartiteG {
	private CatLoverGroup leftC;
	private DogLoverGroup rightD;
	private int[][] edge;
	private Vector[] edgeVec;
	private List contraL;
	private List contraR;
	private List mEdges;
	private List path;
	private boolean addIt;
	private int contraPairs;
	private int maxMatching;
	
	public BipartiteG(CatLoverGroup c, DogLoverGroup d) {
		leftC = c;
		rightD = d;
		edge = new int[c.getLength()][d.getLength()];
		edgeVec = new Vector[c.getLength()*d.getLength()];
		contraL = new List();
		contraR = new List();
		mEdges = new List();
		path = new List();
		maxMatching = 0;
		setEdge();
		initialMatching();
		maxMatching();
	}
	
	public void setEdge() {
		contraPairs = 0; 
		
		for(int i = 0; i < leftC.getLength(); i++) {
			addIt = false;
			for(int j = 0; j < rightD.getLength(); j++) {
				if(leftC.getCatLG()[i].getLove() == rightD.getDogLG()[j].getHate() || leftC.getCatLG()[i].getHate() == rightD.getDogLG()[j].getLove()) {
					edge[i][j] = 1;
					edgeVec[contraPairs] = new Vector(i, j);
					contraPairs++;
					addIt = true;
				}
			}
			if(addIt == true) contraL.addNode(new ListNode(i));
		}
	}
	
	public void initialMatching() {
		
		
		ListNode cursorL = contraL.getHead();
		ListNode cursorR;
		while(cursorL != null) {
			addIt = false;
			int rIndex = 0;
			cursorR = contraR.getHead();
			while(addIt == false && rIndex < rightD.getLength()) {
				if(edge[cursorL.getNum()][rIndex] == 1) {
					if(cursorR == null) {
						contraR.addNode(new ListNode(rIndex));
						mEdges.addNode(new ListNode(cursorL.getNum(), rIndex));
						addIt = true;
						maxMatching++;
						cursorL.setClose();
					}
					else {
						boolean repreat = false;
						while(cursorR != null) {
							if(rIndex == cursorR.getNum()) {
								repreat = true;
							}
							cursorR = cursorR.getDown();
						}
						if(repreat == false) {
							contraR.addNode(new ListNode(rIndex));
							mEdges.addNode(new ListNode(cursorL.getNum(), rIndex));
							addIt = true;
							maxMatching++;
							cursorL.setClose();
						}
					}
				}
				rIndex++;
			}
			cursorL = cursorL.getDown();
		}	
	}
	
	public boolean fullAugmentingPath(List r, ListNode lEnd) {
		boolean exist = false;
		path.addNode(lEnd);
		for(int i = 0; i < rightD.getLength(); i++) {
			if(edge[lEnd.getNum()][i] == 1) {
				if(r.vExist(i) == false && path.vExist(i) == false) {
					path.addNode(new ListNode(i));
					return true;
				}
			}
		}
		ListNode cursorR = r.getHead();
		while(cursorR != null && exist == false) {
			if(edge[lEnd.getNum()][cursorR.getNum()] == 1 && mEdges.eExist(lEnd.getNum(), cursorR.getNum()) == false && path.vExist(cursorR.getNum()) == false) {
				path.addNode(cursorR);
				exist = fullAugmentingPath(r, mEdges.tellLeft(cursorR.getNum()));

			}
			cursorR = cursorR.getDown();	
		}
		
		return exist;
	}
	
/*	public boolean findAugmentingPath(List r, ListNode lEnd) {
		boolean exi = false;
		//List tempR = new List();// get it from the para
		//tempR.copyList(r);//fool's error
		//System.out.println(r+ ", " + contraR + ", see here");/////////////////
		for(int i = 0; i < rightD.getLength(); i++) {
			if(edge[lEnd.getNum()][i] == 1) {
				if(r.vExist(i) == false) {//get a totally new edges and both new endings
					//exi = true;
					path.addNode(new ListNode(i));//????????????
					contraR.addNode(new ListNode(i));//XXXif the left node is different but the right node is the same, we add DUPLICATED node
					mEdges.addNode(new ListNode(lEnd.getNum(), i));
					lEnd.setClose();
					
					return true;
				}
			}
		}
		ListNode cursorR = r.getHead();
		//System.out.println(tempR.getHead().getDown());/////////////////

		while(cursorR.getDown() != null){
			System.out.println("here");/////////////////

			if(edge[lEnd.getNum()][cursorR.getNum()] == 1) {
				path.addNode(cursorR);
				//contraR.addNode(new ListNode(i));
				mEdges.addNode(new ListNode(lEnd.getNum(), cursorR.getNum()));
				//path.addNode(mEdges.tellLeft(cursorR.getNum()));
				
				r.del(cursorR);
				//System.out.println(cursorR.getDown());/////////////////

				findAugmentingPath(r, mEdges.tellLeft(cursorR.getNum()));
				//System.out.println(r.getHead() + ", " + contraR.getHead());/////////////////
				
				
			}
			cursorR = cursorR.getDown();
			//System.out.println(cursorR);/////////////////
			//System.exit(0);

		}
		
		return exi;
		
	}*/
	
	public void maxMatching() {
		ListNode cursor = contraL.getHead();
		while(cursor != null) {
			if(cursor.getClose() == false) {

				path = new List();
				List tempR = new List();
				tempR.copyList(contraR);

				boolean change = fullAugmentingPath(tempR, cursor);
				if(change == true) {

					maxMatching++;
					contraR.addNode(new ListNode(path.getTail().getNum()));
					ListNode pathCursor = path.getHead();
					while(pathCursor.getDown() != null) {
						mEdges.addNode(new ListNode(pathCursor.getNum(), pathCursor.getDown().getNum()));
						pathCursor = pathCursor.getDown();
						if(pathCursor.getDown() != null) {
							mEdges.delEdge(pathCursor.getDown().getNum(), pathCursor.getNum());
							pathCursor = pathCursor.getDown();
						}						
					}
				}
			}
			cursor = cursor.getDown();
		}
	}
	
	public int getContraPairs() {
		return contraPairs;
	}
	
	public int getMaxMatching() {
		return maxMatching;
	}
	

}
