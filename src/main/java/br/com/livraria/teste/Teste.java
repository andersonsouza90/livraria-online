package br.com.livraria.teste;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.livraria.model.Autor;

public class Teste {

	public static void main(String[] args) {
		Autor autor = new Autor();
		
		autor.setNome("Anderson");
		autor.setEmail("teste@gmail.com");
		autor.setDt_nascimento(LocalDate.parse("1990-05-02"));
		autor.setMini_curriculo("Texto Mini Curriculo.");
		
		System.out.println(autor);
		
		Autor a = new Autor("Dandy", "teste@gmail.com", LocalDate.now(), "texto");
		System.out.println(a);

	}

}
