package br.anderson.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@RequestScoped
@ManagedBean(name = "pessoa")
public class Pessoa {

	private String nome;
	private int idade;
	private String sexo;

	List<Pessoa> lista = new ArrayList<Pessoa>();

	public List<Pessoa> preenchePessoa() {

		return lista;
	}

	@PostConstruct
	public void init() {
		
		nome = "Anderson Rosa";
		idade = 25;
		sexo = "Masculino";
		
		Pessoa p = new Pessoa();
		p.setNome("Anderson Rosa ");
		p.setIdade(25);
		p.setSexo("Masculino");
		lista.add(p);

		System.out.println("Passou pelo init com sucesso!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
