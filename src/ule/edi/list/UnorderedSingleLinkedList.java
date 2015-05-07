package ule.edi.list;

import java.util.NoSuchElementException;

public class UnorderedSingleLinkedList<T> extends AbstractSingleLinkedList<T>
		implements UnorderedListADT<T> {

	public UnorderedSingleLinkedList() {
		// Vacía
	}

	public UnorderedSingleLinkedList(T... v) {
		// Añadir en el mismo orden que en 'v'
		for (T Vi : v) {
			addLast(Vi);
		}
	}

	@Override
	public void addFirst(T element) {
		if(first == null) {
			first = new Node<T>(element);
			return;
		}
		
		Node<T> n = new Node<T>(element);
		n.next = first;
		first = n;
		
	}

	@Override
	public void addLast(T element) {
		if(first == null) {
			first = new Node<T>(element);
			return;
		}

		addLast(element, first);
	}
	
	private void addLast(T element, Node<T> node) {
		if(node.next == null) {
			node.next = new Node<T>(element);
		} else {
			addLast(element, node.next);
		}
	}

	// TODO ejercicio
	@Override
	public T replaceAt(int n, T element) {
		if(n <= 0) {
			throw new NoSuchElementException("indice invalido");
		}
		return replaceAt(n, element, first);
	}
	
	private T replaceAt(int n, T element, Node<T> node) {
		if(node == null) {
			throw new NoSuchElementException("no se puede remplazar el elemento");
		}
		if(n <= 1) {
			T aux = node.element;
			node.element = element;
			return aux;
		} else {
			return replaceAt(n - 1, element, node.next);
		}
	}
	@Override 
	public void insertBefore(int n, T element) throws NoSuchElementException {
		// TODO 
		
	}



}
