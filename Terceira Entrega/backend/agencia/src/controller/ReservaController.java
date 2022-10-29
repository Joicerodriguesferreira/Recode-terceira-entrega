package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Reserva;
import util.Conexao;

public class ReservaController {

	Connection conn = null;
	PreparedStatement pstm = null;
	
	
	public void save(Reserva reserva) {

		String sql = "INSERT INTO reserva(cliente, passagem)" + " VALUES(?,?)";

		try {

			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, reserva.getCliente());
			pstm.setString(2, reserva.getPassagem());
		
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

		String sql = "DELETE FROM reserva WHERE id_reserva = ?";

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

	
	public void update(Reserva reserva) {

		String sql = "UPDATE reserva SET cliente = ?, passagem = ?" + " WHERE id_reserva = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, reserva.getCliente());
			pstm.setString(2, reserva.getPassagem());
			pstm.setString(2, reserva.getId_reserva());
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

	
	public List<Reserva> getReserva() {

		String sql = "SELECT * FROM reserva";

		List<Reserva> reserva = new ArrayList<>();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Reserva a = new Reserva();

				a.setId_reserva(0);
				a.setCliente(rset.getString("cliente"));
				a.setPassagem(rset.getString("passagem"));
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

	public Reserva getReservaId(int id) {
		String sql = "SELECT * FROM reserva where id_reserva = ?";
		Cliente reserva = new Reserva();
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			reserva.setCliente(rset.getString("cliente"));
			reserva.setPassagem(rset.getString("passagem"));

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
		return reserva;
	}

}
