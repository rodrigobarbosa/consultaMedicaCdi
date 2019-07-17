/**
 * 
 */
package br.com.consultemed.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@SuppressWarnings("serial")
@NamedQueries({
	@NamedQuery(name = "Contato.findAllCount", query = "SELECT COUNT(c) FROM Contato c"),
	@NamedQuery(name="Contato.findAll", query="SELECT c FROM Contato c")
})
@Entity
@Table(name="TB_CONTATOS")
public class Contato extends AbstractEntity<Long> {

	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	public Contato() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
