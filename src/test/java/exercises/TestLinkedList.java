package exercises;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for LinkedList implementation.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
public class TestLinkedList {

	/**
	 * Test which shows successful addition of new elements into the list.
	 */
	@Test
	public void testAddSingleElement() {
		LinkedList list = new LinkedList();
		list.add(5);
		int result = list.get(0);
		assertEquals(5, result);
	}
	
	/**
	 * Test which shows successful addition of an element into a list already containing another
	 * element. New elements are always added at the end of the list.
	 */
	@Test
	public void testAddTwoElements() {
		
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		int result = list.get(0);
		assertEquals(5, result);
	}
	
	/**
	 * Test which shows how a second element was correctly added to the end of the list.
	 */
	@Test
	public void testAddTwoElementsAndGetSecond() {
		
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		int result = list.get(1);
		assertEquals(2, result);
	}
	
	/**
	 * Test which shows how trying to get an element from an invalid index results in an exception
	 * being thrown.
	 */
	@Test
	public void testAddSingleElementAndGetSecond() {
		
		LinkedList list = new LinkedList();
		list.add(5);
		boolean success = false;
		try {
			int result = list.get(1);
		} catch(IndexOutOfBoundsException e) {
			success = true;
		}
		assertEquals(true, success);
	}
	
	/**
	 * Test which shows how trying to get an element from an empty list results in an exception
	 * being thrown.
	 */
	@Test
	public void testGetElementFromEmptyList() {
		LinkedList list = new LinkedList();
		boolean success = false;
		try {
			int result = list.get(0);
		} catch(IndexOutOfBoundsException e) {
			success = true;
		}
		assertEquals(true, success);
	}
	
	/**
	 * Test which shows how trying to get an element from a negative index results in an exception
	 * being thrown.
	 */
	@Test
	public void testGetWithNegativeIndex() {
		LinkedList list = new LinkedList();
		list.add(5);
		boolean success = false;
		try {
			int result = list.get(-1);
		} catch(IndexOutOfBoundsException e) {
			success = true;
		}
		assertEquals(true, success);
	}
	
	/**
	 * Test which shows how the size of an empty list is equal to zero.
	 */
	@Test
	public void testSizeWithEmptyList() {
		LinkedList list = new LinkedList();
		int result = list.size();
		assertEquals(0, result);
	}
	
	/**
	 * Test which shows correct size of list is displayed when there's only one element in it.
	 */
	@Test
	public void testSizeWithSingletonList() {
		LinkedList list = new LinkedList();
		list.add(5);
		int result = list.size();
		assertEquals(1, result);
	}
	
	/**
	 * Test which shows correct size of the list is displayed when there are multiple elements in it.
	 */
	@Test
	public void testSizeWithNonEmptyList() {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		list.add(7);
		list.add(12);
		int result = list.size();
		assertEquals(4, result);
	}
	
	/**
	 * Test which shows how trying to remove an element from an empty list results in an exception.
	 */
	@Test
	public void testTryToRemoveFromEmptyList() {
		LinkedList list = new LinkedList();
		boolean success = false;
		try{
			list.remove(0);
		} catch(IndexOutOfBoundsException e) {
			success = true;
		}
		assertEquals(true, success);
	}
	
	/**
	 * Test which shows successful removal of the only element in the list. After removal the list
	 * is empty, so trying to get any element will result in an exception.
	 */
	@Test
	public void testRemoveOnlyElementAndTryToGet() {
		LinkedList list = new LinkedList();
		list.add(5);
		list.remove(0);
		boolean success = false;
		try {
			int result = list.get(0);
		} catch(IndexOutOfBoundsException e) {
			success = true;
		}
		assertEquals(true, success);
	}
	
	/**
	 * Test which shows successful removal of the first element in a list containing various elements.
	 * All the following elements are shifted one step back.
	 */
	@Test
	public void testRemoveFirstOfMultipleElements() {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		list.add(7);
		list.remove(0);
		int result = list.get(0);
		assertEquals(2, result);
	}
	
	/**
	 * Test which shows successful removal of an element from the middle of the list. All elements
	 * after it are shifted one step back.
	 */
	@Test
	public void testRemoveElementFromMiddleOfList() {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		list.add(7);
		list.remove(1);
		int result = list.get(1);
		assertEquals(7, result);
	}
	
	/**
	 * Test which shows successful removal of the last element in a list containing various elements.
	 * Trying to get it after removal results in an IndexOutOfBounds exception.
	 */
	@Test
	public void testRemoveLastOfMultipleElements() {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		list.add(7);
		list.remove(2);
		boolean success = false;
		try{
			int result = list.get(2);
		} catch(IndexOutOfBoundsException e) {
			success = true;
		}
		assertEquals(true, success);
	}
	
	/**
	 * Test which shows how a reversed list created from an empty list will also be empty.
	 */
	@Test
	public void reverseEmptyListAndTryToGet() {
		LinkedList list = new LinkedList();
		LinkedList reversedList = list.createReversedList();
		boolean success = false;
		try {
			int result = reversedList.get(0);
		} catch(IndexOutOfBoundsException e) {
			success = true;
		}
		assertEquals(true, success);
	}
	
	/**
	 * Test which shows successful reversal of a single element list.
	 */
	@Test
	public void reverseSingleElementList() {
		LinkedList list = new LinkedList();
		list.add(5);
		LinkedList reversedList = list.createReversedList();
		int result = reversedList.get(0);
		assertEquals(5, result);
	}
	
	/**
	 * Test which shows successful reversal of a multiple element list.
	 */
	@Test
	public void reverseMultipleElementList() {
		LinkedList list = new LinkedList();
		list.add(5);
		list.add(2);
		list.add(7);
		LinkedList reversedList = list.createReversedList();
		int result = reversedList.get(2);
		assertEquals(5, result);
	}
}
