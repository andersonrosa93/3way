package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.model.Usuario;
import br.com.util.FabricaConexao;

public class UsuarioDao {

	public static final String CONSULTAR_TODOS_USUARIOS = "SELECT * FROM USUARIO ORDER BY ID";
	public static final String ADICIONAR_USUARIO = "INSERT INTO USUARIO(NOME, LOGIN, MATRICULA)" + " VALUES(?,?,?)";
	public static final String REMOVER_USUARIO_ID = "DELETE FROM USUARIO WHERE ID = ?";
	public static final String UPDATE_USUARIO_ID = "UPDATE USUARIO SET NOME = ?, LOGIN = ?, MATRICULA = ? WHERE ID = ?";
	public static final String CONSULTAR_USUARIO_ID = "SELECT ID, NOME, LOGIN, MATRICULA FROM USUARIO WHERE ID = ?";
	
	
			

	public List<Usuario> consultarTodos() {

		// criei uma lista de livros.
		List<Usuario> lista = new ArrayList<Usuario>();

		// abrindo conexão com banco e passando o sql
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_TODOS_USUARIOS);) {

			// salvando na variavel o resultado da consulta do sql.
			ResultSet resultado = consulta.executeQuery();

			// passando na lista com while, enquanto for verdadeiro.
			while (resultado.next()) {
				/* Cria um objeto para armazenar uma linha da consulta */
				Usuario linha = new Usuario();
				linha.setId(resultado.getInt("id"));
				linha.setNome(resultado.getString("nome"));
				linha.setLogin(resultado.getString("login"));
				linha.setMatricula(Integer.parseInt(resultado.getString("matricula")));

				/* Armazena a linha lida em uma lista */
				lista.add(linha);
			}

			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lista;
	}
	
	public Usuario consultarId(int id) {

		Usuario usuario = null;

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(CONSULTAR_USUARIO_ID);) {
			consulta.setInt(1, id);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {
				usuario = new Usuario();
				usuario.setNome(resultado.getString("nome"));
				usuario.setId(resultado.getInt("id"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setMatricula(resultado.getInt("matricula"));
			}
			resultado.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;

	}


	public void addUsuario(Usuario usuario) {
		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(ADICIONAR_USUARIO);) {

			consulta.setString(1, usuario.getNome());
			consulta.setString(2, usuario.getLogin());
			consulta.setInt(3, usuario.getMatricula());

			consulta.execute();
			System.out.println("Usuario adicionado com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUsuario(Usuario usuario) {

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(UPDATE_USUARIO_ID);) {

			consulta.setString(1, usuario.getNome());
			consulta.setString(2, usuario.getLogin());
			consulta.setInt(3, usuario.getMatricula());
			consulta.setInt(4, usuario.getId());
			
			consulta.execute();
			System.out.println("Usuario alterado com successo.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeUsuario(int id) {

		try (Connection conexao = FabricaConexao.getConexao();
				PreparedStatement consulta = conexao.prepareStatement(REMOVER_USUARIO_ID);) {

			consulta.setInt(1, id);
			consulta.execute();
			System.out.println("Usuario removido com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
