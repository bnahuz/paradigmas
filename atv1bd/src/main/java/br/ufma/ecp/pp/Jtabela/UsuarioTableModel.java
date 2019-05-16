package br.ufma.ecp.pp.Jtabela;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.ufma.ecp.pp.dados.atv1bd.*;

public class UsuarioTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	UsuarioDAO dao;
	List<Usuario> dados;
	List<String> colunas = Arrays.asList("Id","Nome","Email","Usuário","Senha");

	public UsuarioTableModel(UsuarioDAO dao) {
		this.dao = dao;
		dados = dao.recover();
		this.addTableModelListener((ev) -> {
			int i = ev.getFirstRow();
			Usuario usuario = dados.get(i);
			dao.atualiza(usuario);
		});
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.size();
	}
	
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Usuario user = dados.get(row);
		switch (col) {
		case 0 :
			return user.getId();
		case 1 :
			return user.getNome();
		case 2 :
			return user.getEmail();
		case 3 :
			return user.getUsuario();
		case 4:
			return user.getSenha();
		default:
			throw new IndexOutOfBoundsException("");
		}
	}

	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return colunas.get(col);
	}
	
	public boolean isCellEditable(int row, int col) {
		return col != 0;
	}
	
	public void setValueAt(Object obj, int row, int col) {
		Usuario u = dados.get(row);
		switch (col) {
		case 0:
			u.setId((String) obj);
			break;
		case 1:
			u.setNome((String) obj);
			break;
		case 2:
			u.setEmail((String) obj);
			break;
		case 3:
			u.setUsuario((String) obj);
			break;
		case 4:
			u.setSenha((String) obj);
			break;
		default:
			throw new IndexOutOfBoundsException("");
		}
		
		fireTableCellUpdated(row,col);
	}
}
