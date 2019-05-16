package br.ufma.ecp.pp.Jtabela;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import br.ufma.ecp.pp.dados.atv1bd.*;

@SuppressWarnings("serial")
public class FramePrincipal extends JFrame {
	
	public FramePrincipal() {
		super("DAOUsuarioTest");
		setSize(300,100);
		
		UsuarioDAO dao = new UsuarioDAO();
		
		
		// Botão para Cadastrar um novo usuário;
		JButton btnCadastro = new JButton("Cadastra Usuario");
		btnCadastro.addActionListener((ev) -> {
				FrameCadastro frame = new FrameCadastro(dao);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		});
		
		// Botão para listar usuários;
		JButton btnLista = new JButton("Lista Usuario");
		btnLista.addActionListener((ev) -> {
				FrameUsuario frame = new FrameUsuario(dao);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		});
		
		setLayout(new FlowLayout());
		add(btnCadastro);
		add(btnLista);
	}
	
}
