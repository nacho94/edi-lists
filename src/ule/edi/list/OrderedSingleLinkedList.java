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
		while(r != null) {
			if(r.element.equals(r.next.element)) {
				if(r.next == null) {
					r.next = null;
					return;
				}else{
					r.next = r.next.next;
				}
				
			}
			r  = r.next;
		}
	}
	
	public static void main(String []args) {  	
        OrderedSingleLinkedList<String> t = new OrderedSingleLinkedList<>();

        t.add("A1");
        t.add("A2");
        t.add("B");
        t.add("B");
        t.add("C1");
        t.add("E");
        t.add("E");
        t.add("E");
        t.add("E");
        
        System.out.println(t.toString());
        System.out.println(t.last().element);
        System.out.println(t.size());
        t.removeDuplicates();  	
        System.out.println(t.toString());
	}
}
