package com.ejercicios.spring.control;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class MovilNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public MovilNoEncontradoException() {
		super("Fallo Catastrofico: Su movil no existe en nuestra BBDD" );
	}
	
	public MovilNoEncontradoException(Long id) {
		super("Fallo Catastrofico: Su movil no existe en nuestra BBDD con el id " + id );
	}

}
