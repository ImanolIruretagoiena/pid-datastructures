package exercises;

class Entry{
	
	Object key;
	Object value;
	Entry next;
	
	Entry(Object key, Object value, Entry next){
		this.key = key;
		this.value = value;
		this.next = next;
	}
}

public class HashTable {
	
	public HashTable() {
		
	}
	
	private int SIZE = 1024;
	private Entry[] storage = new Entry[SIZE];
	
	/**
	 * Insert a key-value mapping into the hash table.
	 * @param key The key to insert.
	 * @param value The value to insert.
	 */
	public void insert(Object key, Object value) {
		//have to store key/value mapping somewhere! We use array
		
		if(key == null) {
			throw new IllegalArgumentException("null keys are not allowed");
		}
		
		//Step 1: convert key object to int value.
		int hc = key.hashCode();
		
		//Problem: hc could be super small (-2 billion),
		// super large (2 billion) or anything in between
		
		//What we need: an index between 0 and SIZE-1.
		//this will compute the remainder of the integer division by 1024.
		//remainder will be between 0 and 1023.
		int index = hc % SIZE;
		
		//Now we need to solve the collision issue.
		//get to first entry of chain.
		Entry entry = storage[index]; //normal array lookup
		
		//If chain is empty, we create a new entry object with reference of
		//next = null (it is empty after the one we are adding) and put it into
		//the correct index.
		if(entry == null) {
			Entry e = new Entry(key, value, null);
			storage[index] = e;
		} else {
			//entry != null
			Entry tmp = entry;
			while(tmp.next != null) {
				tmp = tmp.next;
			}
			//after the loop tmp.next = null
			//this means tmp is at this point the last Entry node.
			Entry ourNewEntry = new Entry(key, value, null);
			tmp.next = ourNewEntry;
		}
	}
	
	/**
	 * Looks up the value corresponding to the given key.
	 * @param key The key whose mapped value should be returned.
	 * @return The value that the given key maps to.
	 */
	public Object get(Object key) {
		return null; //not implemented yet
	}
}
