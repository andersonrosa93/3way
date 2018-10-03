package br.com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.LivroDao;
import br.com.model.Livro;

@WebServlet("/LivroController")
public class LivroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	
	private static final String INSERIR_OU_EDITAR = "/addLivro.jsp";
	private static final String LISTAR_LIVROS = "/livro.jsp";
	
	private LivroDao dao = new LivroDao();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("deletar")) {
			int livroId = Integer.parseInt(request.getParameter("livroId"));
			dao.removeLivro(livroId);
			forward = LISTAR_LIVROS;
			request.setAttribute("livros", dao.consultarTodos());
		}else if (action.equalsIgnoreCase("editar")) {
			forward = INSERIR_OU_EDITAR;
			int codigoLivro = Integer.parseInt(request.getParameter("livroId"));
			Livro livro = dao.consultarCodigo(codigoLivro);
			request.setAttribute("livro", livro);
		}else if (action.equalsIgnoreCase("listarLivros")) {
			forward = LISTAR_LIVROS;
			request.setAttribute("livros", dao.consultarTodos());
		}else {
			forward = INSERIR_OU_EDITAR;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Livro livro = new Livro();
		livro.setTitulo(request.getParameter("titulo"));
		livro.setAutor(request.getParameter("autor"));
		livro.setDescricao(request.getParameter("descricao"));
		livro.setImagem(request.getParameter("imagem"));
		livro.setPreco(request.getParameter("preco") != null ? Double.parseDouble(request.getParameter("preco")): 0);
		String codigoLivro = request.getParameter("livroCodigo");
		String buscarLivro = request.getParameter("buscarLivro");
		
		List<Livro> livros = new ArrayList<>();
		
		if((codigoLivro == null || codigoLivro.isEmpty()) & buscarLivro == null)  {
			dao.addLivro(livro);
			livros = dao.consultarTodos();
		}else if(buscarLivro != null) {
			livros = dao.consultarLivros(buscarLivro);
		}else {
			livro.setCodigo(Integer.parseInt(codigoLivro));
			dao.updateLivro(livro);
			livros = dao.consultarTodos();
		}
		
		request.setAttribute("livros", livros);
		RequestDispatcher view = request.getRequestDispatcher(LISTAR_LIVROS);
		view.forward(request, response);
	}

}
