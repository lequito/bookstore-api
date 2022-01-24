package com.alexbookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexbookstore.domain.Categoria;
import com.alexbookstore.domain.Livro;
import com.alexbookstore.repositories.CategoriaRepository;
import com.alexbookstore.repositories.LivroRepository;

@Service
public class DBServices {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaDb() {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de Informática");
		Categoria cat2 = new Categoria(null, "Redes", "Redes de computadore");
		Categoria cat3 = new Categoria(null, "Teste", "Livros de teste");
		Categoria cat4 = new Categoria(null, "Redes", "Redes de computadore");
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "fhgfk kjfjk fkjfk ", cat1);
		Livro l2 = new Livro(null, "Redes de computadores", "Tannebaun", "fhgfk kjfjk fkjfk ", cat2);
		Livro l3 = new Livro(null, "Clean code", "Robert Martin", "fhgfk kjfjk fkjfk ", cat4);
		Livro l4 = new Livro(null, "Redes de computadores", "Tannebaun", "fhgfk kjfjk fkjfk ", cat3);
		Livro l5 = new Livro(null, "Clean code", "Robert Martin", "fhgfk kjfjk fkjfk ", cat1);
		Livro l6 = new Livro(null, "Redes de computadores", "Tannebaun", "fhgfk kjfjk fkjfk ", cat3);
		cat1.getLivros().addAll(Arrays.asList(l1,l5));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l6,l4));
		cat4.getLivros().addAll(Arrays.asList(l3));
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4));
		this.livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5,l6));
	}
}
