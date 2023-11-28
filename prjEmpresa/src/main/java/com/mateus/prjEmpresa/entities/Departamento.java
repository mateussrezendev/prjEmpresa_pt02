package com.mateus.prjEmpresa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depcodigo;
	
	@NotNull
	@NotBlank
	private String depnome;
	@NotNull
	@NotBlank

	public void departamento() {

	}

	public Departamento(Long depcodigo, String depnome, String isbn) {
		super();
		this.depcodigo = depcodigo;
		this.depnome = depnome;
	}

	public Long getdepcodigo() {
		return depcodigo;
	}

	public void setdepcodigo(Long depcodigo) {
		this.depcodigo = depcodigo;
	}

	public String getdepnome() {
		return depnome;
	}

	public void setdepnome(String depnome) {
		this.depnome = depnome;
	}

}
