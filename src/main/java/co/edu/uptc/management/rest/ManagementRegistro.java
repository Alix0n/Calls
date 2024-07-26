package co.edu.uptc.management.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.uptc.management.dto.CallDTO;
import co.edu.uptc.management.dto.RegistroDTO;
import co.edu.uptc.management.persistence.ManagementRegistroPersistence;
import co.edu.uptc.management.rest.*;

@Path("/ManagementRegistro")
public class ManagementRegistro {
	
	public static ManagementRegistroPersistence managementRegistros = new ManagementRegistroPersistence();;
	
	@POST
    @Path("/addCall")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Boolean addCall1(CallDTO callDTO) {
        RegistroDTO registroDTO = new RegistroDTO(
            callDTO.getNumPropio(), 
            callDTO.getNumLlamar(), 
            callDTO.getTipo(), 
            callDTO.getValor(), 
            callDTO.getDuracion(),
            "ID" + (managementRegistros.getListRegistros().size() + 1)
        );
        return managementRegistros.getListRegistros().add(registroDTO);
    }

    @GET
    @Path("/getCallByCode")
    @Produces({ MediaType.APPLICATION_JSON })
    public RegistroDTO getCallByCode1(@QueryParam("id") String id) {
        for (RegistroDTO registroDTO : managementRegistros.getListRegistros()) {
            if (registroDTO.getId().equals(id)) {
                return registroDTO;
            }
        }
        return null;
    }

    @GET
    @Path("/getTotalCashByType")
    @Produces({ MediaType.APPLICATION_JSON })
    public double getTotalCashByType1(@QueryParam("type") String type) {
        double totalCash = 0.0;
        for (RegistroDTO callDTO : managementRegistros.getListRegistros()) {
            if (type == null || callDTO.getTipo().equals(type)) {
                totalCash += callDTO.getTotalLlamada();
            }
        }
        return totalCash;
    }

    @GET
    @Path("/getTotalMinutesByType")
    @Produces({ MediaType.APPLICATION_JSON })
    public double getTotalMinutesByType1(@QueryParam("type") String type) {
        double totalMinutes = 0.0;
        for (CallDTO callDTO : managementRegistros.getListRegistros()) {
            if (type == null || callDTO.getTipo().equals(type)) {
                totalMinutes += callDTO.getDuracion();
            }
        }
        return totalMinutes;
    }

    @POST
    @Path("/getCallsByFilter")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public List<RegistroDTO> getCallsByFilter(RegistroDTO callDTO) {
        return managementRegistros.getListRegistros().stream()
            .filter(c -> (callDTO.getNumPropio() == null || c.getNumPropio().equals(callDTO.getNumPropio())) &&
                         (callDTO.getNumLlamar() == null || c.getNumLlamar().equals(callDTO.getNumLlamar())) &&
                         (callDTO.getTipo() == null || c.getTipo().equals(callDTO.getTipo())) &&
                         (callDTO.getValor() == 0.0 || c.getValor() == callDTO.getValor()) &&
                         (callDTO.getDuracion() == 0 || c.getDuracion() == callDTO.getDuracion()))
            .collect(Collectors.toList());
    }

    @POST
  	@Path("/createCalls")
  	@Produces({ MediaType.APPLICATION_JSON })
  	@Consumes({ MediaType.APPLICATION_JSON })
  	public RegistroDTO createCall(RegistroDTO callDTO) {
	  String numero = callDTO.getNumPropio();
	  String numeroLlamar = callDTO.getNumLlamar();
	  String tipo = callDTO.getTipo();
	  double valor = callDTO.getValor();
	  int duracion = callDTO.getDuracion();
	  String id = callDTO.getId();
	  
	//  ManagementRegistro managementRegistros1 = new ManagementRegistro(numero, numeroLlamar, tipo, valor, duracion, id);
	  
	  
	  
  		if(managementRegistros.getListRegistros().add(callDTO)) {
  			
  			return callDTO;
  		}
  		return null;
  	}
  
  @POST
	@Path("/createCallsBoolean")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Boolean createCallBoolean(RegistroDTO callDTO) {
		if(managementRegistros.getListRegistros().add(callDTO)) {
			return true;
		}
		return false;
	}
  

@GET
@Path("/getRegistros")
@Produces({ MediaType.APPLICATION_JSON })
public RegistroDTO getCallByCode(@QueryParam("id") String id) {
	System.out.println(id);
    for (RegistroDTO registroDTO : managementRegistros.getListRegistros()) {
        if (registroDTO.getId().equals(id)) {
            return registroDTO;
        }
    }
    return null;
}



@GET
@Path("/getTotalCashByType")
@Produces({ MediaType.APPLICATION_JSON })
public double getTotalCashByType(@QueryParam("type") String type) {
    double totalCash = 0.0;
    for (RegistroDTO callDTO : managementRegistros.getListRegistros()) {
        if (type == null || callDTO.getTipo().equals(type)) {
           // totalCash += callDTO.getValor() * callDTO.getDuracion();
        	totalCash += callDTO.getTotalLlamada();
        }
    }
    return totalCash;
}

@GET
@Path("/getTotalMinutesByType")
@Produces({ MediaType.APPLICATION_JSON })
public double getTotalMinutesByType(@QueryParam("type") String type) {
    double totalMinutes = 0.0;
    for (CallDTO callDTO : managementRegistros.getListRegistros()) {
        if (type == null || callDTO.getTipo().equals(type)) {
            totalMinutes += callDTO.getDuracion();
        }
    }
    return totalMinutes;
}

	  
}
