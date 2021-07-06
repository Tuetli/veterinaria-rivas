package com.projectrivas.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectrivas.dao.AnimalDAO;
import com.projectrivas.entity.Animal;
import com.projectrivas.util.Constantes;
import com.projectrivas.util.Raza;

@Repository
public class AnimalDAOImpl implements AnimalDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Animal> consultarGeneral() {
		return entityManager.createQuery("FROM Animal a", Animal.class).getResultList();
	}

	@Override
	@Transactional
	public List<Animal> consultarPorRaza(Raza raza) {
		return entityManager.createQuery("FROM Animal a WHERE a.raza = :raza", Animal.class)
				.setParameter("raza", raza).getResultList();
	}

	@Override
	@Transactional
	public List<Animal> consultarPorColor(String color) {
		return entityManager.createQuery("FROM Animal a WHERE color = :color", Animal.class)
				.setParameter("color", color).getResultList();
	}

	@Override
	public Animal consultarPorId(Long id) {
		return entityManager.find(Animal.class, id);
	}

	@Override
	@Transactional
	public Animal consultarPorNombre(String nombre) {
		return entityManager.createQuery("FROM Animal a WHERE nombre = :nombre", Animal.class)
				.setParameter("nombre", nombre).getSingleResult();
	}

	@Override
	@Transactional
	public int agregar(Animal animal) {
		entityManager.persist(animal);
		return Constantes.TRANSACCION_CORRECTA;
	}

	@Override
	@Transactional
	public int editar(Animal animal) {
		entityManager.merge(animal);
		return Constantes.TRANSACCION_CORRECTA;
	}

	@Override
	@Transactional
	public int eliminar(Animal animal) {
		entityManager.remove(animal);
		return Constantes.TRANSACCION_CORRECTA;
	}

	@Override
	@Transactional
	public int eliminarPorRaza(Animal animal) {
		entityManager.remove(animal);
		return Constantes.TRANSACCION_CORRECTA;
	}

}
