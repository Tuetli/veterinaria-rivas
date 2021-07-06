package com.projectrivas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectrivas.entity.Animal;
import com.projectrivas.service.AnimalService;
import com.projectrivas.util.Raza;

@RestController
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;
	
	@GetMapping(value = "/consultas-general")
	public List<Animal> consultarGeneral() {
		return this.animalService.consultarGeneral();
	}

	@GetMapping(value = "/consultas-raza")
	public List<Animal> consultarPorRaza(@RequestParam Raza raza) {
		return this.animalService.consultarPorRaza(raza);
	}

	@GetMapping(value = "/consultas-color")
	public List<Animal> consultarPorColor(@RequestParam String color) {
		return this.animalService.consultarPorColor(color);
	}

	@GetMapping(value = "/consultas/{id}")
	public Animal consultarPorId(@PathVariable Long id) {
		return this.animalService.consultarPorId(id);
	}

	@GetMapping(value = "/consultas-nombre")
	public Animal consultarPorNombre(@RequestParam String nombre) {
		return this.animalService.consultarPorNombre(nombre);
	}

	@PostMapping(value = "/alta")
	public int agregar(@RequestBody Animal animal) {
		return this.animalService.agregar(animal);
	}

	@PutMapping(value = "/modificacion")
	public int editar(@RequestBody Animal animal) {
		return this.animalService.editar(animal);
	}

	@DeleteMapping(value = "/baja/{id}")
	public int eliminar(@PathVariable Long id) {
		return this.animalService.eliminar(id);
	}

	@DeleteMapping(value = "/baja-raza")
	public int eliminarPorRaza(@RequestParam Raza raza) {
		return this.animalService.eliminarPorRaza(raza);
	}

}
