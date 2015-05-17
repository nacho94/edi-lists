package ule.edi.list;

public class OrderedSingleLinkedList<T extends Comparable<? super T>> extends AbstractSingleLinkedList<T> implements OrderedListADT<T> {

	public OrderedSingleLinkedList() {
		//	Vacía
	}
	
	@SuppressWarnings("unchecked")
	public OrderedSingleLinkedList(T ... v) {
		//	Añade todos los elementos del array 'v'
		for (T Vi : v) {
			add(Vi);
		}
	}
	
	@Override
	public void add(T element) {
		if(isEmpty()) {
			first = new Node<T>(element);
			return;
		}
		add(element,first,null);
	}
	
	private void add(T element,Node<T> node, Node<T> prev) {
		if(node.next == null) {
			node.next = new Node<T>(element);
			return;
		}
		if(element.compareTo(node.element) > 0) {
			add(element, node.next, node);
		}else {
			if(prev == null) {
				first = new Node<T>(element);
				first.next = node;
			} else {
				prev.next = new Node<T>(element);
				prev.next.next = node;
			}
			
		}
	}

	@Override
	public void removeDuplicates() {
		// Implementar la operación eliminar duplicados consiguiendo una complejidad O(n)
		if(first == null) {
			return;
		}
		Node<T> r = first;
		while(r.next != null) {
			if(r.element.equals(r.next.element)) {
				
					r.next = r.next.next;
				
				
			}else {
				r  = r.next;
			}
			
		}
	}
}
