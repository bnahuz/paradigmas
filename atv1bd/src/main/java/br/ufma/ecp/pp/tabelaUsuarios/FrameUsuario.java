package br.ufma.ecp.pp.tabelaUsuarios;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.ufma.ecp.pp.dados.atv1bd.UsuarioDAO;

@SuppressWarnings("serial")
public class FrameUsuario extends JFrame {
	
	public FrameUsuario (UsuarioDAO dao) {
		super("Lista de usuarios");
		
		JTable table = new JTable(new UsuarioTableModel(dao));
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		add(scroll);
		setSize(300,200);
	}
}
