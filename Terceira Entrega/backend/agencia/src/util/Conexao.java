package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private static final String url = "jdbc:mysql://localhost:3306/agencia?verifyServerCertificate=false&useSSL=true";
	private static final String usuario = "root";
	private static final String senha = "91336757";

	
	public static Connection createConnectionToMySQL() throws Exception{
		Connection connection = DriverManager.getConnection(url, usuario, senha);
		return  connection;
	}
}