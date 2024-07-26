package co.edu.uptc.management.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.uptc.management.dto.CallDTO;
import co.edu.uptc.management.persistence.ManagementCallPersistence;


@Path("/Management")
public class Management {
	
      public static ManagementCallPersistence managementCalls = new ManagementCallPersistence();
      
      @POST
  	@Path("/createCalls")
  	@Produces({ MediaType.APPLICATION_JSON })
  	@Consumes({ MediaType.APPLICATION_JSON })
  	public CallDTO createCall(CallDTO callDTO) {
  		if(managementCalls.getListCalls().add(callDTO)) {
  			return callDTO;
  		}
  		return null;
  	}
      
      @POST
    	@Path("/createCallsBoolean")
    	@Produces({ MediaType.APPLICATION_JSON })
    	@Consumes({ MediaType.APPLICATION_JSON })
    	public Boolean createCallBoolean(CallDTO callDTO) {
    		if(managementCalls.getListCalls().add(callDTO)) {
    			return true;
    		}
    		return false;
    	}
      
      
      
      
    
      
      
      
      
      

	
	
	
	

}
