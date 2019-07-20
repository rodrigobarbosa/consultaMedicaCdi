package br.com.consultemed.service;

import java.util.Collection;

import br.com.consultemed.model.Paciente;

public interface IPaciente {

	public void save(Paciente paciente);
	public void update(Paciente paciente);
	public Collection<Paciente> listAll();
	public Paciente findById(Long id);
	public void deleteById(Long id);
	
}
