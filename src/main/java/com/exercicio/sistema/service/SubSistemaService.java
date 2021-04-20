package com.exercicio.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.sistema.entity.SubSistema;
import com.exercicio.sistema.repository.SubSistemaRepository;

@Service
public class SubSistemaService {

	@Autowired
	private SubSistemaRepository subSistemaRepository;

	private Optional<SubSistema> subSistema;

	public List<SubSistema> list(){
		return subSistemaRepository.findAll();
	}

	public SubSistema save(SubSistema subSistema) {

		return subSistemaRepository.save(subSistema);
	}

	public Optional<SubSistema> search(Long id) {

		subSistema = subSistemaRepository.findById(id);		
		return subSistema;
	}

	public SubSistema delete(Long id) {
		subSistemaRepository.deleteById(id);
		return null;
	}
	
	public void update(SubSistema subSistema) {
		ifExist(subSistema);
		subSistemaRepository.save(subSistema);
	}

	private void ifExist(SubSistema subSistema) {
		search(subSistema.getId());
	}
}
