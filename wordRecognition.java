import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class wordRecognition {
	
	public ArrayList<String> List;
	public String File;
	public String [] OrderedList;
	
	wordRecognition(){
		File = "File can not be read";
		List = new ArrayList<String>();
		OrderedList = null;
	}
	
	wordRecognition(String newFile){
		File = newFile;
	}
	
	public void setFile(String file){
		File = file;
	}
	
	public String getFile(){
		return File;
	}
	
	public void setArrayList(ArrayList<String> list){
		List = list;
	}
	
	public ArrayList<String> getList(){
		return List;
	}
		
	public void CountWord(){
		String [] stringArr = List.toArray(new String[0]);
		String str = Arrays.toString(stringArr);
        String[] splitStr = str.split(" *(,|=>| |\\.) *" );
        int count =0;
        List<String> List2 = new ArrayList<>();
        for(String s:splitStr){
            if(!List2.contains(s)){
                List2.add(s);
            }
        }
        for(int i=0;i<List2.size();i++){
            for(int j=0;j<splitStr.length;j++){
                if(List2.get(i).equals(splitStr[j])){
                    count++;
                }
            }
            System.out.println("Occurrence of <" + List2.get(i) + "> is " + count + " times.");
            count = 0;
        }	
        List.clear();
	}
	
	public void ReadAndPrint(){
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(File);
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
			
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
	
	public void ReadInFileIntoList(){
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(File);
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				addToList(sCurrentLine);
			}
			
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
	
	public void addToList(String ListToAdd){
		List.add(ListToAdd);
	}
	
	public boolean FindString(String Indentifier){
		
		boolean isThere = false;
		for(int i =0;i<List.size();i++){
			
			if(List.get(i).contains(Indentifier)){
				
				isThere = true;
				List.clear();
				break;
			}
		}
		List.clear();
		return isThere;
	}
	
	public void StoreList(String[] myList){
		OrderedList = myList;
	}
	public String[] getArrayList(){
		return OrderedList;
	}
}