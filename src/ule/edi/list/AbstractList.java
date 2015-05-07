package ule.edi.list;



/**
 * Operaciones que no dependen del tipo específico de lista.
 * 
 * @author profesor
 *
 * @param <T> tipo de elementos en la lista.
 */
public abstract class AbstractList<T> implements ListADT<T> {

	@Override
	public String toString() {
		
		//	Construye y devuelve con el formato adecuado
		StringBuffer rx = new StringBuffer();
		
		rx.append("[");
		
		for (T i : this) {
			rx.append(i);
			rx.append(", ");
		}
		//	Elimina ", " de más
		if (! isEmpty()) {
			rx.delete(rx.length() - 2, rx.length());
		}
		
		rx.append("]");
		
		return rx.toString();
	}

	@Override
	public boolean contains(T target) {
		
		for (T x : this) {
			if (x.equals(target)) { return true; }
		}
		
		return false;
	}
	
}
