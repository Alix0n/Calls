package co.edu.uptc.management.dto;

public class RegistroDTO extends CallDTO {
	
	private String id;
    private Double totalLlamada;
    
    public RegistroDTO() {
    	
    }
    
    
	public RegistroDTO(String numPropio, String numLlamar, String tipo, Double valor, int duracion,String id) {
		super(numPropio, numLlamar, tipo, valor, duracion);
		this.id = id;
		this.totalLlamada = this.calcularRecargo();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Double getTotalLlamada() {
		return totalLlamada;
	}
	public void setTotalLlamada(Double totalLlamada) {
		this.totalLlamada = totalLlamada;
	}
	
	public double calcularValor() {
        return super.getDuracion() * super.getValor(); // * (1 + recargo);
    }
    
    public double calcularRecargo() {
    	double recargo = 0;
        switch (super.getTipo().toLowerCase()) {
            case "mismo":
                recargo = 0;
                break;
            case "operador":
                recargo = 0.05;
                break;
            case "nacional":
                recargo = 0.10;
                break;
            case "internacional":
                recargo = 0.15;
                break;
        }
        return (calcularValor() * (1 + recargo));
    }
    
    


	@Override
	public String toString() {
		return "RegistroDTO [id=" + id + ", totalLlamada=" + totalLlamada +  "Origem" + super.getNumPropio() + "Destino" + super.getNumLlamar();
	}
    
    
    

}
