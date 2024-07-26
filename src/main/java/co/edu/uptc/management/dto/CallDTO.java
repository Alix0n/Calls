package co.edu.uptc.management.dto;

public class CallDTO {
	
	private String numPropio;
	private String numLlamar;
	private String tipo;
	private double valor;
	private int duracion;
	
	public CallDTO() {
		
	}
	
	public CallDTO(String numPropio, String numLlamar, String tipo, double valor, int duracion) {
		this.numPropio = numPropio;
		this.numLlamar = numLlamar;
		this.tipo = tipo;
		this.valor = valor;
		this.duracion = duracion;
	}
	
	public String getNumPropio() {
		return numPropio;
	}
	public void setNumPropio(String numPropio) {
		this.numPropio = numPropio;
	}
	public String getNumLlamar() {
		return numLlamar;
	}
	public void setNumLlamar(String numLlamar) {
		this.numLlamar = numLlamar;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	} 
	
	
	

}
