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

/**
 * This hash table implements a standard hash table with two
 * main operations: insert and get.
 * @author Imanol Iruretagoiena
 *
 */
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
			
			//not enough to go to the last Entry object, because we may have to update
			//an existing Entry object with a new value (see Test).
			while(tmp.next != null && tmp.key != key) {
				tmp = tmp.next;
			}
			if(tmp.key == key) {
				//found the key in the table, value needs to be updated
				tmp.value = value;
			} else {
				//tmp.next = null
				//this means tmp is at this point the last Entry node.
				//We add a new Entry object right after it.
				Entry ourNewEntry = new Entry(key, value, null);
				tmp.next = ourNewEntry;
			}
		}
	}
	
	/**
	 * Looks up the value corresponding to the given key.
	 * @param key The key whose mapped value should be returned.
	 * @return The value that the given key maps to.
	 */
	public Object get(Object key) {
		//we want to return the value that the given key maps to.
		
		//as before
		int hc = key.hashCode();
		int index = hc % SIZE;
		
		//entry is either null or the first object in the chain
		Entry entry = storage[index];
		
		if(entry == null) {
			//there is no mapping
			return null;
		}
		
		//Still one issue here: if table is not null but given key is
		//not in it. At some point tmp becomes null and doing tmp.key
		//will throw a NullPointerException.
		Entry tmp = entry;
		boolean found = false;
		while(!found) {
			if(tmp.key == key) {
				found = true;
			} else {
				tmp = tmp.next;
			}
		}
		return tmp.value;
	}
}
