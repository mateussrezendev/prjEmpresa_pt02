package com.mateus.prjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;
	
	@NotNull
	@NotBlank
	private String funnome;
	
	@NotNull
	@NotBlank
	@DateTimeFormat(pattern = "dd/MM/yyyy")
		private LocalDate funnascimento;
			
			private double funsalario;
			
			@ManyToOne
			private Departamento departamento;

		//inserir os metodos get e o set
		public Departamento getDepartamento() {
				return departamento;
			}

			public void setDepartamento(Departamento departamento) {
				this.departamento = departamento;
			}
	
	public void funcionario() {

	}

	public Funcionario(Long funcodigo, String funnome, LocalDate funnascimento, double funsalario) {
		super();
		this.funcodigo = funcodigo;
		this.funnome = funnome;
		this.funnascimento = funnascimento;
		this.funsalario = funsalario;
	}

	public Long getfuncodigo() {
		return funcodigo;
	}

	public void setfuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getfunnome() {
		return funnome;
	}

	public void setfunnome(String funnome) {
		this.funnome = funnome;
	}
	
	public LocalDate getFunnascimento() {
		return funnascimento;
	}
	
	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}
	
	public double getFunsalario() {
		return funsalario;
	}

	public void setFunsalario(double funsalario) {
		this.funsalario = funsalario;
	}
}
