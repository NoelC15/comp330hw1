public class FileData{

	private static final String FILENAME = "myRandom.txt";
	
	
	public static void main(String[] args) {
	
		wordRecognition File = new wordRecognition();
		File.setFile(FILENAME);
		File.ReadInFile();
		File.CountWord();
		
	}
}
