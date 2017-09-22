import java.util.Scanner;

public class organizer {
	
	private static String FILENAME = "myRandom.txt";
	private static String FILENAME2 = "myRandom2.txt";
	private static String FILENAME3 = "myRandom3.txt";
	public String file;
	public String file2;
	public String file3;
	
	organizer(){
		file = FILENAME;
		file2 = FILENAME2;
		file3 = FILENAME3;
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
				//User typed an invalid input, starts Steps() method over
			}
		
	}
	
	private void step1() {
			System.out.println("Which file would you like to view? \n1. myRandom.txt \n2. myRandom2.txt \n"
					+ "3. myRandom.txt");
			
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
			else{
				System.out.println("Invalid entry, try again");
				PrintInst();
				step1();
			}
			System.out.println("\nType another number to continue or exit() to leave.");
			PrintInst();
			Steps();
			//Allows user to go back to main setup
	}
	
	private void step2(){
		String a = file;
		String b = file2;
		String c = file3;
		int count = 0;
		
		System.out.println("Files containing identifier @:");
		while(count < 3){
			String Words;
			if(count ==0){
				Words = a;
			}
			else if(count==2){
				Words = b;
			}else{
				Words = c;
			}
			X.setFile(Words);
			X.ReadInFileIntoList();
			boolean isItThere = X.FindIdent();
			if(isItThere == true){
				String NameOfFile = X.getFile();
				System.out.println(NameOfFile);
			}else if(isItThere == false){
				System.out.println("Files that DO NOT contain identifier @.");
				String NameOfFile = X.getFile();
				System.out.println(NameOfFile+ "\n");
			}
			count++;
		}
		System.out.println("\nType another number to continue or exit() to leave.");
		PrintInst();
		Steps();
		
	}
	
	private void step3() {
		System.out.println("Not yet implemented! \nSelect another number or exit() to quit");
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
		System.out.println("1. Word count \n2. Orginize by identifiers \n3. Frequently used words in a file \n4. "
				+ "Notes in order by frequently used words \n5. FIles conatining words with @ \n6. "
				+ "Notes in topological order");
	}
	
	public void PrintInst(){
		System.out.println("1. Word count \n2. Orginize by identifiers \n3. Frequently used words in a file \n4. "
				+ "Notes in order by frequently used words \n5. FIles conatining words with @ \n6. "
				+ "Notes in topological order");
	}
	
	private void EndOfProgram() {
		System.out.println("GoodBye!");
	}
}

