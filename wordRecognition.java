import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class wordRecognition {
	
	public ArrayList<String> List;
	public String File;

	wordRecognition(){ //wordRecognition object
		File = "File can not be read"; //Temp File
		List = new ArrayList<String>(); //Temp Array
	}

	public void addToList(String ListToAdd){ //Adds element to list
		List.add(ListToAdd);
	}
	public void CountWord(){ //Splits the strings based on punctuation
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
		for(int i=0;i<List2.size();i++){ //Counts the number of occurrences
			for(int j=0;j<splitStr.length;j++){
				if(List2.get(i).equals(splitStr[j])){
					count++;
				}
			}
			System.out.println("Occurrence of <" + List2.get(i) + "> is " + count + " times.");
			count = 0;
		}
	}

	public String getFile(){ //Gives back the name of the file in the object
		return File;
	}

	public ArrayList<String> getList(){ // Gives back the array of the object
		return List;
	}

	public void ReadInFile(){ //Reader
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(File);
			br = new BufferedReader(fr);

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
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

	public void setArrayList(ArrayList<String> list){ //Replaces temp array with real array
		List = list;
	}

	public void setFile(String file){ //Replaces temp file with a real file
		File = file;
	}

	public void wordRecognition(String newFile){ //Creates new instance of wordRecognition object
		File = newFile;
	}

	//Topological Sort section

	Hashtable<Node, ArrayList<Node>> topSort = new Hashtable<Node, ArrayList<Node>>();
	ArrayList<Node> nodes = new ArrayList<Node>();

	public void add(Node node) { //Will add a node
		if (topSort.contains(node)) {
			return;
		}
		else {
			topSort.put(node, new ArrayList<Node>());
			nodes.add(node);
		}
	}

	public void addNeighbors(Node from, Node to) { //Dedicates Neighbor
		if (!topSort.containsKey(from)) {
			add(from);
		}
		if (!topSort.containsKey(to)) {
			add(to);
		}
		topSort.get(from).add(to);
		to.inDegree++;
		to.inNodes.add(from);
	}

	public void addNeighbor(Node from, ArrayList<Node> list) { //Will add a neighbor
		for (Node to: list) {
			addNeighbor(from, to);
		}
	}

}