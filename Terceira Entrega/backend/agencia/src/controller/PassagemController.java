package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Passagem;
import util.Conexao;

public class PassagemController {

	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	public void save(Passagem passagem) {

		String sql = "INSERT INTO passagem(data, destino, quantidade, valor, cliente)" + " VALUES(?,?,?,?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, passagem.getData());
			pstm.setString(2, passagem.getDestino());
            pstm.setString(3, passagem.getQuantidade());
			pstm.setString(2, passagem.getValor());
            pstm.setString(1, passagem.getCliente());
        
			
		
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

		String sql = "DELETE FROM passagem WHERE id_passagem = ?";

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

	
	public void update(Passagem passagem) {

		String sql = "UPDATE passagem SET data = ?, destino = ?, quantidade = ?, valor = ?, cliente = ?" + " WHERE id_passagem = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, passagem.getData());
			pstm.setString(2, passagem.getDestino());
            pstm.setString(3, passagem.getQuantidade());
            pstm.setString(4, passagem.getValor());
            pstm.setString(5, passagem.getCliente());
			pstm.setString(2, passagem.getId_passagem());
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

	
	public List<Passagem> getPassagem() {

		String sql = "SELECT * FROM passagem";

		List<Passagem> passagem = new ArrayList<>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Passagem a = new Passagem();

				a.setId_passagem(0);
				a.setData(rset.getString("data"));
				a.setDestino(rset.getString("destino"));
                a.setQuantidade(rset.getString("quantidade"));
				a.setValor(rset.getString("valor"));
                a.setDCliente(rset.getString("cliente"));
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

	public Passagem getPassagemId(int id) {
		String sql = "SELECT * FROM passagem where id_passagem = ?";
		Passagem passagem= new Passagem();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			passagem.setData(rset.getString("data"));
			passagem.setDestino(rset.getString("destino"));
            passagem.setQuantidade(rset.getString("quantidade"));
			passagem.setvalor(rset.getString("valor"));
            passagem.setCliente(rset.getString("cliente"));

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
		return passagem;
	}

}
