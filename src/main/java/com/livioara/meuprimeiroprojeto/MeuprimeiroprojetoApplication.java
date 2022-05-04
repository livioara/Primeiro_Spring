package com.livioara.meuprimeiroprojeto;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.livioara.meuprimeiroprojeto.entidades.Categoria;
import com.livioara.meuprimeiroprojeto.entidades.Produto;
import com.livioara.meuprimeiroprojeto.repositorios.CategoriaRepositorio;
import com.livioara.meuprimeiroprojeto.repositorios.ProdutoRepositorio;

@SpringBootApplication
public class MeuprimeiroprojetoApplication implements CommandLineRunner{
	
	
	

		@Autowired
		private CategoriaRepositorio CategoriaRepositorio;
		
		@Autowired
		private ProdutoRepositorio ProdutoRepositorio;
		
		public static void main(String[] args) {
			SpringApplication.run(MeuprimeiroprojetoApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			Categoria cat1 = new Categoria(null, "Electronics");
			Categoria cat2 = new Categoria(null, "Books");

			Produto p1 = new Produto(null, "TV", 2200.00, cat1);
			Produto p2 = new Produto(null, "Domain Driven Design", 120.00, cat2);
			Produto p3 = new Produto(null, "PS5", 2800.00, cat1);
			Produto p4 = new Produto(null, "Docker", 100.00, cat2);

			cat1.getProdutos().addAll(Arrays.asList(p1, p3));
			cat2.getProdutos().addAll(Arrays.asList(p2, p4));
			
			CategoriaRepositorio.save(cat1);
			CategoriaRepositorio.save(cat2);
			
			ProdutoRepositorio.save(p1);
			ProdutoRepositorio.save(p2);
			ProdutoRepositorio.save(p3);
			ProdutoRepositorio.save(p4);
		}
	}
	

