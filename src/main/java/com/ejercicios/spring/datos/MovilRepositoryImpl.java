package com.ejercicios.spring.datos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ejercicios.spring.model.Movil;

/**
 * 
 * @author Ioan Stirbu
 *
 */


@Repository
public class MovilRepositoryImpl implements MovilRepository{

	
	
	private Map<Long, Movil> moviles = new HashMap<>();
	
	private long contadorID = 20;
	
	/**
	 * Este metodo, no devuelve nada y muestra
	 * unos cuantos moviles de prueba
	 */
	
	public void demo() {
		moviles.put(++contadorID, new Movil(contadorID,"Samsung","A30s", "verde"));
		moviles.put(++contadorID, new Movil(contadorID,"Iphone", "12", "amarillo"));
		moviles.put(++contadorID, new Movil(contadorID,"Iphone", "12 Pro Max", "violeta"));
		moviles.put(++contadorID, new Movil(contadorID,"Xiaomi","10", "Azul"));
		moviles.put(++contadorID, new Movil(contadorID,"Samsung","S22", "rojo"));
	}
	
	public MovilRepositoryImpl() {
		super();
		this.demo();
	}
	
	/**
	 * @return Devuelve una lista de telefonos
	 */
	
	
	@Override
	public List<Movil> findAll() {
		List<Movil> listaTelefonos = new ArrayList<>(moviles.values());
		
		return listaTelefonos;
	}
	
	
	/**
	 * @return Devuelve un Optional en caso de que no encuentre
	 * el movil con el id especificado
	 */

	@Override
	public Optional<Movil> findById(long id) {
		Movil movil = null;
		
		if(moviles.containsKey(id))
			movil = moviles.get(id);
		
		return Optional.ofNullable(movil);
	}

	
	/**
	 * @return Devuelve un movil y lo guarda en la BBDD
	 */
	
	
	@Override
	public Movil save(Movil mob) {
		mob.setId(++contadorID);
		
		moviles.put(mob.getId(), mob);
		return mob;
	}

	/**
	 * @return Devuelve un Optional en caso que el movil que
	 *yo quiera actualizar exista, sino lo dejara en null
	 */
	
	@Override
	public Optional<Movil> update(Movil mob) {
		Movil movil_reciente = moviles.get(mob.getId());
		
		if (movil_reciente != null) {
			moviles.put(mob.getId(), mob);
			movil_reciente = moviles.get(mob.getId());
		}
		
		return Optional.ofNullable(movil_reciente);
	}

	/**
	 * No devuelve nada y elimina un movil por id
	 */
	
	@Override
	public void deleteById(Long id) {
		Movil movil_reciente = moviles.get(id);
		
		System.out.println("--------" + movil_reciente);
		
		if(movil_reciente != null)
			moviles.remove(id);
		
		System.out.println("------" + movil_reciente);
		
	}

	

}
