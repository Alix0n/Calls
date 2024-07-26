package co.edu.uptc.management.persistence;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.management.dto.RegistroDTO;

public class ManagementRegistroPersistence {
	
private List<RegistroDTO> listRegistros;
	
    public void addCeramic(RegistroDTO call) {
	this.listRegistros.add(call);
     }

	public ManagementRegistroPersistence() {
		this.listRegistros = new ArrayList<>();
	}


	public List<RegistroDTO> getListRegistros() {
		return listRegistros;
	}


	public void setListRegistros(List<RegistroDTO> listRegistros) {
		this.listRegistros = listRegistros;
	}
	
	
	
	
	
	
	

}
