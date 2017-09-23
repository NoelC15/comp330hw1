
import java.util.Scanner;

public class organizer {
	
	private static String FILENAME;
	private static String FILENAME2; 
	private static String FILENAME3; 
	private static String FILENAME4;
	public static String [] MyArray;
	organizer(){
		FILENAME = "myRandom.txt";
		FILENAME2 = "myRandom2.txt";
		FILENAME3= "myRandom3.txt";
		FILENAME4 = "sushi-cookbook.txt";
		MyArray = new String [] {FILENAME,FILENAME2, FILENAME3, FILENAME4};
	}
		 
	wordRecognition X = new wordRecognition();
	Scanner input = new Scanner(System.in);
	
	public void Steps(){
		
		String userInPut =input.nextLine();
			if(userInPut.equals("1")){
				step1();
				}
			else if(userInPut.equals("2")){
				step2();
			}
			else if(userInPut.equals("3")){
				step3();
			}
			else if(userInPut.equals("4")){
				step4();
			}
			else if(userInPut.equals("5")){
				step5();
			}
			else if(userInPut.equals("6")){
				step6();
			}
			else if(userInPut.equals("exit()")){
				EndOfProgram();
			}
			else{
				System.out.println("Sorry invalid entry, try again!");
				Steps();
				//Starts Steps() method over if user types invalid input
			}
		
	}
	
	private void step1() {
			System.out.println("Which file would you like to view? \n1. myRandom.txt \n2. myRandom2.txt \n"
					+ "3. myRandom3.txt \n4. sushi-cookbook.txt");
			
			String next = input.nextLine();
			if(next.equals("1")){
				
				X.setFile(FILENAME);
				X.ReadAndPrint();
				X.ReadInFileIntoList();
				X.CountWord();
			}else if(next.equals("2")){
				X.setFile(FILENAME2);
				X.ReadAndPrint();
				X.ReadInFileIntoList();
				X.CountWord();
			}
			else if(next.equals("3")){
				X.setFile(FILENAME3);
				X.ReadAndPrint();
				X.ReadInFileIntoList();
				X.CountWord();
			}
			else if(next.equals("4")){
				X.setFile(FILENAME4);
				X.ReadAndPrint();
				X.ReadInFileIntoList();
				X.CountWord();
			}
			else{
				System.out.println("Invalid entry, try again");
				step1();
			}
			System.out.println("\nType another number to continue or exit() to leave.");
			PrintInst();
			Steps();
			//Takes user back to main setup
	}
	
	private void step2(){
		System.out.println("Which identifier would you like to look for in a file? (@ # or !)?");
		String UserInput = input.nextLine();
		if(!UserInput.equals("@") && !UserInput.equals("#") && !UserInput.equals("!")){
			System.out.println("Sorry invalid input. Try again.");
			step2();
		}else if(UserInput.equals("@") || UserInput.equals("#") || UserInput.equals("!")){
			System.out.println("Identifier " +UserInput+" appear in files:");
			for(int i =0; i<MyArray.length; i++){
				String file = MyArray[i];
				X.setFile(file);
				X.ReadInFileIntoList();
				boolean isItThere = X.FindString(UserInput);
				if(isItThere == true){
					String NameOfFile = X.getFile();
					System.out.println(NameOfFile);
				}
			}
		}
		System.out.println("\nType another number to continue or exit() to leave.");
		PrintInst();
		Steps();
	}
	
	private void step3() {
		System.out.println("Which identifier would you like to search for? (@ # or !)?");
		String UserInput = input.nextLine();
		if(!UserInput.equals("@") && !UserInput.equals("#") && !UserInput.equals("!")){
			System.out.println("Sorry invalid input. Try again.");
			step3();
		}else if(UserInput.equals("@") || UserInput.equals("#") || UserInput.equals("!")){
			System.out.println("Identifier " +UserInput+" Occurs:");
			for(int i =0; i<MyArray.length; i++){
				String file = MyArray[i];
				X.setFile(file);
				X.ReadInFileIntoList();
				int W = X.organizeAlphabetically(UserInput);
				System.out.println(W+ " in file: "+file);
			
			}
		}
		System.out.println("\nType another number to continue or exit() to leave.");
		PrintInst();
		Steps();
	}
	
	private void step4() {
		System.out.println("Not yet implemented! \nSelect another number or exit() to quit");
		PrintInst();
		Steps();
	}
	
	private void step5() {
		System.out.println("Not yet implemented! \nSelect another number or exit() to quit");
		PrintInst();
		Steps();
	}
	
	private void step6() {
		System.out.println("Not yet implemented! \nSelect another number or exit() to quit");
		PrintInst();
		Steps();
	}

	public void PrintHelloInst(){
		System.out.println("Hello!");
		System.out.println("Please select a number to output your text files identifier or exit() to quit.");
		System.out.println("1. Text reader and word counter for all words in file. \n2. Orginize files by identifiers \n3. View how many times an identifier appears in a file. \n4. "
				+ "Notes in order by frequently used words \n5. Files conatining words with @ \n6. "
				+ "Notes in topological order");
	}
	
	public void PrintInst(){
		System.out.println("1. Text reader and word counter for all words in file. \n2. Orginize files by identifiers \n3. View how many times an identifier appears in a file. \n4. "
				+ "Notes in order by frequently used words \n5. Files conatining words with @ \n6. "
				+ "Notes in topological order");
	}
	
	private void EndOfProgram() {
		System.out.println("GoodBye!");
	}
}