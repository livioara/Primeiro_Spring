package com.livioara.meuprimeiroprojeto.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livioara.meuprimeiroprojeto.entidades.Categoria;
import com.livioara.meuprimeiroprojeto.repositorios.CategoriaRepositorio;



	@RestController
	@RequestMapping(value = "/categorias")
	public class CategoriaRecursos {
		
		@Autowired
		private CategoriaRepositorio categoriaRepositorio;

		@GetMapping
		public ResponseEntity<List<Categoria>> findAll() {
			List<Categoria> list = categoriaRepositorio.findAll();
			return ResponseEntity.ok().body(list);
		}

		@GetMapping(value = "/{id}")
		public ResponseEntity<Categoria> findById(@PathVariable Long id) {
			Categoria cat = categoriaRepositorio.findById(id).get();
			return ResponseEntity.ok().body(cat);
		}
	}

