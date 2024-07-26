package co.edu.uptc.management.persistence;

import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.management.dto.CallDTO;


public class ManagementCallPersistence {
	
private List<CallDTO> listCalls;
	
	
	public ManagementCallPersistence() {
		this.listCalls = new ArrayList<>();
	}

	public void addCeramic(CallDTO call) {
		// TODO Auto-generated method stub
		this.listCalls.add(call);
	}

	public List<CallDTO> getListCalls() {
		return listCalls;
	}

	public void setListCalls(List<CallDTO> listCalls) {
		this.listCalls = listCalls;
	}
	
	

}
