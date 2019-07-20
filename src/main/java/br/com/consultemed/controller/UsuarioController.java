package br.com.consultemed.controller;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.consultemed.model.Usuario;
import br.com.consultemed.service.UsuarioBusiness;
import br.com.consultemed.utils.Constantes;
import br.com.consultemed.utils.Criptografia;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/admin/usuarios")
public class UsuarioController extends HttpServlet {

	@Inject
	private UsuarioBusiness business;

	private static final long serialVersionUID = 1L;

	public UsuarioController() {
		this.business = new UsuarioBusiness();
	}

	/**
	 * Metodo que verifica as requisições para o servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter(Constantes.ACTION);

		try {
			switch (action) {
			case Constantes.NOVO:
				novo(request, response);
				break;
			case Constantes.DELETE:
				delete(request, response);
				break;
			case Constantes.EDITAR:
				editar(request, response);
				break;
			case Constantes.LISTAR :
				list(request, response);
				break;
			case Constantes.ATIVAR_DESATIVAR:
				ativar_desativar(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * Metodo que ativa e desativa usuário do sistema
	 * @param request
	 * @param response
	 * @throws NumberFormatException
	 * @throws Exception
	 */
	private void ativar_desativar(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		Usuario usuario = this.business.ativarDesativar(Long.parseLong(request.getParameter("id")));
		request.setAttribute("usuario", usuario);
		list(request, response);
		
	}

	/**
	 * Metodo que lista todos os usuários da sistema
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.USUARIOS);
		Collection<Usuario> usuarios = this.business.listAll();
		request.setAttribute("usuarios", usuarios);
		rd.forward(request, response);
		
	}
	
	/**
	 * Metodo que remove um contato do banco de dados
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		this.business.deleteById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("remover", Constantes.USUARIO_REMOVIDO);
		list(request, response);
	}

	/**
	 * Metodo que edita um contato
	 * 
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	private void editar(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {

		Usuario usuario = this.business.findById(Long.parseLong(request.getParameter("id")));
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_USUARIOS);
		request.setAttribute("usuario", usuario);
		rd.forward(request, response);
	}

	/**
	 * Prepara formulário para cadastro de um novo contato
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void novo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_USUARIOS);
		rd.forward(request, response);
	}

	/**
	 * Cadastro de um novo contato
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		Usuario usuario = new Usuario();
		
		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		boolean isAtivo = Boolean.parseBoolean(request.getParameter("ativo")); 
		String [] permissoes = request.getParameterValues("permissoes");
		
		if(permissoes == null) {
			usuario.setAdministrador(false);
			usuario.setVisitante(false);
			
		}else {
			for (int i = 0; i < permissoes.length; i++) {
				if(permissoes[i].equals(Constantes.ADMINISTRADOR)) {
					usuario.setAdministrador(true);
				} else if (permissoes[i].equals(Constantes.VISITANTE)) {
					usuario.setVisitante(true);
				}
			}
		}
			
		usuario.setLogin(login);
		usuario.setNome(nome);
		usuario.setSenha(Criptografia.criptografar(senha));
		usuario.setTelefones(telefone);
		usuario.setEmail(email);
		usuario.setAtivo(isAtivo);
		
		
		if(id != "") {
			usuario.setId(Long.parseLong(id));
			request.setAttribute("editado", nome + " " +Constantes.USUARIO_EDITADO);
		}else {
			request.setAttribute("cadastro", nome + " " + Constantes.USUARIO_SUCESSO);			
		}
		
		try {
			this.business.save(usuario);
			list(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
