package com.exercicio.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.sistema.entity.Sistema;
import com.exercicio.sistema.repository.SistemaRepository;

@Service
public class SistemaService {

	@Autowired
	private SistemaRepository sistemaRepository;

	private Optional<Sistema> sistema;

	public List<Sistema> list(){
		return sistemaRepository.findAll();
	}

	public Sistema save(Sistema sistema) {

		return sistemaRepository.save(sistema);
	}

	public Optional<Sistema> search(Long id) {

		sistema = sistemaRepository.findById(id);		
		return sistema;
	}

	public Sistema delete(Long id) {
		sistemaRepository.deleteById(id);
		return null;
	}
	
	public void update(Sistema sistema) {
		ifExist(sistema);
		sistemaRepository.save(sistema);
	}

	private void ifExist(Sistema sistema) {
		search(sistema.getId());
	}
}
