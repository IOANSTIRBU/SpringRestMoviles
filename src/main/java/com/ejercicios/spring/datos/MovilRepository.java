package com.ejercicios.spring.datos;

import java.util.List;
import java.util.Optional;

import com.ejercicios.spring.model.Movil;

public interface MovilRepository {
	
	public List<Movil> findAll();
	
	public Optional<Movil> findById(long id);

	public Movil save(Movil mob);
	
	public Optional<Movil> update(Movil mob);

	public void deleteById(Long id);
}
