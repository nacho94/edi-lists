package ule.edi.list;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import ule.edi.list.AbstractSingleLinkedList.Node;

public class UnorderedSingleLinkedListTest {
	UnorderedSingleLinkedList<String> lista;
	@Before
	public void setUp() throws Exception {
		lista = new UnorderedSingleLinkedList<String>();
	}

	@Test
	public void testUnorderedSingleLinkedList() {
		lista = new UnorderedSingleLinkedList<String>();
	}

	@Test
	public void testUnorderedSingleLinkedListTArray() {
		lista = new UnorderedSingleLinkedList<String>("A", "B", "A", "B");
	}

	@Test
	public void testAddFirst() {
		lista.addFirst("element");
		Assert.assertEquals("[element]", lista.toString());
	}
	
	@Test
	public void testAddFirst2() {
		lista.addFirst("element");
		lista.addFirst("el");
		Assert.assertEquals("[el, element]", lista.toString());
	}
	
	@Test
	public void testAddLast() {
		lista.addLast("element");
		Assert.assertEquals("[element]", lista.toString());
	}
	
	@Test
	public void testAddLast2() {
		lista.addLast("element");
		lista.addLast("el");
		lista.addLast("r");
		Assert.assertEquals("[element, el, r]", lista.toString());
	}

	@Test
	public void testReplaceAt() {
		lista.addLast("element");
		lista.addLast("el");
		lista.addLast("r");
		
		Assert.assertEquals("el", lista.replaceAt(2, "w"));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testReplaceAtException() {
		lista.addLast("element");
		lista.replaceAt(0, "q");
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testReplaceAtException2() {
		lista.replaceAt(1, "q");
	}

	@Test
	public void testInsertBeforeIntT() {
		lista.addLast("element");
		lista.addLast("el");
		
		lista.insertBefore(1, "er");
		Assert.assertEquals("[er, element, el]",lista.toString());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testInsertBeforeIntTException() {
		lista.addLast("element");
		lista.addLast("el");
		
		lista.insertBefore(0, "er");
	}
	
	@Test
	public void testInsertBeforeIntT2() {
		lista.insertBefore(2, "er");
		Assert.assertEquals("[er]",lista.toString());
	}
	
	@Test
	public void testInsertBeforeIntT3() {
		lista.addLast("element");
		lista.addLast("el");
		
		lista.insertBefore(2, "er");
		Assert.assertEquals("[element, er, el]",lista.toString());
	}
	
	@Test
	public void testInsertBeforeIntT4() {
		lista.addLast("element");
		lista.addLast("el");
		lista.addLast("w");
		lista.addLast("cv");
		lista.insertBefore(3, "er");
		Assert.assertEquals("[element, el, er, w, cv]",lista.toString());
	}
	
	@Test
	public void testInsertBeforeIntT5() {
		lista.addLast("element");
		
		lista.insertBefore(2, "er");
		Assert.assertEquals("[element, er]",lista.toString());
	}
	
	@Test
	public void testInsertBeforeIntT6() {
		lista.addLast("element");
		
		lista.insertBefore(lista.first ,new Node<String>("element"));
		Assert.assertEquals("[element, element]",lista.toString());
	}
	
	@Test
	public void testInsertBeforeIntT7() {
		lista.addLast("element");
		
		lista.insertBefore(lista.first.next ,new Node<String>("element"));
		Assert.assertEquals("[element, element]",lista.toString());
	}
	
	@Test
	public void testRemoveDuplicates() {
		lista.addLast("element");
		lista.addLast("a");
		lista.addLast("w");
		lista.addLast("element");
		lista.removeDuplicates();
		Assert.assertEquals("[element, a, w]",lista.toString());
	}
	
	@Test
	public void testRemoveDuplicates2() {
		lista.addLast("element");
		lista.removeDuplicates();
		Assert.assertEquals("[element]",lista.toString());
	}
	
	@Test
	public void testRemoveDuplicates3() {
		lista.removeDuplicates();
		Assert.assertEquals("[]",lista.toString());
	}
	
	@Test
	public void testRemoveDuplicates4() {
		lista.addLast("element");
		lista.addLast("element");
		lista.addLast("a");
		lista.addLast("w");
		lista.removeDuplicates();
		Assert.assertEquals("[element, a, w]",lista.toString());
	}
	
	@Test
	public void testLast() {
		lista.last();
	}
	
	@Test
	public void testLast2() {
		lista.addLast("element");
		lista.last();
	}

	@Test
	public void testToStringNode() {
		lista.addLast("element");
		Assert.assertEquals("(element)",lista.first.toString());
	}
	
	@Test
	public void testSize() {
		lista.addLast("element");
		Assert.assertEquals(1,lista.size());
	}
	
	@Test
	public void testSize2() {
		Assert.assertEquals(0,lista.size());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testRemoveIterator() {
		Iterator<String> t = lista.iterator();
		t.remove();
	}
	
}
