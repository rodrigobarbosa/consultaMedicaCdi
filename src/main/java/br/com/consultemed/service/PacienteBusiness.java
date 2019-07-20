package br.com.consultemed.service;

import java.util.Collection;

import javax.inject.Inject;

import br.com.consultemed.dao.PacienteDaoImpl;
import br.com.consultemed.model.Paciente;

public class PacienteBusiness {

	@Inject
	private PacienteDaoImpl dao;

	public PacienteBusiness() {
		this.dao = new PacienteDaoImpl();
	}
	
	public void save(Paciente paciente) throws Exception  {
		this.dao.save(paciente);
	}
	
	public void update(Paciente paciente) throws Exception  {
		this.dao.update(paciente);
	}
	
	public Collection<Paciente> listAll() throws Exception {
		return this.dao.listAll();
	}
	
	public Paciente findById(Long id) throws Exception {
		return this.dao.findById(id);
	}
	
	public void deleteById(Long id) throws Exception {
		this.dao.deleteById(id);
	}
	
	public int conut() throws Exception {
		return this.dao.countPaciente();
	}
}
