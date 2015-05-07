package ule.edi.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ule.edi.EmptyCollectionException;

public class AbstractSingleLinkedList<T> extends AbstractList<T> {
	
	// Estructura de datos, lista simplemente enlazada
	//
	// Este es el primer nodo de la lista
	protected Node<T> first = null;

	// Clase para cada nodo en la lista
	protected static class Node<G> {

		Node(G element) {
			this.element = element;
			this.next = null;
		}

		@Override
		public String toString() {
			return "(" + element + ")";
		}

		G element;

		Node<G> next;
	}

	@Override
	public T remove(T element) throws EmptyCollectionException {
     //Elimina la primera aparición del elemento
     
		if (first != null) {

			// Busca el nodo a eliminar
			Node<T> candidate = findFirstWithElement(element);

			if (candidate != null) {

				// Quita el nodo de la lista
				detachNode(candidate);

				return candidate.element;
			} else {

				throw new NoSuchElementException(
						"The element is not in the list, cannot remove it");
			}
		} else {
			throw new EmptyCollectionException(
					"Cannot remove an element from an empty list");
		}
	}

	@Override
	public T removeFirst() throws EmptyCollectionException {

		if (first != null) {

			// Se salta el primer nodo
			T result = first.element;

			first = first.next;

			return result;

		} else {
			throw new EmptyCollectionException(
					"Cannot remove first element of an empty list");
		}
	}

	@Override
	public T removeLast() throws EmptyCollectionException {

		if (first != null) {

			// Elimina el último nodo
			T result = last().element;

			detachNode(last());

			return result;

		} else {
			throw new EmptyCollectionException(
					"Cannot remove last element of an empty list");
		}
	}

	

	@Override
	public T getFirst() throws EmptyCollectionException {
		if (first != null) {
			return first.element;
		} else {
			throw new EmptyCollectionException(
					"Cannot provide the first element of an empty list");
		}
	}

	@Override
	public T getLast() throws EmptyCollectionException {
		if (first != null) {
			return last().element;
		} else {
			throw new EmptyCollectionException(
					"Cannot provide the last element of an empty list");
		}
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	
	// Encuentra el primer nodo con un elemento igual
	protected Node<T> findFirstWithElement(T element) {

		// Avanza hasta el nodo que queremos
		Node<T> result = first;
		while ((result != null) && (!result.element.equals(element))) {
			result = result.next;
		}

		// Si no se encontró será null
		return result;
	}

	// Se salta un nodo en la lista
	protected void detachNode(Node<T> x) {
		if (first != x) {
			previous(x).next = x.next;
		} else {
			first = first.next;
		}
	}

	// Encuentra el nodo que está antes del indicado
	protected Node<T> previous(Node<T> to) {

		// Avanza hasta el nodo que queremos
		Node<T> result = first;
		while ((result != null) && (result.next != to)) {
			result = result.next;
		}

		// Si no lo encuentra será null
		return result;
	}


	protected void insertBefore(Node<T> mark, Node<T> toInsert) {
		
		//	Quedará previous(mark)=>toInsert=>mark
		
		if (mark != first) {
			
			toInsert.next = mark;
			
			previous(mark).next = toInsert;
			
		} else {
		
			//	Quiere ir como primero de la lista
			toInsert.next = first;
			
			first = toInsert;
		}
	}
	
	////////////////////////// TODO RECURSIVE
	// Devuelve el último nodo de la lista, o <code>null</code>.
	protected Node<T> last() {
     // todo
		return null;
	}

	@Override
	public int size() {
     //todo
		return 0;
	}

	@Override
	public void removeDuplicates() {
      // implementación de eliminar duplicados para listas no ordenadas (funcionaría tambien si la lista está ordenada) Complejidad O(n2)
		}
	
	
	
	/////////////////////////
	@Override
	public Iterator<T> iterator() {

		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<T> {

		// Será el siguiente devuelto por 'next'
		Node<T> willBeNext = first;

		@Override
		public boolean hasNext() {

			return (willBeNext != null);
		}

		@Override
		public T next() {

			T result = willBeNext.element;

			willBeNext = willBeNext.next;

			return result;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	

}
