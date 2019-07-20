package br.com.consultemed.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name = "Paciente.findAllCount", query = "SELECT COUNT(p) FROM Paciente p"),
	@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
})
@Entity
@Table(name="TB_PACIENTES")
public class Paciente extends AbstractEntity<Long>{
	
	private String nome;
	
	private String cpf;
	
	private String identificacao;
	
	public Paciente() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
}
