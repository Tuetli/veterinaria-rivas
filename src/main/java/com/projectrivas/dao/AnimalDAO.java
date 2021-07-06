package com.projectrivas.dao;

import java.util.List;

import com.projectrivas.entity.Animal;
import com.projectrivas.util.Raza;

public interface AnimalDAO {
	
	List<Animal> consultarGeneral();
	
	List<Animal> consultarPorRaza(Raza raza);
	
	List<Animal> consultarPorColor(String color);
	
	Animal consultarPorId(Long id);
	
	Animal consultarPorNombre(String nombre);
	
	int agregar(Animal animal);
	
	int editar(Animal animal);
	
	int eliminar(Animal animal);
	
	int eliminarPorRaza(Animal animal);

}
