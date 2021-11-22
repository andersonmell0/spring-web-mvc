package com.example.springwebmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springwebmvc.model.Soldado;
import com.example.springwebmvc.service.SoldadoService;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {
	
	private SoldadoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Soldado> buscarSoldado(@PathVariable("id") Long id) {
		Soldado soldado = service.buscarSoldado(id);
		return ResponseEntity.status(HttpStatus.OK).body(soldado);
	}
	
	@PostMapping
	public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
		service.criarSoldado(soldado);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity editarSoldado(@PathVariable("id") Long id, @RequestBody Soldado soldado) {
		return null;	
	}
}