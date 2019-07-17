/**
 * 
 */
package br.com.consultemed.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author carlosbarbosagomesfilho
 *
 *         //
 */
@NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s")
@Entity
@Table(name = "solicitacoes")
public class Solicitacao implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String login;

	private String senha;

	private boolean ativo;

	private Boolean visitante = false;

	private Boolean administrador = false;

	private Boolean situacao = false;

	public Solicitacao() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isVisitante() {
		return visitante;
	}

	public void setVisitante(Boolean visitante) {
		this.visitante = visitante;
	}

	public Boolean getVisitante() {
		return visitante;
	}

	public Boolean getSituacao() {
		return situacao;
	}

	public void setSituacao(Boolean situacao) {
		this.situacao = situacao;
	}

	public Boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}

}
