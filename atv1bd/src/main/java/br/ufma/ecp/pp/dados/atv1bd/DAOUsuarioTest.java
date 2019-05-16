package br.ufma.ecp.pp.dados.atv1bd;

import java.sql.SQLException;
import java.util.List;

public class DAOUsuarioTest {

	public static void main(String[] args) throws SQLException {
		
		UsuarioDAO dao = new UsuarioDAO();
		//Usuario co = new Usuario(null,"Ana","anamariasl@live.com","machado","123456789");
		//dao.add(co);
		
		//Retorna os elementos do Banco de Dados
		List<Usuario> usuarios = dao.recover();
		for (Usuario c: usuarios) {
			System.out.println(c);
			
		}
	}

}
