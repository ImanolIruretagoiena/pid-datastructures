package exercises;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for HashTable implementation.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
public class TestHashTable {

	/**
	 * Test which shows successful insertion of a new key value pair into an empty HashTable.
	 */
	@Test
	public void testInsertIntoEmptyHashTable() {
		HashTable hashTable = new HashTable();
		hashTable.insert("SE", "Stockholm");
		String result = (String) hashTable.get("SE");
		assertEquals("Stockholm", result);
	}
	
	/**
	 * Test which shows how inserting a key value pair with a key that already exists in the HashTable
	 * will result in the value for that key being updated to the new one.
	 */
	@Test
	public void testInsertTwiceWithSameKeyIntoEmptyHashTable() {
		HashTable hashTable = new HashTable();
		hashTable.insert("SE", "Stockholm");
		// We want to change the value for key "SE".
		hashTable.insert("SE", "Gothenburg");
		String result = (String) hashTable.get("SE");
		assertEquals("Gothenburg", result);
	}
	
	/**
	 * Test which shows how the value of a given key in an empty HashTable is null.
	 */
	@Test
	public void testGetKeyFromEmptyHashTable() {
		HashTable hashTable = new HashTable();
		Object result = hashTable.get("SE");
		assertEquals(null, result);
	}
}
