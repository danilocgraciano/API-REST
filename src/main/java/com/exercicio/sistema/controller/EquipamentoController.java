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

import com.exercicio.sistema.entity.Equipamento;
import com.exercicio.sistema.service.EquipamentoService;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

	@Autowired
	private EquipamentoService equipamentoService;
	
	@GetMapping
	public ResponseEntity<List<Equipamento>> list(){
		return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.list());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Equipamento>> search(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(equipamentoService.search(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@Valid @RequestBody Equipamento equipamento) {

		equipamento = equipamentoService.save(equipamento);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(equipamento.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		equipamentoService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody Equipamento equipamento, @PathVariable("id") Long id){
		
		equipamento.setId(id);
		equipamentoService.update(equipamento);
		return ResponseEntity.noContent().build();
		
	}
	
}
