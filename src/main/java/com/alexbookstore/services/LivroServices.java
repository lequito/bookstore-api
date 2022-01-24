package com.alexbookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexbookstore.domain.Categoria;
import com.alexbookstore.domain.Livro;
import com.alexbookstore.exception.ObjectNotFoundException;
import com.alexbookstore.repositories.LivroRepository;

@Service
public class LivroServices {

	@Autowired
	private LivroRepository repository;
	@Autowired
	private CategoriaServices categoriaServices;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não foi encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaServices.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro update(Integer id, Livro obj) {
		Livro newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Livro newObj, Livro obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setAutor(obj.getAutor());
		newObj.setConteudo(obj.getConteudo());
	}

	public Livro create(Integer id_cat, Livro obj) {
		obj.setId(null);
		Categoria cat = categoriaServices.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
	    repository.delete(obj);
	}
}
