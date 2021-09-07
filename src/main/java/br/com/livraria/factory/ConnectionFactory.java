package br.com.livraria.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			String banco = "jdbc:postgresql://localhost:5432/livraria?autoReconnect=true";
			String user = "postgres";
			String password = "admin";
			Connection conexao = DriverManager.getConnection(banco, user, password);
			return conexao;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
