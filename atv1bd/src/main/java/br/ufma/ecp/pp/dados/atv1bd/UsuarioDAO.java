package br.ufma.ecp.pp.dados.atv1bd;
	
// Classe DAO(Data Access Object)
// Ver fim dá página @Override em recovery
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO implements AbstractDAO<Usuario> {
	
	private Connection conn;
	
	public UsuarioDAO() {//throws SQLException {
		String url = "jdbc:mysql://localhost:3306/bancoteste";
		String userName = "root";
		String password = "bnahuztest";
		try {
			conn = DriverManager.getConnection(url, userName, password);
			Statement statement = conn.createStatement();
			
			statement.execute("CREATE TABLE IF NOT EXISTS usuario(id INT NOT NULL AUTO_INCREMENT, nome VARCHAR(30), email VARCHAR(50), usuario VARCHAR(10), senha VARCHAR(16), PRIMARY KEY(id))");
		} 
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void add(Usuario user) { 
		
		String sql = "INSERT INTO usuario(nome,email,usuario,senha) VALUES(?,?,?,?)";
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql); 
			//stmt.setString(1, null);
			stmt.setString(1, user.getNome()); 
			stmt.setString(2, user.getEmail()); 
			stmt.setString(3, user.getUsuario());
			stmt.setString(4, user.getSenha());
			stmt.execute(); 
			stmt.close(); 
		} 
		catch (SQLException u) {
			throw new RuntimeException(u);
		} 

	}
	
	public List<Usuario> recover () {
		List<Usuario> usuarios = new LinkedList<Usuario>();
 		String sql = "select * from usuario"; 
		try { 
			PreparedStatement stmt = conn.prepareStatement(sql); 
			ResultSet rs = stmt.executeQuery(); 
			
			while (rs.next()) { 
				Usuario c = new Usuario();
				c.setId(rs.getString("id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setUsuario(rs.getString("usuario"));
				c.setSenha(rs.getString("senha"));
				usuarios.add(c);
			} 
			stmt.close(); 
		}
		catch (SQLException u) { 
			throw new RuntimeException(u);
		}
		return usuarios;
	}
	
	public void atualiza (Usuario usuario) {
		String sqlUpdate = "UPDATE usuario SET nome=?, email=?, usuario=?, senha=?"
										+ "WHERE id=?";
		try { 
			PreparedStatement stmt = conn.prepareStatement(sqlUpdate); 
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getUsuario());
			stmt.setString(4, usuario.getSenha());
			stmt.setString(5, usuario.getId());
			stmt.execute();
			stmt.close(); 
		}
		catch (SQLException u) { 
			u.printStackTrace();
		}
	}

}

