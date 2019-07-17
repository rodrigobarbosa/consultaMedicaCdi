/**
 * 
 */
package br.com.consultemed.dao;

import java.util.Collection;

import br.com.consultemed.model.Contato;


/**
 * @author carlosbarbosagomesfilho
 *
 */
public interface IContatoDao extends GenericDao<Contato, Long> {

	public void save(Contato contato) throws Exception;
	
	public Contato findById(Long id) throws Exception;
	
	public void deleteById(Long id) throws Exception;
	
	public void update(Contato contato) throws Exception;
	
	public Collection<Contato> listAll() throws Exception;
	
	public int countContato() throws Exception;
}
