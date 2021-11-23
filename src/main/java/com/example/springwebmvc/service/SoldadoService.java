package com.example.springwebmvc.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springwebmvc.exception.SoldadoNotFoundException;
import com.example.springwebmvc.model.Soldado;
import com.example.springwebmvc.repository.SoldadoRepository;

@Service
public class SoldadoService {
	
	@Autowired
	private SoldadoRepository repository;
	
	public List<Soldado> listarSoldados(){  
		return repository.findAll();
	}
	
	public Soldado buscarSoldadoPorId(Long id) {
		Optional<Soldado> soldado = repository.findById(id);
		if (soldado.isPresent()) {
			return soldado.get();
		} else {
			throw new SoldadoNotFoundException();
		}
	}
	
	public Soldado criarSoldado(@Valid Soldado soldado){
		return repository.save(soldado);
    }

    public Soldado alterarSoldado(Long id, Soldado dto) {
    	Optional<Soldado> soldadoEntity = repository.findById(id);
    	Soldado soldado;
    	if (soldadoEntity.isPresent()) {
    		soldado = soldadoEntity.get();
    	} else {
    		throw new SoldadoNotFoundException();
    	}
    	
    	soldado.setNome(dto.getNome());
    	soldado.setArma(dto.getArma());
    	soldado.setRaca(dto.getRaca());
    	
    	return repository.save(soldado);
    }

    public void deletarSoldado(Long id) {
    	Soldado soldado = buscarSoldadoPorId(id); 
    	repository.delete(soldado);
    }
      
}