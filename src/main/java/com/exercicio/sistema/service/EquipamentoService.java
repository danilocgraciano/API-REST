package com.exercicio.sistema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.sistema.entity.Equipamento;
import com.exercicio.sistema.repository.EquipamentoRepository;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	private Optional<Equipamento> equipamento;
	
	public List<Equipamento> list(){
		return equipamentoRepository.findAll();
	}

	public Equipamento save(Equipamento equipamento) {
		
		return equipamentoRepository.save(equipamento);
	}

	public Optional<Equipamento> search(Long id) {
		
		equipamento = equipamentoRepository.findById(id);		
		return equipamento;
	}
	
	public Equipamento delete(Long id) {
		equipamentoRepository.deleteById(id);
		return null;
	}
	
	public void update(Equipamento equipamento) {
		ifExist(equipamento);
		equipamentoRepository.save(equipamento);
	}

	private void ifExist(Equipamento equipamento) {
		search(equipamento.getId());
	}
	
	
}
