package com.alexbookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	@NotEmpty(message = "O campo TÍTULO não pode ser vazio")
	@Length(min = 5, max = 50, message = "O campo TÍTULO deve ter entre 5 e 50 caracteres")
	private String titulo;
	@NotEmpty(message = "O campo NOME AUTOR não pode ser vazio")
	@Length(min = 3, max = 50, message = "O campo NOME AUTOR deve ter entre 3 e 50 caracteres")
	private String autor;
	@NotEmpty(message = "O campo CONTEÚDO não pode ser vazio")
	@Length(min = 10, max = 2000000, message = "O campo CONTEÚDO deve ter entre 10 e 2000000 caracteres")
	private String conteudo;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Integer id, String titulo, String autor, String conteudo, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.conteudo = conteudo;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
