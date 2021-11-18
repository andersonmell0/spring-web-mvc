package com.example.springwebmvc.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springwebmvc.exception.JediNotFoundException;
import com.example.springwebmvc.model.Jedi;
import com.example.springwebmvc.repository.JediRepository;

@RestController
public class JediResource {
	
	@Autowired
	private JediRepository repository;
	
	@GetMapping("/api/jedi")
	public List<Jedi> getAllJedi() {				
		return repository.findAll();
	}
	
	@GetMapping("/api/jedi/{id}")
	public Jedi getJedi(@PathVariable("id") Long id) {				
		final Optional<Jedi> jedi = repository.findById(id);
		
		if (jedi.isPresent()) {
			return jedi.get();
		} else {
			throw new JediNotFoundException();
		}
	}

}