/**
 * 
 */
package com.devpredator.practicawebservices.service;

import java.util.ArrayList;
import java.util.List;

import com.devpredator.practicawebservices.entity.Restaurante;

/**
 * @author 4PF28LA_2004
 *
 */
public class RestauranteService {
 public List<Restaurante> consultarRestaurantes(){
	 List<Restaurante> restaurantes = new ArrayList();
	 
	 Restaurante res = new Restaurante();
	 res.setNombre("KFC");
	 res.setIdRestaurante(123L);
	 res.setSlogan("Hasta chuparse los dedos");
	 res.setDireccion("Amazonas");
	 
	 Restaurante rest = new Restaurante();
	 rest.setNombre("McDonald");
	 rest.setIdRestaurante(456L);
	 rest.setSlogan("No se la verdad");
	 rest.setDireccion("Colon");
	 
	 restaurantes.add(rest);
	 restaurantes.add(res);
	 
	 return restaurantes;
 }
}
