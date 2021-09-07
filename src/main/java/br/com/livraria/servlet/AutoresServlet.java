package br.com.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.dao.AutorDao;
import br.com.livraria.factory.ConnectionFactory;
import br.com.livraria.model.Autor;

@WebServlet("/autores")
public class AutoresServlet extends HttpServlet{
	
	private AutorDao dao;
	
	public AutoresServlet() {
		this.dao = new AutorDao(new ConnectionFactory().getConnection());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("autores", this.dao.listar());
		req.getRequestDispatcher("WEB-INF/jsp/autores.jsp")
		   .forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getParameter("excluir") != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			boolean rs = this.dao.excluir(id);
			resp.sendRedirect("exibeRetorno?retorno="+rs);
			
		}else {
			try {
				String nome = req.getParameter("nome");
				String email = req.getParameter("email");
				LocalDate dt_nascimento = LocalDate.parse(
						req.getParameter("dt_nascimento"), 
						DateTimeFormatter.ofPattern("dd/MM/yyyy"));	
				String mini_curriculo = req.getParameter("mini_curriculo");
				
				Autor autor = new Autor(nome, email, dt_nascimento, mini_curriculo);
				
				this.dao.cadastrar(autor);
				resp.sendRedirect("autores");
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
				
	}
	

}
