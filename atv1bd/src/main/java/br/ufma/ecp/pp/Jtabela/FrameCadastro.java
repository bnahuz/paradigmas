package br.ufma.ecp.pp.Jtabela;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufma.ecp.pp.dados.atv1bd.Usuario;
import br.ufma.ecp.pp.dados.atv1bd.UsuarioDAO;

public class FrameCadastro extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtNome;
	public JTextField txtEmail;
	public JTextField txtUsuario;
	public JTextField txtSenha;
	protected UsuarioDAO dao;
	
	public FrameCadastro (UsuarioDAO dao) {
		
		super("Cadastro de usuario");
		setSize(300,225);
		setLayout(new FlowLayout());
		
		JPanel panNome = new JPanel(new FlowLayout());
		panNome.add(new JLabel("Nome:"));
		txtNome = new JTextField(15);
		panNome.add(txtNome);
		
		JPanel panEmail = new JPanel(new FlowLayout());
		panEmail.add(new JLabel("Email:"));
		txtEmail = new JTextField(15);
		panEmail.add(txtEmail);
		
		JPanel panUsuario = new JPanel(new FlowLayout());
		panUsuario.add(new JLabel("Usuario:"));
		txtUsuario = new JTextField(15);
		panUsuario.add(txtUsuario);
		
		JPanel panSenha = new JPanel(new FlowLayout());
		panSenha.add(new JLabel("Senha:"));
		txtSenha = new JTextField(15);
		panSenha.add(txtSenha);
		
		add(panNome);
		add(panEmail);
		add(panUsuario);
		add(panSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener( (e) -> {
			JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
			Usuario usuario = new Usuario(null,
								txtNome.getText(),
								txtEmail.getText(),
								txtUsuario.getText(),
								txtSenha.getText());
			dao.add(usuario);
			dispose();
		});
		
		add(btnCadastrar);
	}
}
