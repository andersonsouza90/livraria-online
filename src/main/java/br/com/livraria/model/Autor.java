package br.com.livraria.model;

import java.time.LocalDate;

public class Autor {
	
	private int id_autor;
	private String nome;
	private String email;
	private LocalDate dt_nascimento;
	private String mini_curriculo;
	
	public Autor() {
	}
	
	public Autor(String nome, String email, LocalDate dt_nascimento, String mini_curriculo) {
		super();
		this.nome = nome;
		this.email = email;
		this.dt_nascimento = dt_nascimento;
		this.mini_curriculo = mini_curriculo;
	}
	
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public int getId_autor() {
		return id_autor;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(LocalDate dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public String getMini_curriculo() {
		return mini_curriculo;
	}
	public void setMini_curriculo(String mini_curriculo) {
		this.mini_curriculo = mini_curriculo;
	}
	
	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", dt_nascimento=" + dt_nascimento + ", mini_curriculo="
				+ mini_curriculo + "]";
	}
	
	

}
