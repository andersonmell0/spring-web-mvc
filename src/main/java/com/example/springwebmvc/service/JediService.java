package com.example.springwebmvc.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springwebmvc.exception.JediNotFoundException;
import com.example.springwebmvc.model.Jedi;
import com.example.springwebmvc.repository.JediRepository;

@Service
public class JediService {

	@Autowired
	private JediRepository repository;

	public List<Jedi> findAll() {		
		return repository.findAll();
	}

	public Jedi findById(Long id) {
		
		final Optional<Jedi> jedi = repository.findById(id);
		
		if (jedi.isPresent()) {
			return jedi.get();
		} else {
			throw new JediNotFoundException();
		}
	}

	public Jedi save(@Valid Jedi jedi) {
		return repository.save(jedi);
	}

	public Jedi update(Long id, @Valid Jedi dto) {
		
		final Optional<Jedi> jediEntity = repository.findById(id);
		final Jedi jedi;
		
		if (jediEntity.isPresent()) {
			 jedi = jediEntity.get();
		}else {
			throw new JediNotFoundException();
		}
		
		jedi.setName(dto.getName());
		jedi.setLastName(dto.getLastName());
		
		return repository.save(jedi);
	}

	public void delete(Long id) {
		final Jedi jedi = findById(id);
		repository.delete(jedi);									
	}
}