package exercises;

/**
 * Main class for project.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
public class Main {

	/**
	 * Runs the application.
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		list.add(7);
		LinkedList newList = list.createReversedList();
		for(int i = 0; i < newList.size(); i++) {
			System.out.println(newList.get(i));
		}
	}

}
