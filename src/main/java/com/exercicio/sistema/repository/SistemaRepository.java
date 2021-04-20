package com.exercicio.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.sistema.entity.Sistema;

public interface SistemaRepository extends JpaRepository<Sistema, Long>{}
