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

import br.com.dao.UsuarioDao;
import br.com.model.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
private static final long serialVersionUID = 1L;
       

	
	
	private static final String INSERIR_OU_EDITAR = "/addUsuario.jsp";
	private static final String LISTAR_USUARIOS = "/usuario.jsp";
	
	private UsuarioDao dao = new UsuarioDao();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("deletar")) {
			int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
			dao.removeUsuario(usuarioId);
			forward = LISTAR_USUARIOS;
			request.setAttribute("usuarios", dao.consultarTodos());
		}else if (action.equalsIgnoreCase("editar")) {
			forward = INSERIR_OU_EDITAR;
			int idUsuario = Integer.parseInt(request.getParameter("usuarioId"));
			Usuario usuario = dao.consultarId(idUsuario);
			request.setAttribute("usuario", usuario);
		}else if (action.equalsIgnoreCase("listarUsuarios")) {
			forward = LISTAR_USUARIOS;
			request.setAttribute("usuarios", dao.consultarTodos());
		}else {
			forward = INSERIR_OU_EDITAR;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setLogin(request.getParameter("login"));
		usuario.setMatricula(Integer.parseInt(request.getParameter("matricula")));
		String codigoUsuario = request.getParameter("id");
		
		List<Usuario> usuarios = new ArrayList<>();
		
		if(codigoUsuario == null || codigoUsuario.isEmpty())  {
			dao.addUsuario(usuario);
			usuarios = dao.consultarTodos();
		}else {
			usuario.setId(Integer.parseInt(codigoUsuario));
			dao.updateUsuario(usuario);
			usuarios = dao.consultarTodos();
		}
		
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher view = request.getRequestDispatcher(LISTAR_USUARIOS);
		view.forward(request, response);
	}

}
