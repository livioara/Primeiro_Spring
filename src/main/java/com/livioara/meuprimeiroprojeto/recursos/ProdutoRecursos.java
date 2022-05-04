package com.livioara.meuprimeiroprojeto.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livioara.meuprimeiroprojeto.entidades.Produto;
import com.livioara.meuprimeiroprojeto.repositorios.ProdutoRepositorio;



	@RestController
	@RequestMapping(value = "/produtos")
	public class ProdutoRecursos {
		
		@Autowired
		private ProdutoRepositorio produtoRepositorio;

		@GetMapping
		public ResponseEntity<List<Produto>> findAll() {
			List<Produto> list = produtoRepositorio.findAll();
			return ResponseEntity.ok().body(list);
		}

		@GetMapping(value = "/{id}")
		public ResponseEntity<Produto> findById(@PathVariable Long id) {
			Produto obj = produtoRepositorio.findById(id).get();
			return ResponseEntity.ok().body(obj);
		}
	}

