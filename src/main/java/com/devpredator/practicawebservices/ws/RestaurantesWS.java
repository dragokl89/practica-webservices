/**
 * 
 */
package com.devpredator.practicawebservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.devpredator.practicawebservices.entity.Restaurante;
import com.devpredator.practicawebservices.service.RestauranteService;

/**
 * @author 4PF28LA_2004
 *
 */

@Path("restaurantesWS")
public class RestaurantesWS {

	private RestauranteService restauranteService = new RestauranteService();

	

	@GET
	@Path("test")
	public String test() {
		return "Probando funcionamiento";
	}
	
	@GET
	@Path("consultarRestaurantes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Restaurante> consultarRestaurantes() {
		return this.restauranteService.consultarRestaurantes();
	}

	@POST
	@Path("guardarRestaurante")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarRestaurante(Restaurante restaurante) {
		if (restaurante == null) {
			return Response.status(400).entity("no se ingreso informacion del restaurante ,porfavor capturar los datos")
					.build();
		}

		if (restaurante.getIdRestaurante() == null || restaurante.getIdRestaurante() == 0) {
			return Response.status(400).entity("El id es requerido").build();
		}

		if (restaurante.getNombre() == null || restaurante.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre es requerido").build();
		}

		GenericEntity<Restaurante> restauranteGeneric = new GenericEntity<Restaurante>(restaurante, Restaurante.class);
		return Response.ok(restauranteGeneric).build();

	}

}
