package ule.edi.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ule.edi.EmptyCollectionException;

public class OrderedSingleLinkedListTests {

	private OrderedSingleLinkedList<String> sA4B2;
	
	@Before
	public void setupOrderedListFixture() {
		
		sA4B2 = new OrderedSingleLinkedList<String>("A", "B", "A", "A", "B", "A");
	}
	
	@Test
	public void testConstructsEmpty() {
		Assert.assertTrue(new OrderedSingleLinkedList<>().isEmpty());
	}
	
	@Test
	public void testRemovingOrderedDuplicates() throws EmptyCollectionException {
		sA4B2.removeDuplicates();
		
		Assert.assertEquals("[A, B]", sA4B2.toString());
		Assert.assertEquals(2, sA4B2.size());
	}
	
}
