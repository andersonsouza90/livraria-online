package br.com.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.Autor;

public class AutorDao {
	private Connection conexao;

	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrar(Autor a) {

		try {
			String sql = "insert into autores (nome, email, dt_nascimento, mini_curriculo)"+
						"values (?, ?, ?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setString(2, a.getEmail());
			ps.setDate(3, Date.valueOf(a.getDt_nascimento()));
			ps.setString(4, a.getMini_curriculo());
			ps.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Autor> listar(){
		try {
			
			List<Autor> autores = new ArrayList<Autor>();
			
			String sql = "select * from autores";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Autor a = new Autor();
				a.setId_autor(rs.getInt("id_autor"));
				a.setNome(rs.getString("nome"));
				a.setEmail(rs.getString("email"));
				a.setDt_nascimento(rs.getDate("dt_nascimento").toLocalDate());
				a.setMini_curriculo(rs.getString("mini_curriculo"));
				
				autores.add(a);				
			}
			
			return autores;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean excluir(int id) {
		try {
			String sql = "delete from autores where id_autor = ?";
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
