public class Node {

		String value;
		boolean visited = false;
		int inDegree = 0;
		ArrayList<Node> inNodes = new ArrayList<Node>();


		public Node (String value) {
			this.value = value;
		}
	}

}