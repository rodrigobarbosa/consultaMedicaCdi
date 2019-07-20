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

import br.com.consultemed.model.Contato;
import br.com.consultemed.service.ContatoBusiness;
import br.com.consultemed.utils.Constantes;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/admin/contatos")
public class ContatoController extends HttpServlet {

	private static final String ID_USUARIO = "id";

	private static final String TELEFONE_USUARIO = "telefone";

	private static final String EMAIL_USUARIO = "email";

	private static final String NOME_USUARIO = "nome";

	@Inject
	private ContatoBusiness business;

	private static final long serialVersionUID = 1L;

	public ContatoController() {
		this.business = new ContatoBusiness();
	}

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
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.CONTATOS);
		Collection<Contato> contatos = this.business.listAll();
		request.setAttribute("contatos", contatos);
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
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_CONTATOS);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter(NOME_USUARIO);
		String email = request.getParameter(EMAIL_USUARIO);
		String telefone = request.getParameter(TELEFONE_USUARIO);
		String id = request.getParameter(ID_USUARIO);
		
			
		Contato contato = new Contato();
		contato.setEmail(email);
		contato.setNome(nome);
		contato.setTelefone(telefone);
		
		if(id != "") {
			contato.setId(Long.parseLong(id));
			request.setAttribute("editado", Constantes.CONTATO + " " + nome + Constantes.CONTATO_EDITADO);
		}else {
			request.setAttribute("cadastro", Constantes.CONTATO + " "+ nome + Constantes.CONTATO_SUCESSO);			
		}
		try {
			this.business.save(contato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			list(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		
		this.business.deleteById(Long.parseLong(request.getParameter(ID_USUARIO)));
		request.setAttribute("remover", Constantes.CONTATO + Constantes.CONTATO_REMOVIDO);
		
		try {
			list(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		Contato contato = this.business.findById(Long.parseLong(request.getParameter(ID_USUARIO)));
		RequestDispatcher rd = request.getRequestDispatcher(Constantes.ADD_CONTATOS);
		request.setAttribute("contato", contato);
		rd.forward(request, response);
	}

}
