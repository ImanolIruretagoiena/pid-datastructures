package exercises;

/**
 * Class for Entry elements inside a HashTable.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
class Entry{
	
	// Key for Entry element.
	Object key;
	// Value for Entry element.
	Object value;
	// Reference to the next Entry in the HashTable.
	Entry next;
	
	/**
	 * Constructor for creating new Entry elements.
	 * @param key Key of new element.
	 * @param value Value of new element.
	 * @param next Next reference of new element.
	 */
	Entry(Object key, Object value, Entry next){
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

/**
 * This class implements a standard HashTable with two main operations: insert and get.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
public class HashTable {
	
	// Standard initial size for the array for storing key/value mapping.
	private int SIZE = 1024;
	// Create a new array of Entry elements with the specified size.
	private Entry[] storage = new Entry[SIZE];
	
	/**
	 * Default constructor.
	 */
	public HashTable() {
	}
	
	/**
	 * Insert a key-value mapping into the HashTable.
	 * @param key The key to insert.
	 * @param value The value to insert.
	 */
	public void insert(Object key, Object value) {
		
		// Trying to insert a null key results in an exception.
		if(key == null) {
			throw new IllegalArgumentException("null keys are not allowed");
		}
		
		// Step 1: convert the key object to an int value using a Hash function.
		int hashCode = key.hashCode();
		
		// Problem: hashCode could be super small (-2 billion), super large (2 billion) or anything
		// in between. What we need: an index between 0 and SIZE-1. For this we use the modulo
		// operator. This will compute the remainder of the integer division by 1024. The remainder
		// will always be between 0 and 1023.
		int index = hashCode % SIZE;
		
		// Get to the first entry of the chain in that index.
		Entry entry = storage[index];
		
		// If chain is empty, we create a new Entry object with reference of next = null (it is empty
		// after the one we are adding) and put it into the correct index.
		if(entry == null) {
			Entry newEntry = new Entry(key, value, null);
			storage[index] = newEntry;
		} else {
			// Chain is not empty. So we create a temporary Entry object to iterate through the
			// chain. It is equal to the first element in the chain at first.
			Entry temp = entry;
			
			// Not enough to go to the last Entry object, because we may have to update an existing
			// Entry object with a new value (see Test).
			while(temp.next != null && temp.key != key) {
				temp = temp.next;
			}
			if(temp.key == key) {
				// Found the key in the chain, value is updated to the new one.
				temp.value = value;
			} else {
				// We reached the end of the chain without finding the given key. We add a new Entry
				// object right after it.
				Entry newEntry = new Entry(key, value, null);
				temp.next = newEntry;
			}
		}
	}
	
	/**
	 * Looks up the value corresponding to the given key.
	 * @param key The key whose mapped value should be returned.
	 * @return The value that the given key maps to.
	 */
	public Object get(Object key) {
		
		// As before.
		int hashCode = key.hashCode();
		int index = hashCode % SIZE;
		
		// entry is either null or the first object in the chain.
		Entry entry = storage[index];
		
		if(entry == null) {
			// There is no mapping, no elements in that index.
			return null;
		}
		
		// If chain is not empty, it is iterated through until the given key is found. Then the
		// corresponding value is returned. Still one issue here: if chain is not empty but given
		// key is not in it. At some point temp becomes null and doing temp.key will throw a
		// NullPointerException.
		Entry temp = entry;
		boolean found = false;
		while(found == false) {
			if(temp.key == key) {
				found = true;
			} else {
				temp = temp.next;
			}
		}
		return temp.value;
	}
}
