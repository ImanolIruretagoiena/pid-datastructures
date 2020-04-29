package exercises;

/**
 * Class for Node elements inside a LinkedList.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
class Node{
	
	// Number stored in the Node.
	int element;
	// Reference to the next Node in the list.
	Node next;
	
	// Constructor for Node element with given number and reference.
	Node(int element, Node next){
		this.element = element;
		this.next = next;
	}
}

/**
 * Class for LinkedList implementation.
 * @author ImanolIruretagoiena 
 * @version 2020.04.29
 */
public class LinkedList {

	// First Node in the LinkedList. It will be null until Nodes are added.
	private Node first = null;
	// Last Node in the LinkedList. It will be null until Nodes are added.
	private Node last = null;
	
	/**
	 * Method for adding a given integer value into the LinkedList.
	 * @param element Integer element to be added.
	 */
	public void add(int element) {
		
		// If list is empty, a new Node is created and set to be both the first and last Node.
		// It won't have any Node after it, so next reference is null.
		if(first == null) {
			first = new Node(element, null);
			last = first;
		// If list is not empty, a new Node is created and the reference of the last Node is
		// changed from null to the new Node we have created. Then the new Node is set as
		// the new last Node.
		} else {
			Node nodeForElem = new Node(element, null);
			last.next = nodeForElem;
			last = nodeForElem;
		}
	}
	
	/**
	 * Method which returns the element in the specified index.
	 * @param index Index value of the element we want to get.
	 * @return Element located at that index.
	 */
	public int get(int index) {
		
		// Get the size first using the size method implemented below.
		int size = size();
		// If an invalid index value is given, an exception is thrown.
		if(index < 0 | index >= size) {
			throw new IndexOutOfBoundsException();
		// If the index value is valid, list is iterated through until the correct Node is
		// reached. Then the element value of that Node is returned.
		} else {
			Node temp = first;
			int counter = 0;
			while(counter < index) {
				temp = temp.next;
				counter++;
			}
			return temp.element;
		}
	}
	
	/**
	 * Method which returns the size of the LinkedList.
	 * @return Size of the LinkedList.
	 */
	public int size() {
		
		// List is iterated through until the last Node is reached. By keeping a counter of how many
		// steps are done we can get the size of the list.
		int counter = 0;
		Node temp = first;
		while(temp != null) {
			temp = temp.next;
			counter++;
		}
		return counter;
	}
	
	/**
	 * Method to remove the element in the specified index.
	 * @param index Index location of the element to be removed.
	 */
	public void remove(int index) {
		int size = size();
		// If list is empty, size is 0. No matter which index value is given, the method
		// will throw an exception. If the list is not empty but an invalid index value is
		// given, an exception is thrown as well.
		if(index < 0 | index >= size) {
			throw new IndexOutOfBoundsException();
		// If the list is not empty and a valid index value is given, the list is iterated through
		// until we are at the Node before the one we want to remove.
		} else {
			Node temp = first;
			int counter = 0;
			while(counter < index - 1) {
				temp = temp.next;
				counter++;
			}
			// In case we want to remove the first element, index = 0, so the while loop
			// is not entered and the code below is executed. First Node is changed to
			// the second Node, therefore removing the First Node.
			if(index == 0) {
				first = temp.next;
				return;
			}
			// In case we want to remove an element from the middle or the end of the list,
			// all we do is change the reference of the element BEFORE the one we want to remove
			// (at this point we are at index - 1 after the while loop). So the "next" reference
			// is changed to the "next.next", meaning we "jump" the element we are removing.
			temp.next = temp.next.next;
		}
	}
	
	/**
	 * Method for creating a new reversed LinkedList.
	 * @return Reversed LinkedList.
	 */
	public LinkedList createReversedList() {
		int size = size();
		LinkedList reversedList = new LinkedList();
		Node temp = first;
		int counter = 0;
		while(counter < size) {
			// At the beginning the reversed list is empty. We just add a new Node with the element
			// value of the first item in the normal list. This is both the first and last Node.
			if(reversedList.first == null) {
				reversedList.first = new Node(temp.element, null);
				reversedList.last = reversedList.first;
			// When we already have Nodes in the reversed list, we just add the subsequent items
			// from the normal list, making sure to add them before the one we have added earlier.
			// So the next reference of the added Node is the Node we added earlier. Then the newly
			// added Node is set to be the new first Node in the list.
			} else {
				Node nodeForElem = new Node(temp.element, reversedList.first);
				reversedList.first = nodeForElem;
			}
			temp = temp.next;
			counter++;
		}
		return reversedList;
	}
}
