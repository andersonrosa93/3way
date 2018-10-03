package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Livro;
import br.com.util.FabricaConexao;

public class LivroDao {
	public static final String CONSULTAR_LIVRO_CODIGO = "SELECT COD_LIVRO, TITULO, AUTOR, PRECO, IMAGEM, DESCRICAO FROM LIVRO WHERE COD_LIVRO = ?";
	public static final String CONSULTAR_TODOS_LIVROS = "SELECT * FROM LIVRO ORDER BY COD_LIVRO";
	public static final String CONSULTAR_LIVROS = "SELECT COD_LIVRO, TITULO, AUTOR, PRECO, IMAGEM, DESCRICAO FROM LIVRO WHERE TITULO ILIKE ?";
	public static final String UPDATE_LIVRO_CODIGO = "UPDATE LIVRO SET TITULO = ?, AUTOR = ?, DESCRICAO = ?, PRECO = ? WHERE COD_LIVRO = ?";
	public static final String ADICIONAR_LIVRO = "INSERT INTO LIVRO(TITULO, AUTOR, PRECO, DESCRICAO, IMAGEM)" + " VALUES(?,?,?,?,?)";
	public static final String REMOVER_LIVRO_CODIGO = "DELETE FROM LIVRO WHERE COD_LIVRO = ?";
	
	
	public List<Livro> consultarLivros(String titulo) {

		// criei uma lista de livros.
		List<Livro> lista = new ArrayList<Livro>();

		// abrindo conexão com banco e passando o sql
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_LIVROS);) {
			consulta.setString(1, "%" + titulo.toUpperCase() + "%");

			// salvando na variavel o resultado da consulta do sql.
			ResultSet resultado = consulta.executeQuery();

			// passando na lista com while, enquanto for verdadeiro.
			while (resultado.next()) {
				/* Cria um objeto para armazenar uma linha da consulta */
				Livro linha = new Livro();
				linha.setCodigo(resultado.getInt("cod_livro"));
				linha.setAutor(resultado.getString("autor"));
				linha.setImagem(resultado.getString("imagem"));
				linha.setPreco(resultado.getDouble("preco"));
				linha.setTitulo(resultado.getString("titulo"));
				linha.setDescricao(resultado.getString("descricao"));

				/* Armazena a linha lida em uma lista */
				
				lista.add(linha);

			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
			
	public Livro consultarCodigo(int codigo) {

		Livro livro = null;

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_LIVRO_CODIGO);) {
			consulta.setInt(1, codigo);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				livro = new Livro();
				livro.setAutor(resultado.getString("autor"));
				livro.setCodigo(resultado.getInt("cod_livro"));
				livro.setImagem(resultado.getString("imagem"));
				livro.setPreco(resultado.getDouble("preco"));
				livro.setTitulo(resultado.getString("titulo"));
				livro.setDescricao(resultado.getString("descricao"));
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livro;

	}

	public List<Livro> consultarTodos() {

		// criei uma lista de livros.
		List<Livro> lista = new ArrayList<Livro>();

		// abrindo conexão com banco e passando o sql
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_TODOS_LIVROS);) {

			// salvando na variavel o resultado da consulta do sql.
			ResultSet resultado = consulta.executeQuery();

			// passando na lista com while, enquanto for verdadeiro.
			while (resultado.next()) {
				/* Cria um objeto para armazenar uma linha da consulta */
				Livro linha = new Livro();
				linha.setCodigo(resultado.getInt("cod_livro"));
				linha.setAutor(resultado.getString("autor"));
				linha.setImagem(resultado.getString("imagem"));
				linha.setPreco(resultado.getDouble("preco"));
				linha.setTitulo(resultado.getString("titulo"));
				linha.setDescricao(resultado.getString("descricao"));

				/* Armazena a linha lida em uma lista */
				lista.add(linha);
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}

	public void updateLivro(Livro livro) {

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(UPDATE_LIVRO_CODIGO);) {

			consulta.setString(1, livro.getTitulo());
			consulta.setString(2, livro.getAutor());
			consulta.setString(3, livro.getDescricao());
			consulta.setDouble(4, livro.getPreco());
			consulta.setInt(5, livro.getCodigo());

			consulta.execute();
			System.out.println("Livro alterado com successo.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addLivro(Livro livro) {
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(ADICIONAR_LIVRO);) {

			consulta.setString(1, livro.getTitulo());
			consulta.setString(2, livro.getAutor());
			consulta.setDouble(3, livro.getPreco());
			consulta.setString(4, livro.getDescricao());
			consulta.setString(5, livro.getImagem());

			consulta.execute();
			System.out.println("Livro adicionado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeLivro(int codigo) {

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(REMOVER_LIVRO_CODIGO);) {

			consulta.setInt(1, codigo);
			consulta.execute();
			System.out.println("Livro removido com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
