package br.com.livraria.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.livraria.dao.AutorDao;
import br.com.livraria.model.Autor;

public class TesteInsertAutor {

	public static void main(String[] args) throws SQLException {
		
		String banco = "jdbc:postgresql://localhost:5432/livraria?autoReconnect=true";
		String user = "postgres";
		String password = "admin";
		Connection conexao = DriverManager.getConnection(banco, user, password);
		
		AutorDao dao = new AutorDao(conexao);

		Autor autor = new Autor();
		
		autor.setNome("Anderson");
		autor.setEmail("teste@gmail.com");
		autor.setDt_nascimento(LocalDate.parse("1990-05-02"));
		autor.setMini_curriculo("Texto Mini Curriculo.");
		dao.cadastrar(autor);
				
		Autor a = new Autor("Dandy", "teste@gmail.com", LocalDate.now(), "texto");
		dao.cadastrar(a);
		
		List<Autor> lista = dao.listar();
		
		lista.forEach(System.out::println);
		
	}

}
