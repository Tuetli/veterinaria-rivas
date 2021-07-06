package com.projectrivas.service;

import java.util.List;

import com.projectrivas.entity.Animal;
import com.projectrivas.util.Raza;

public interface AnimalService {

	List<Animal> consultarGeneral();

	List<Animal> consultarPorRaza(Raza raza);

	List<Animal> consultarPorColor(String color);

	Animal consultarPorId(Long id);

	Animal consultarPorNombre(String nombre);

	int agregar(Animal animal);

	int editar(Animal animal);

	int eliminar(Long id);

	int eliminarPorRaza(Raza raza);

}
