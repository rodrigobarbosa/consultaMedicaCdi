/**
 * 
 */
package br.com.consultemed.controller;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import br.com.consultemed.service.ContatoService;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@WebServlet("/contatos")
public class ContatoController extends HttpServlet {

	@Inject
	public ContatoService service;
	
	public void init() {
		this.service.listarContatos();
	}

	public ContatoService getService() {
		return service;
	}

	public void setService(ContatoService service) {
		this.service = service;
	}
	
	
	
}
