package actividad3_1;

public class Entrada {
	private int fila;
	private int minuto;
	private int cedula;
	
	public Entrada(int fila, int minuto, int cedula) {
		super();
		this.fila = fila;
		this.minuto = minuto;
		this.cedula = cedula;
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
		return "Pase: "+fila+ " E " + minuto + "-" + cedula;
	}
	
	
	

}
