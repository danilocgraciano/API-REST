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

import com.exercicio.sistema.entity.SubSistema;
import com.exercicio.sistema.service.SubSistemaService;

@RestController
@RequestMapping("/subsistemas")
public class SubSistemaController {

	@Autowired
	private SubSistemaService subSistemaService;

	@GetMapping
	public ResponseEntity<List<SubSistema>> list() {
		return ResponseEntity.status(HttpStatus.OK).body(subSistemaService.list());
	}

	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody SubSistema subSistema) {

		subSistema = subSistemaService.save(subSistema);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(subSistema.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<SubSistema>> search(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(subSistemaService.search(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		subSistemaService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody SubSistema subSistema, @PathVariable("id") Long id){
		
		subSistema.setId(id);
		subSistemaService.update(subSistema);
		return ResponseEntity.noContent().build();
		
	}

}
