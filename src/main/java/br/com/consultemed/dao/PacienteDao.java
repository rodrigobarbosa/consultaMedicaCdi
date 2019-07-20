package br.com.consultemed.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import br.com.consultemed.model.Paciente;
import br.com.consultemed.utils.JPAUtils;

public class PacienteDao implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = emf.createEntityManager();

	public void salvar(Paciente paciente) {
		this.factory.getTransaction().begin();
		this.factory.persist(paciente);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public void remover(Long idPaciente) {
		
		this.factory.getTransaction().begin();
		this.factory.remove(buscaPorId(idPaciente));
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public Paciente buscaPorId(Long id) {
		this.factory.getTransaction().begin();
		Paciente pacienteRemover = this.factory.find(Paciente.class, id);
		return pacienteRemover;
	}
	
	public Paciente buscaPorNome(String nome) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT p FROM Paciente p WHERE p.nome = :nome");
		query.setParameter("nome", nome);
		Paciente paciente = (Paciente) query.getSingleResult();
		return paciente;
	}
	
	
	public Paciente buscaPorCpf(String cpf) {
		this.factory.getTransaction().begin();
		Query query = 
				this.factory.createQuery("SELECT p FROM Paciente p WHERE p.cpf = :cpf" );
		query.setParameter("cpf", cpf);
		Paciente paciente = (Paciente) query.getSingleResult();
		return paciente;
	}
	
	public void editar(Paciente paciente) {
		this.factory.getTransaction().begin();
		this.factory.merge(paciente);
		this.factory.getTransaction().commit();
		this.factory.close();
	}
	
	public List<Paciente> pacientes(){
		this.factory.getTransaction().begin();
		Query query = this.factory.createQuery("SELECT p FROM Paciente p");
		List<Paciente> pacientes = query.getResultList(); 
		for (Paciente paciente : pacientes) {
			System.out.println(paciente.getNome());
		}
		
		this.factory.close();
		return pacientes;
	}
}
