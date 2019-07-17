/**
 * 
 */
package br.com.consultemed.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.consultemed.model.Solicitacao;
import br.com.consultemed.utils.JPAUtils;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class SolicitacaoDaoImpl implements ISolicitacaoDao {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = null;

	public void save(Solicitacao solicitacao) throws Exception  {

		this.factory = emf.createEntityManager();

		try {
			factory.getTransaction().begin();
			factory.persist(solicitacao);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
		} finally {
			factory.close();
		}
	}
	
	@Override
	public Solicitacao ativarDesativar(Long id) throws Exception {
		Solicitacao solicitacao = this.findById(id);
		if(solicitacao.isAtivo()) {
			solicitacao.setAtivo(false);
		}else {
			solicitacao.setAtivo(true);
		}
		this.save(solicitacao);
		return solicitacao;
	}
	

	public Solicitacao findById(Long id) throws Exception  {
		this.factory = emf.createEntityManager();
		Solicitacao solicitacao = new Solicitacao();
		try {
			solicitacao = factory.find(Solicitacao.class, id);
			return solicitacao;

		} catch (Exception e) {
			e.getMessage();

		} finally {
			factory.close();
		}
		return null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		this.factory = emf.createEntityManager();
		Solicitacao solicitacao = new Solicitacao();

		try {

			solicitacao = factory.find(Solicitacao.class, id);
			factory.getTransaction().begin();
			factory.remove(solicitacao);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();

		} finally {
			factory.close();
		}

	}

	@Override
	public void update(Solicitacao solicitacao) throws Exception {
		this.factory = emf.createEntityManager();

		try {
			factory.getTransaction().begin();
			factory.merge(solicitacao);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
		} finally {
			factory.close();
		}
	}

	@Override
	public Collection<Solicitacao> listAll() throws Exception {
		this.factory = emf.createEntityManager();
		List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
		
		try {
			factory.getTransaction().begin();
			TypedQuery<Solicitacao> query = factory.createNamedQuery("Solicitacao.findAll", Solicitacao.class);
			solicitacoes = query.getResultList();
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
		} finally {
			factory.close();
		}

		return solicitacoes;
	}

	@Override
	public Solicitacao acess(String login, String senha) throws Exception {
		
		Solicitacao solicitacao = null;
		this.factory = emf.createEntityManager();
		
		try {
			
			Query query = this.factory.createNamedQuery("Solicitacao.loginSolicitacao");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			solicitacao = (Solicitacao) query.getSingleResult();
			
			return solicitacao;
					
		} catch (Exception e) {
			e.getMessage();
		}
		
		return solicitacao;
	}

}
