package com.exercicio.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.sistema.entity.Equipamento;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {}
