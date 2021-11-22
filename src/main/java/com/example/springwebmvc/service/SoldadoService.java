package com.example.springwebmvc.service;

import org.springframework.stereotype.Service;

import com.example.springwebmvc.model.Soldado;

@Service
public class SoldadoService {

	public Soldado buscarSoldado(Long id) {		
		
		Soldado soldado = new Soldado();
		soldado.setId(id);
		soldado.setNome("Anderson");
		soldado.setArma("Espada");
		soldado.setRaca("Orc");
		
		return soldado;
	}
	
	public void criarSoldado(Soldado soldado) {
	
	}
}