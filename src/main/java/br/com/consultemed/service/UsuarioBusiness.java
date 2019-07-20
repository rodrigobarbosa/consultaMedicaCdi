/**
 * 
 */
package br.com.consultemed.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.consultemed.dao.UsuarioDaoImpl;
import br.com.consultemed.model.Usuario;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class UsuarioBusiness {

	@Inject
	private UsuarioDaoImpl dao;

	public UsuarioBusiness() {
		this.dao = new UsuarioDaoImpl();
	}
	
	public void save(Usuario usuario) throws Exception  {
		this.dao.save(usuario);
	}
	
	public void update(Usuario usuario) throws Exception  {
		this.dao.update(usuario);
	}
	
	public Collection<Usuario> listAll() throws Exception {
		return this.dao.listAll();
	}
	
	public Usuario findById(Long id) throws Exception {
		return this.dao.findById(id);
	}
	
	public void deleteById(Long id) throws Exception {
		this.dao.deleteById(id);
	}
	
	public Usuario ativarDesativar (Long id) throws Exception {
		return this.dao.ativarDesativar(id);
	}
	
	public Usuario findByLogin(String nome) throws Exception {
		return this.dao.findByLogin(nome);
		
	}
	
	public Usuario acess(String login, String senha) throws Exception {
		return this.dao.acess(login, senha);
	}
}
