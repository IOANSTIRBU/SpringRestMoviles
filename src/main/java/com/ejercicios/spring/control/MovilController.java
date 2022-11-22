package com.ejercicios.spring.control;

import java.net.URI;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.ejercicios.spring.model.Movil;
import com.ejercicios.spring.service.MovilService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author Ioan Stirbu
 *
 */

/**
 * 
 * Clase que se encarga de controlar las respuestas REST
 * con sus respectivos metodos
 *
 */


@RestController
@RequestMapping("/moviles")
@Tag(name = "movil", description = "Movil API")
public class MovilController {

	@Autowired
	private MovilService service;

	
	/**
	 * 
	 * @return Se encarga de buscar en la coleccion creada 
	 * en la BBDD y si la encuentra la coleccion entonces devolvera el servicio con
	 * su coleccion
	 */
	
	
	@GetMapping
	public Collection<Movil> buscarMoviles() {
		return service.findAll();
	}

	
	/**
	 * 
	 * @return Se encarga de bucar si existe en el listado
	 * los moviles, sino lo encuentra devolvera un noContent() Respuesta(204)
	 * Si lo encuentra entonces devolvera una Respuesta 200 OK
	 */
	
	@GetMapping("/listado2")
	public ResponseEntity<Collection<Movil>> buscarMovilesv2() {
		Collection<Movil> moviles = service.findAll();
		if (moviles.isEmpty()) {

			return ResponseEntity.noContent().build();// Esto me devolvera un 204
		}

		return ResponseEntity.ok(moviles);

	}

	// Estos elementos iran para OpenAPI

	@Operation(summary = "Buscar movil por un id", description = "Dado un id, devolvera un objeto Movil", tags = 
			{"movil" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Movil localizado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Movil.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Movil no encontrado (NO implementado)", content = @Content) })

	
	/**
	 * 
	 * @param id
	 * @return Se encarga de buscar un movil por el id, en caso que no lo encuentre
	 * saldra una excepcion que no se ha encontrado dicho movil o no se ha encontrado
	 * dicho movil por el id
	 */
	
	@GetMapping("/{id}")
	public Movil buscarMovilId(
			@Parameter(description = "Id del movil a encontrar", required = true) @PathVariable Long id) {
		System.out.println("-------- buscarMovilId ");
		return service.findById(id).orElseThrow(MovilNoEncontradoException::new);
	}

	
	
	/**
	 * 
	 * @param movil
	 * @return Se encarga de crear un movil en la BBDD
	 */
	
	
	@PostMapping
	public ResponseEntity<?> crearMovil(@RequestBody Movil movil) {
		Movil resultado = this.service.save(movil);
		
		System.out.println("---------- Valor del ID: " + resultado.getId());
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(resultado.getId()).toUri();
		System.out.println("-------- URI Location: " + location);

		return ResponseEntity.created(location).build();
	}
	
	/**
	 * 
	 * @param movil
	 * @return Se encarga de actualizar un movil en la BBDD
	 * en caso de que no lo encuentre entonces nos devolvera una excepcion
	 * de que no existe dicho movil
	 */
	
	
	@PutMapping
	public Movil actualizarMovil(@RequestBody Movil movil) {
		return this.service.update(movil).orElseThrow(MovilNoEncontradoException::new);
	}
	
	/**
	 * 
	 * @param id
	 * No devuelve nada y se encarga de borrar un movil por id
	 */
	
	
	@DeleteMapping("/{id}")
	public void borrarMovil(@PathVariable Long id) {
		service.deleteById(id);
	}
	
	
}
