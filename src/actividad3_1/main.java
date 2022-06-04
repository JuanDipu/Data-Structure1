package actividad3_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class main {
/**
 * Se escoge una lista para realizar la entrada de movimientos y su salida
 * 
 * @param args
 */
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		int tiempo;
		int documento;
		int pas;
		int ret;
		// TODO Auto-generated method stub

		TDACola pases = new TDACola<>();
		ArrayList<Movimiento> entrada = new ArrayList<>();
		ArrayList<Movimiento> salida = new ArrayList<>();
		

		for (int i = 1; i < 101; i++) {
			pases.enQueue(i);
		}

		do {
			System.out.println("\n1. Registrar la entrada de un usuario");
			System.out.println("2. Registrar la salida de un usuario");
			System.out.println("3. Buscar un usuario");
			System.out.println("4. Salir");
			System.out.println("Escribe una de las opciones");
			opcion = sn.nextInt();
			switch (opcion) {
			case 1:
				
				System.out.println("Has seleccionado la opcion 1");
				if((int)pases.peek()==1) {
					System.out.println("Ingrese el numero del documento del usuario.");
					documento = sn.nextInt();
					pas = (int) pases.deQueue();
					entrada.add(new Movimiento("E", pas, 0, 4669));
					System.out.println("Los usuarios ingresados son: ");
					System.out.println(entrada);
					break;
				}else {
					System.out.println("Ingrese el tiempo transcurrido en minutos.");
					tiempo = sn.nextInt();
					System.out.println("Ingrese el numero del documento del usuario.");
					documento = sn.nextInt();
					pas = (int) pases.deQueue();
					entrada.add(new Movimiento("E", pas, 245, 4669));
					System.out.println("Los usuarios ingresados son: ");
					System.out.println(entrada);

					break;
					
					
				}
			
			case 2:
				int sum = 1;
				System.out.println("Has seleccionado la opcion 2\n\n");
				System.out.println("Lista de usuarios que entraron al museo\n");
				if (!entrada.isEmpty()) {
					for (Movimiento movimiento : entrada) {

						System.out.println(String.valueOf(sum) + ". " + movimiento);
						sum++;
					}
					sum = 0;
					System.out.println("Ingrese el numero del usuario que salio:\n\n");
					ret = sn.nextInt();
					if(ret>entrada.size()) {
						System.out.println("No hay ese numero de usuarios dentro del museo\n\n");
						break;
					}else {
						salida.add(new Movimiento("S", entrada.get(ret - 1).getFila(), entrada.get(ret - 1).getMinuto(),
								entrada.get(ret - 1).getCedula()));
						pases.enQueue(entrada.get(ret-1).getFila());
						entrada.remove(ret - 1);
						System.out.println("Los usuarios que han salido son:");

						System.out.println(salida);
						

						break;
						
					}
					
				} else {
					System.out.println("No ha ingresado ningun usuario al museo.");
					break;
				}

			case 3:
				System.out.println("Has seleccionado la opcion 3");
				System.out.println("Qué tiempo quiere buscar:");
				tiempo = sn.nextInt();
				int pos = 0;
				if (!salida.isEmpty()) {
					Collections.sort(salida);
					int arr[] = new int[salida.size()];
					for (Movimiento movimiento : salida) {

						arr[pos] = movimiento.getMinuto();
						pos++;
					}
					pos = 0;
					int index = recursiveBinarySearch(arr, 0, salida.size() - 1, tiempo);

					
					
					if(index==-1) {
						System.out.println("Ningun usuario llego a esa hora" );
					}else {
						System.out.println("Se encontro el usuario");
						System.out.println(salida.get(index));
					}
				} else {
					System.out.println("No ha salido ninguna persona del museo.");
				}
				break;
			case 4:
				System.out.println("Se ha cerrado el museo por el día de hoy");
				salir = true;
				break;
			default:
				System.out.println("Solo números entre 1 y 4");
			}
		} while (!salir);

	}

	
	/**
	 * Busqueda recursiva de los minutos
	 * @param arr
	 * @param firstElement
	 * @param lastElement
	 * @param elementToSearch
	 * @return
	 */
	public static int recursiveBinarySearch(int arr[], int firstElement, int lastElement, int elementToSearch) {

		if (lastElement >= firstElement) {
			int mid = firstElement + (lastElement - firstElement) / 2;

			if (arr[mid] == elementToSearch)
				return mid;

			if (arr[mid] > elementToSearch)
				return recursiveBinarySearch(arr, firstElement, mid - 1, elementToSearch);

			return recursiveBinarySearch(arr, mid + 1, lastElement, elementToSearch);
		}

		return -1;
	}

}
