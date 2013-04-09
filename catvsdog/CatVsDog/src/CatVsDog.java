import java.util.Scanner;


public class CatVsDog {

	/**
	 * @author:
	 * Du Huang
	 */
	public static void main(String[] args) {
		int testcases;
		int numOfCats;
		int numOfDogs;
		int numOfVoters;
		int[] mostSatisfy;
		CatLoverGroup[] CLG;
		DogLoverGroup[] DLG;
		CatLover catLG[];
		DogLover dogLG[];
		Scanner reader = new Scanner(System.in);
		testcases = reader.nextInt();
		CLG = new CatLoverGroup[testcases];
		DLG = new DogLoverGroup[testcases];
		mostSatisfy = new int[testcases];
		
		for(int tests = 0; tests < testcases; tests++){
			
			numOfCats = reader.nextInt();	
			numOfDogs = reader.nextInt();	
			numOfVoters = reader.nextInt();
			
			catLG = new CatLover[numOfVoters];
			dogLG = new DogLover[numOfVoters];
			
			for(int i = 0; i < numOfVoters; i++) {
				String love = reader.next();
				String hate = reader.next();
				int numL = Integer.parseInt(love.substring(1));
				int numH = Integer.parseInt(hate.substring(1));
	
				if(love.charAt(0) == 'C') 
					catLG[i] = new CatLover(numL, numH);
				else {
					dogLG[i] = new DogLover(numL, numH);
				}
				
			}
			CLG[tests] = new CatLoverGroup(catLG);
			DLG[tests] = new DogLoverGroup(dogLG);
			
			if(CLG[tests] == null || DLG[tests] == null)
				mostSatisfy[tests] = numOfVoters;
			else {
				BipartiteG contras = new BipartiteG(CLG[tests], DLG[tests]);

				if(contras.getContraPairs() == 0) {
					mostSatisfy[tests] = numOfVoters;
				}
				else {
					mostSatisfy[tests] = numOfVoters - contras.getMaxMatching();//System.out.println(numOfVoters - contras.getMaxMatching());

				}

			}
		}
		for(int i = 0; i < testcases; i++) {
			System.out.println(mostSatisfy[i]);
		}
				
	}
	
}
