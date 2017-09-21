import org.junit.Test;

public class FileData{
	private static final String FILENAME = "myRandom.txt";

	@Test
	public void testCountWord(){
		wordRecognition File = new wordRecognition();
		File.CountWord;
	}

	@Test
	public void testReadInFile(){
		wordRecognition File = new wordRecognition();
		File.ReadInFile;
	}

	@Test
	public void testSetFile(){
		wordRecognition File = new wordRecognition();
		File.setFile;
	}


	public static void main(String[] args) {
		wordRecognition File = new wordRecognition();
		File.setFile(FileName);
		File.ReadInFile();
		File.CountWord();
		
	}
}
