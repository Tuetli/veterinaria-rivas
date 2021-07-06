package com.projectrivas.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projectrivas.dao.AnimalDAO;
import com.projectrivas.entity.Animal;
import com.projectrivas.service.AnimalService;
import com.projectrivas.util.Constantes;
import com.projectrivas.util.Raza;

@Service
public class AnimalServiceImpl implements AnimalService {
	
	@Autowired
	AnimalDAO animalDAO;
	
	@Override
	@Transactional
	public List<Animal> consultarGeneral() {
		return this.animalDAO.consultarGeneral();
	}

	@Override
	@Transactional
	public List<Animal> consultarPorRaza(Raza raza) {
		return this.animalDAO.consultarPorRaza(raza);
	}

	@Override
	@Transactional
	public List<Animal> consultarPorColor(String color) {
		return this.animalDAO.consultarPorColor(color);
	}

	@Override
	@Transactional
	public Animal consultarPorId(Long id) {
		return this.animalDAO.consultarPorId(id);
	}

	@Override
	@Transactional
	public Animal consultarPorNombre(String nombre) {
		return this.animalDAO.consultarPorNombre(nombre);
	}

	@Override
	@Transactional
	public int agregar(Animal animal) {
		return this.animalDAO.agregar(animal);
	}

	@Override
	@Transactional
	public int editar(Animal animal) {
		return this.animalDAO.editar(animal);
	}

	@Override
	@Transactional
	public int eliminar(Long id) {
		Animal animal = this.consultarPorId(id);
		return this.animalDAO.eliminar(animal);
	}

	@Override
	@Transactional
	public int eliminarPorRaza(Raza raza) {
		List<Animal> animalList = this.consultarPorRaza(raza);
		
		for(Animal animal : animalList) {
			this.animalDAO.eliminar(animal);
		}
		
		return Constantes.TRANSACCION_CORRECTA;
	}

}
