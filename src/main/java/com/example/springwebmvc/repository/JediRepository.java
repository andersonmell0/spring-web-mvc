package com.example.springwebmvc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springwebmvc.model.Jedi;

@Repository
public interface JediRepository extends JpaRepository<Jedi, Long>{

	public List<Jedi> jedi = new ArrayList<>();
			
	public JediRepository() {		
		jedi.add(new Jedi("Luke", "Skywalker"));
		jedi.add(new Jedi("Anakin", "Skywalker"));		
	}

	public List<Jedi> getAllJedi(){			
		return this.jedi;
	}

	public void add(final Jedi jedi) {
		this.jedi.add(jedi);	
	}
}