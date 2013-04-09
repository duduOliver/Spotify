import java.io.IOException;
import java.util.Scanner;
/*
 * codes in comment are for second method with List Data Structure, but that's slower.
 */


public class ZipfSong {

	/**
	 * @author 
	 * 		Du Huang
	 */
	public static void main(String[] args) throws IOException {
		int numOfSongs;
		int numOfPrint;
		int order = 2;
		//SongPriorityList songList;
		SongBST songTree;
		//SongListNode cursor;
		SongNode cursor;
		//SongListNode newNode;
		SongNode newNode;
		Scanner reader = new Scanner(System.in);
		
		numOfSongs = reader.nextInt();
		numOfPrint = reader.nextInt();		
		//songList = new SongPriorityList(1, reader.nextLong(), reader.next());
		songTree = new SongBST(reader.nextLong(), reader.next());
		//cursor = songList.getHead();
		//cursor = songTree.getRoot();

		while(numOfSongs - order > -1) {
			newNode = new SongNode(order, reader.nextLong(), reader.next());
			songTree.insertNode(newNode);
			//cursor = songTree.getHead();
			order++;
		}
		songTree.inorderTraversalArray(songTree.getRoot());
		cursor = songTree.getMaxList().getHead();
		
		for(int i = 0; i < numOfPrint; i++) {
			//System.out.println(cursor.getData().getName());
			System.out.println(cursor.getData().getName());
			cursor = cursor.getRight();
		}
	}
}
