
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
		System.out.println("Type in an identifier (@ # or !) to show which files contain that identifier.");
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
				int W = X.organizeByCount(UserInput);
				System.out.println(W+ " in file: "+file);
			
			}
		}
		System.out.println("\nType another number to continue or exit() to leave.");
		PrintInst();
		Steps();
	}
	
	private void step4() {
		int x = 0;
		String fi = "NO WORDS";
		System.out.println("Which file would you like to see identifiers for? \n"
				+ "1. myRandom.txt \n2. myRandom2.txt \n3. myRandom3.txt \n4. sushi-cookbook.txt");
		String UserInput = input.nextLine();
		if(!UserInput.equals("1") && !UserInput.equals("2") && !UserInput.equals("3") && !UserInput.equals("4")){
			System.out.println("Sorry invalid input. Try again.");
			step4();
		}else if(UserInput.equals("1")){
			x = 0;
			fi = MyArray[0];
		}else if(UserInput.endsWith("2")){
			x =1;
			fi = MyArray[1];
		}else if(UserInput.equals("3")){
			x =2;
			fi = MyArray[2];
		}else if (UserInput.equals("4")){
			x = 3;
			fi = MyArray[3];
		}
			System.out.println("Identifier in file "+fi+":");
			for(int i =0; i<1; i++){
				String file = MyArray[x];
				X.setFile(file);
				X.ReadInFileIntoList();
				X.PrintWOrds("@","#","!");
			}
		
		PrintInst();
		Steps();
	}
	
	public void PrintHelloInst(){
		System.out.println("Hello!");
		System.out.println("Below are a few options, please select the number that you would like to activate.");
		System.out.println("1. Text reader and word counter for all words in file. \n2. Orginize files by identifiers. \n3. View how many times an identifier appears in a file. \n4. "
				+ "View files identifiers.");
	}
	
	private void PrintInst(){
		System.out.println("1. Text reader and word counter for all words in file. \n2. Orginize files by identifiers. \n3. Place files in Alphabetical order with @ identifier. \n4. "
				+ "View files identifiers.");
	}
	
	private void EndOfProgram() {
		System.out.println("GoodBye!");
	}
}