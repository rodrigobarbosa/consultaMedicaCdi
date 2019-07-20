package br.com.consultemed.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import br.com.consultemed.model.Paciente;
import br.com.consultemed.utils.JPAUtils;

public class PacienteDaoImpl implements IPacienteDao {

	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager factory = null;

	public void save(Paciente paciente) throws Exception  {

		this.factory = emf.createEntityManager();

		try {
			factory.getTransaction().begin();
			if (paciente.getCpf() == null) {
				factory.persist(paciente);
			} else {
				factory.merge(paciente);
			}
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
			
		} finally {
			factory.close();
		}
	}

	public Paciente findByCpf(Long cpf) throws Exception  {
		this.factory = emf.createEntityManager();
		Paciente paciente = new Paciente();
		try {
			paciente = factory.find(Paciente.class, cpf);
			return paciente;

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}
		return null;
	}

	public void deleteByCpf(Long cpf) throws Exception {
		this.factory = emf.createEntityManager();
		Paciente paciente = new Paciente();

		try {

			paciente = factory.find(Paciente.class, cpf);
			factory.getTransaction().begin();
			factory.remove(paciente);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

	}

	public void update(Paciente paciente) throws Exception {
		this.factory = emf.createEntityManager();

		try {
			factory.getTransaction().begin();
			factory.merge(paciente);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}
	}

	public Collection<Paciente> listAll() throws Exception {
		this.factory = emf.createEntityManager();
		List<Paciente> pacientes = new ArrayList<Paciente>();
		try {
			factory.getTransaction().begin();
			TypedQuery<Paciente> query = factory.createNamedQuery("Paciente.findAll", Paciente.class);
			pacientes = query.getResultList();
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

		return pacientes;
	}

	public int countPaciente() throws Exception {
		
		this.factory = emf.createEntityManager();
		int numPaciente = 0;
		
		try {
			factory.getTransaction().begin();
			 numPaciente = ((Number)this.factory.createNamedQuery("Paciente.findAllCount").getSingleResult()).intValue();
		     System.out.println(numPaciente);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}

		return numPaciente;
	}

	@Override
	public Paciente findById(Long id) throws Exception {
		this.factory = emf.createEntityManager();
		Paciente paciente = new Paciente();
		try {
			paciente = factory.find(Paciente.class, id);
			return paciente;

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}
		return null;
	}

	@Override
	public void deleteById(Long id) throws Exception {
		this.factory = emf.createEntityManager();
		Paciente paciente = new Paciente();

		try {

			paciente = factory.find(Paciente.class, id);
			factory.getTransaction().begin();
			factory.remove(paciente);
			factory.getTransaction().commit();

		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
		} finally {
			factory.close();
		}
	}
}
