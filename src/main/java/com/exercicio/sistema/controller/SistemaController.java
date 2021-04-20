	package com.exercicio.sistema.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.exercicio.sistema.entity.Sistema;
import com.exercicio.sistema.service.SistemaService;

@RestController
@RequestMapping("/sistemas")
public class SistemaController {

	@Autowired
	private SistemaService sistemaService;

	@GetMapping
	public ResponseEntity<List<Sistema>> list(){
		return ResponseEntity.status(HttpStatus.OK).body(sistemaService.list());
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Sistema sistema){

		sistema = sistemaService.save(sistema);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/{id}").buildAndExpand(sistema.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Sistema>> search(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(sistemaService.search(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		sistemaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Sistema sistema, @PathVariable("id") Long id){
		
		sistema.setId(id);
		sistemaService.update(sistema);
		return ResponseEntity.noContent().build();
		
	}
	
}
