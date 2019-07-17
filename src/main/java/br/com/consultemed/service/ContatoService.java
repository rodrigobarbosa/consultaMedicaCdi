/**
 * 
 */
package br.com.consultemed.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.dao.ContatoDAO;
import br.com.consultemed.model.Contato;

/**
 * @author carlosbarbosagomesfilho Classe responável pelas regras de negócio da
 *         entidade contato.
 */
public class ContatoService implements IContato, Serializable {

	@Inject
	private ContatoDAO dao;
	

	@Override
	public void salvar(Contato contato) {
		this.dao.salvar(contato);
	}

	@Override
	public void remover(Long idContato) {

	}

	@Override
	public List<Contato> listarContatos() {
		return this.dao.contatos();
	}

	@Override
	public void editar(Contato contato) {
		this.dao.editar(contato);
	}

	@Override
	public Contato buscaContatoNome(String nome) {
		return this.dao.buscaPorNome(nome);
	}

	@Override
	public Contato buscaContatoEmail(String email) {
		return this.dao.buscaPorEmail(email);
	}

	@Override
	public Contato buscaContatoId(Long idContato) {
		return this.dao.buscaPorId(idContato);
	}

	public ContatoDAO getDao() {
		return dao;
	}

	public void setDao(ContatoDAO dao) {
		this.dao = dao;
	}
	

}
