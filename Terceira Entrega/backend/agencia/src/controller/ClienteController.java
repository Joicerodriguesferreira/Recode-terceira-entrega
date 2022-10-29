package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import util.Conexao;

public class ClienteController {

	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	public void save(Cliente cliente) {

		String sql = "INSERT INTO cliente(nome, cpf, telefone,dataNascim)" + " VALUES(?,?,?,:)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, aluno.getTelefone());
			pstm.setString(4, aluno.getDataNascim());
			pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void removeById(int id) {

		String sql = "DELETE FROM cliente WHERE id_cliente = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	
	public void update(Cliente cliente) {

		String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, dataNascim = ?" + " WHERE id_cliente = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getTelefone());
			pstm.setString(4, cliente.getDataNascim());
			pstm.setInt(2, cliente.getId_cliente());
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	
	public List<Cliente> getCliente() {

		String sql = "SELECT * FROM cliente";

		List<Cliente> cliente = new ArrayList<>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Cliente a = new Cliente();

				a.setId_cliente(0);
				a.setNome(rset.getString("nome"));
				a.setCpf(rset.getString("cpf"));
				a.setTelefone(rset.getString("telefone"));
				a.setDataNascim(rset.getString("DataNascim"));
			    Cliente.add(a);	
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return cliente;

	}

	public Cliente getClienteId(int id) {
		String sql = "SELECT * FROM cliente where id_cliente = ?";
		Cliente cliente = new Cliente();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			cliente.setNome(rset.getString("nome"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setTelefone(rset.getString("telefone"));
			cliente.setDataNascim(rset.getString("dataNascim"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cliente;
	}

}
