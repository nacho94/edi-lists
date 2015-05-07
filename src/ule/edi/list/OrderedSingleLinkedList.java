package ule.edi.list;

public class OrderedSingleLinkedList<T extends Comparable<? super T>> extends AbstractSingleLinkedList<T> implements OrderedListADT<T> {

	public OrderedSingleLinkedList() {
		//	Vacía
	}
	
	public OrderedSingleLinkedList(T ... v) {
		//	Añade todos los elementos del array 'v'
		for (T Vi : v) {
			add(Vi);
		}
	}
	
	@Override
	public void add(T element) {
		
		
	}

	@Override
	public void removeDuplicates() {
		// Implementar la operación eliminar duplicados consiguiendo una complejidad O(n)
		
		
	}
	
}
