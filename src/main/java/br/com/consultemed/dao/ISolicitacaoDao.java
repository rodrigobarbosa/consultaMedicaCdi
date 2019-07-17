/**
 * 
 */
package br.com.consultemed.dao;

import java.util.Collection;

import br.com.consultemed.model.Solicitacao;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public interface ISolicitacaoDao extends GenericDao<Solicitacao, Long> {

	public void save(Solicitacao solicitacao) throws Exception;
	
	public Solicitacao findById(Long id) throws Exception;
	
	public void deleteById(Long id) throws Exception;
	
	public void update(Solicitacao solicitacao) throws Exception;
	
	public Collection<Solicitacao> listAll() throws Exception;
	
	public Solicitacao acess (String login, String senha) throws Exception;
	
	public Solicitacao ativarDesativar(Long id) throws Exception;
}
