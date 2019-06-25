package br.com.consultemed.service;

import java.util.List;

import br.com.consultemed.model.Contato;

public interface IContato {

	public void salvar(Contato contato);
	public void remover(Long idContato);
	public List<Contato> listarContatos();
	public void editar(Contato contato);
	public Contato buscaContatoId(Long idContato);
	public Contato buscaContatoNome(String nome);
	public Contato buscaContatoEmail(String email);
}
