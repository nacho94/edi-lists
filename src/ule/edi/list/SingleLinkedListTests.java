package ule.edi.list;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ule.edi.EmptyCollectionException;

public class SingleLinkedListTests {

	protected ListADT<String> sLEmpty;
	
	protected ListADT<String> sL1;
	
	protected ListADT<String> sL12;
	
	protected ListADT<String> sL123;
	
	protected UnorderedSingleLinkedList<String> sABAB;
	
	protected UnorderedSingleLinkedList<String> sAABB;
	
	protected UnorderedSingleLinkedList<String> sABABZ;
	
	@Before
	public void setupListADTFixture() {
		
		sLEmpty = new UnorderedSingleLinkedList<String>();
		
		sL1 = new UnorderedSingleLinkedList<String>("1");
		sL12 = new UnorderedSingleLinkedList<String>("1", "2");
		sL123 = new UnorderedSingleLinkedList<String>("1", "2", "3");
	}

	@Before
	public void setupUnorderedListFixture() {
		
		sABAB = new UnorderedSingleLinkedList<String>("A", "B", "A", "B");
		sAABB = new UnorderedSingleLinkedList<String>("A", "A", "B", "B");
		
		sABABZ = new UnorderedSingleLinkedList<String>("A", "B", "A", "B", "Z");
	}
	
	@Test
	public void testToStringEmpty() {	
		Assert.assertEquals("[]", sLEmpty.toString());
	}		
	
	@Test
	public void testToString() {
		Assert.assertEquals("[1]", sL1.toString());
		Assert.assertEquals("[1, 2]", sL12.toString());
		Assert.assertEquals("[1, 2, 3]", sL123.toString());
	}
	
	@Test
	public void testConstructsEmpty() {
		Assert.assertTrue(new UnorderedSingleLinkedList<>().isEmpty());
	}

	@Test
	public void testRemovingFirst() throws EmptyCollectionException {
		Assert.assertEquals("A", sABAB.removeFirst());
		Assert.assertEquals("[B, A, B]", sABAB.toString());
		Assert.assertEquals(3, sABAB.size());
	}

	@Test
	public void testRemovingLast() throws EmptyCollectionException {
		Assert.assertEquals("B", sABAB.removeLast());
		Assert.assertEquals("[A, B, A]", sABAB.toString());
		Assert.assertEquals(3, sABAB.size());
	}

	@Test
	public void testRemovingFirstElement() throws EmptyCollectionException {
		Assert.assertEquals("A", sABAB.remove("A"));
		Assert.assertEquals("[B, A, B]", sABAB.toString());
		Assert.assertEquals(3, sABAB.size());
	}

	@Test
	public void testRemovingSecondElement() throws EmptyCollectionException {
		Assert.assertEquals("B", sABAB.remove("B"));
		Assert.assertEquals("[A, A, B]", sABAB.toString());
		Assert.assertEquals(3, sABAB.size());
	}

	@Test
	public void testRemovingLastElement() throws EmptyCollectionException {
		Assert.assertEquals("Z", sABABZ.remove("Z"));
		Assert.assertEquals("[A, B, A, B]", sABABZ.toString());
		Assert.assertEquals(4, sABABZ.size());
	}

	@Test
	public void testRemovingInterleavedDuplicates() throws EmptyCollectionException {
		sABAB.removeDuplicates();
		Assert.assertEquals("[A, B]", sABAB.toString());
		Assert.assertEquals(2, sABAB.size());
	}

	@Test
	public void testRemovingGroupedDuplicates() throws EmptyCollectionException {
		sAABB.removeDuplicates();
		Assert.assertEquals("[A, B]", sAABB.toString());
		Assert.assertEquals(2, sAABB.size());
	}
		
	@Test
	public void testGetFirst() throws EmptyCollectionException {
		Assert.assertEquals("1", sL1.getFirst());
		Assert.assertEquals("1", sL12.getFirst());
		Assert.assertEquals("1", sL123.getFirst());
	}

	@Test
	public void testGetLast() throws EmptyCollectionException {
		Assert.assertEquals("1", sL1.getFirst());
		Assert.assertEquals("2", sL12.getLast());
		Assert.assertEquals("3", sL123.getLast());
	}

	@Test
	public void testContainsAlien() throws EmptyCollectionException {
		Assert.assertFalse(sL1.contains("Z"));
		Assert.assertFalse(sL12.contains("Z"));
		Assert.assertFalse(sL123.contains("Z"));		
	}

	@Test
	public void testContainsSingleton() throws EmptyCollectionException {
		Assert.assertTrue(sL1.contains("1"));
	}
	
	@Test
	public void testContainsFirst() throws EmptyCollectionException {
		Assert.assertTrue(sL12.contains("1"));
		Assert.assertTrue(sL123.contains("1"));		
	}

	@Test
	public void testContainsInner() throws EmptyCollectionException {
		Assert.assertTrue(sL123.contains("2"));		
	}

	@Test
	public void testContainsLast() throws EmptyCollectionException {
		Assert.assertTrue(sL12.contains("2"));
		Assert.assertTrue(sL123.contains("3"));		
	}

	@Test(expected=ule.edi.EmptyCollectionException.class)
	public void testExceptionOnRemoveFirstOnEmpty() throws EmptyCollectionException {
		sLEmpty.removeFirst();
	}

	@Test(expected=ule.edi.EmptyCollectionException.class)
	public void testExceptionOnRemoveLastOnEmpty() throws EmptyCollectionException {
		sLEmpty.removeLast();
	}
	
	@Test(expected=ule.edi.EmptyCollectionException.class)
	public void testExceptionOnRemoveOnEmpty() throws EmptyCollectionException {
		sLEmpty.remove("A");
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testExceptionOnRemoveNotThere() throws EmptyCollectionException {
		sL123.remove("Z");
	}

	@Test(expected=ule.edi.EmptyCollectionException.class)
	public void testExceptionOnGetFirstFromEmpty() throws EmptyCollectionException {
		sLEmpty.getFirst();
	}
	
	@Test(expected=ule.edi.EmptyCollectionException.class)
	public void testExceptionOnGetLastFromEmpty() throws EmptyCollectionException {
		sLEmpty.getLast();
	}
	
}
