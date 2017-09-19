import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileData{

	private static final String FILENAME = "myRandom2.txt";
	
	
	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			ArrayList<String> list = new ArrayList<String>();
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
				list.add(sCurrentLine);
			}
			String [] stringArr = list.toArray(new String[0]);
			String NewFile = Arrays.toString(stringArr);
			wordRecognition Line = new wordRecognition(NewFile);
			Line.CountWord();
			
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}
	
}
