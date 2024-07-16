package universidades.universidades.services;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import universidades.universidades.business.GestionUniversidades;
import universidades.universidades.model.Universidad;
import universidades.universidades.services.ErrorMessage;

@Path("universidades")
public class UniversidadesServices {
	
	@Inject
	private GestionUniversidades gUniversidads; //GestionUniversidadsLocal
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Universidad universidad) {
		try {
			gUniversidads.guardarUniversidads(universidad); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return Response.ok(universidad).build();
			//return "OK";
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getUniversidads(){
		List<Universidad> universidads = gUniversidads.getUniversidads();
		if(universidads.size()>0)
			return Response.ok(universidads).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran universidads");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Universidad universidad) {
		try {
			gUniversidads.actualizarUniversidad(universidad); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return Response.ok(universidad).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response borrar(@QueryParam("id") int codigo) {
		try {
			gUniversidads.borrarUniversidad(codigo); //Estos son los metodos o servicios
			ErrorMessage error = new ErrorMessage(0, "OK");
			return Response.status(Response.Status.CREATED).entity(error).build();
			//return "OK";
		}catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}

}
