package com.mateus.prjEmpresa.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.prjEmpresa.entities.Departamento;
import com.mateus.prjEmpresa.services.DepartamentoService;


@RestController
@RequestMapping("/departamento")
public class DepartamentoControler {
	private final DepartamentoService departamentoService;
	
	public DepartamentoControler(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long id) {
		Departamento departamento =departamentoService.getDepartamentoById(id);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // Nome do seu arquivo HTML (sem a extensão)
	}

	@PostMapping
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}
	
	//Utilizando o ResponseEntity e RequestEntity
		@GetMapping
		public ResponseEntity<List<Departamento>> getAlllivros(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Departamento> livros = departamentoService.getAllDepartamentos();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(livros);
		}
		
		@PutMapping("/{id}")
		public Departamento updatelivro(@PathVariable Long id, @RequestBody Departamento departamento) {
		    return departamentoService.updateDepartamento(id, departamento);
		}
		

	@DeleteMapping("/{id}")
	public void deletelivro(@PathVariable Long id) {
		departamentoService.deleteDepartamento(id);
	}
	
	
	
}
