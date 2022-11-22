package com.ejercicios.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejercicios.spring.datos.MovilRepository;
import com.ejercicios.spring.model.Movil;

@Service
public class MovilServiceImpl implements MovilService {

	@Autowired
	private MovilRepository movil_repository;
	
	/**
	 * @return Se encarga de buscar todos los moviles en la  BBDD y si encuentra
	 * dicha lista entonces la devuelve y lo guarda en el repositorio
	 *
	 */
	
	@Override
	public List<Movil> findAll() {
		return movil_repository.findAll();
	}

	
	/**
	 *@return  Se encarga de buscar un movil por id en la BBDD y si lo encuentra
	 * entonces me devuelve el id de dicho movile en el repositorio
	 */
	
	@Override
	public Optional<Movil> findById(long id) {
		return movil_repository.findById(id);
	}

	
	/**
	 * @return Se encarga de devolver un movil guardado en la BBDD y lo guarda
	 * en el repositorio
	 */
	
	@Override
	public Movil save(Movil mob) {
		return movil_repository.save(mob);
	}
	/**
	 * @return Se encarga de devolver un movil guardado en la BBDD y lo actualiza en la BBDD
	 */
	@Override
	public Optional<Movil> update(Movil mob) {
		return movil_repository.update(mob);
	}
	/**
	 * @return Se encarga de eliminar un movil por id que estaba en la BBDD y el repositorio
	 */
	@Override
	public void deleteById(Long id) {
		movil_repository.deleteById(id);
		
	}

	

}
