package actividad3_1;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author User
 *Clase de TDA cola
 * @param <T>
 */
public class TDACola<T> {
	private Queue<T> cola;

	public TDACola() {
		cola= new LinkedList<>();
	}
	
	/**
	 * Función permite encolar un elemento
	 */
	
	public void enQueue(T dato) {
		cola.add(dato);
	}
	
	/**
	 * Función que permite desencolar
	 */
	public T deQueue() {
		return cola.remove();
	}
	
	public T peek() {
		return cola.peek();
	}
	
	public int elemento() {
		return cola.size();
	}
	
	public boolean vacia() {
		return cola.isEmpty();
	}
}
