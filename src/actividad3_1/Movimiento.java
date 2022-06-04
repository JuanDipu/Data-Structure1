package actividad3_1;
/**
 * La clase de los movimientos del museo
 * @author User
 *
 */
public class Movimiento implements Comparable<Movimiento> {
	private String mo;
	private int fila;
	private int minuto;
	private int cedula;
	public Movimiento(String mo, int fila, int minuto, int cedula) {
		super();
		this.mo = mo;
		this.fila = fila;
		this.minuto = minuto;
		this.cedula = cedula;
	}
	public String getMo() {
		return mo;
	}
	public void setMo(String mo) {
		this.mo = mo;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getMinuto() {
		return minuto;
	}
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	@Override
	public String toString() {
		return "Pase: "+fila+" "+ mo+ " " + minuto + "-" + cedula;
	}
	/**
	 * Es el método que ordena el arraylist para hacer la busqueda
	 */
	@Override
	public int compareTo(Movimiento o) {
		// TODO Auto-generated method stub
		int comparminuto=((Movimiento)o).getMinuto();
		return this.minuto-comparminuto;
	}
	
	
}
