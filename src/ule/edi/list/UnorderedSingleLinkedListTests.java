package ule.edi.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ule.edi.EmptyCollectionException;


public class UnorderedSingleLinkedListTests {

	protected UnorderedSingleLinkedList<String> sABAB;
	
	protected UnorderedSingleLinkedList<String> sAABB;
	
	protected UnorderedSingleLinkedList<String> sABABZ;
	
	@Before
	public void setupUnorderedListFixture() {
		
		sABAB = new UnorderedSingleLinkedList<String>("A", "B", "A", "B");
		sAABB = new UnorderedSingleLinkedList<String>("A", "A", "B", "B");
		
		sABABZ = new UnorderedSingleLinkedList<String>("A", "B", "A", "B", "Z");
	}
	
	
	@Test
	public void testAddingFirst() throws EmptyCollectionException {
		
		sABAB.addFirst("Z");
		
		Assert.assertEquals("Z", sABAB.getFirst());
		Assert.assertEquals(5, sABAB.size());
		
		Assert.assertEquals("[Z, A, B, A, B]", sABAB.toString());
	}
	
}
