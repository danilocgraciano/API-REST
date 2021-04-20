package com.exercicio.sistema.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Equipamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String enderecoIP;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date dataCadastro;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private SubSistema subSistema;
	
	public Equipamento() {}

	public Equipamento(String nome) {
		this.nome = nome;
	}
	
	public SubSistema getSubSistema() {
		return subSistema;
	}
	public void setSubSistema(SubSistema subSistema) {
		this.subSistema = subSistema;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEnderecoIP() {
		return enderecoIP;
	}
	public void setEnderecoIP(String enderecoIP) {
		this.enderecoIP = enderecoIP;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}
