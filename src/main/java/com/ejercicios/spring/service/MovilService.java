package com.ejercicios.spring.service;

import java.util.List;
import java.util.Optional;


import com.ejercicios.spring.model.Movil;

/**
 * 
 * @author Ioan Stirbu
 *
 */

public interface MovilService {

	/**
	 * 
	 * @return List Movil
	 * 
	 * Me devuelve una lista de moviles
	 */
	
		public List<Movil> findAll();
		
		/**
		 * 
		 * @param id
		 * @return Optional Movil
		 * 
		 * Me devuelve un Optional buscando 
		 * un id
		 * 
		 */
		
		public Optional<Movil> findById(long id);

		/**
		 * 
		 * @param mob
		 * @return Movil
		 * 
		 * En este metodo me guarda un movil
		 */
		
		public Movil save(Movil mob);
		
		/**
		 * 
		 * @param mob
		 * @return Optional Movil
		 * 
		 * En este metodo me actualiza los
		 * datos de un movil que ya existe
		 */
		
		public Optional<Movil> update(Movil mob);

		/**
		 * 
		 * @param id
		 * 
		 * 
		 * En este metodo me eliminas un
		 * movil por id.
		 *
		 */
		
		public void deleteById(Long id);
	
}
