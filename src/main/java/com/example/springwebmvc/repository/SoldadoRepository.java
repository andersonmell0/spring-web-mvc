package com.example.springwebmvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springwebmvc.model.Soldado;

@Repository
public interface SoldadoRepository extends JpaRepository<Soldado, Long>{

	public List<Soldado> soldado = new ArrayList<>();
	
	List<Soldado> findByNomeContainingIgnoreCase(final String nome);
			
}