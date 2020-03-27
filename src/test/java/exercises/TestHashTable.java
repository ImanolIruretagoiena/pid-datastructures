package exercises;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHashTable {

	@Test
	public void testInsertIntoEmptyHashTable() {
		HashTable t = new HashTable();
		t.insert("SE", "Stockholm");
		String result = (String) t.get("SE");
		assertEquals("Stockholm", result);
	}
	
	@Test
	public void testInsertTwiceWithSameKeyIntoEmptyHashTable() {
		HashTable t = new HashTable();
		t.insert("SE", "Stockholm");
		//we want to change the value for key "SE"
		t.insert("SE", "Gothenburg");
		String result = (String) t.get("SE");
		assertEquals("Gothenburg", result);
	}
	
	@Test
	public void testGetKeyFromEmptyHashTable() {
		HashTable t = new HashTable();
		Object result = t.get("SE");
		assertEquals(null, result);
	}
}
