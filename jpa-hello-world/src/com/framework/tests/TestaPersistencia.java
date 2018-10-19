package com.framework.tests;

import com.framework.dao.PessoaDao;
import com.framework.model.Pessoa;

public class TestaPersistencia {

	static PessoaDao pessoaDao = PessoaDao.getInstance();
	
	public static void main(String[] args) {
		
		incluirPessoa();
		

	}
	
	private static void incluirPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf("04864845434584");
		pessoa.setNome("Anderson");
		
		pessoaDao.persist(pessoa);
	}
	
}
