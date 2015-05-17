package ule.edi.list;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

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
}
