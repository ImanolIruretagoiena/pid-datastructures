package exercises;

class Node{
	
	int elem;
	Node next;
	Node(int elem, Node next){
		this.elem = elem;
		this.next = next;
	}
}

public class LinkedList {

	private Node first = null;
	private Node last = null;
	
	public void add(int elem) {
		
		if(first == null) {
			first = new Node(elem, null);
			last = first;
		} else {
			Node nodeForElem = new Node(elem, null);
			last.next = nodeForElem;
			last = nodeForElem;
		}
	}
	
	public int get(int index) {
		
		Node tmp = first;
		int counter = 0;
		while(counter < index && tmp.next != null) {
			tmp = tmp.next;
			counter++;
		}
		if(counter == index) {
			return tmp.elem;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
}
