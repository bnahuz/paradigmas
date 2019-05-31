package br.ufma.ecp.pp.tabelaUsuarios;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.ufma.ecp.pp.dados.atv1bd.AbstractDAO;
import br.ufma.ecp.pp.dados.atv1bd.Usuario;

@SuppressWarnings("serial")
public class GenericTableModel<T> extends AbstractTableModel{
	
	AbstractDAO dao;
	List<T> dados;
	List<String> colunas = Arrays.asList("Id", "Nome", "Email", "Usuário", "Senha");

	public GenericTableModel (AbstractDAO dao) {
		this.dao = dao;

		dados = dao.recover();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		T c = dados.get(row);
		switch  (col) {
		case 0 :
			return ((Usuario) c).getId();
		case 1:
			return ((Usuario) c).getNome();
		case 2:
			return ((Usuario) c).getEmail();
		case 3:
			return ((Usuario) c).getUsuario();
		case 4:
			return ((Usuario) c).getSenha();
		default:
			throw new IndexOutOfBoundsException ("");

		}
	}



	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return colunas.get(col);
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		// TODO Auto-generated method stub
		return col != 0;
	}

	@Override
	public void setValueAt(Object obj, int row, int col) {
		// TODO Auto-generated method stub
		Usuario c = (Usuario) dados.get(row);
		switch  (col) {
		case 0:
			c.setId((String) obj);
			break;
		case 1:
			c.setNome((String) obj);
			break;
		case 2:
			c.setEmail((String) obj);
			break;
		case 3:
			c.setUsuario((String) obj);
			break;
		case 4:
			c.setSenha((String) obj);
			break;
		default:
			throw new IndexOutOfBoundsException("");
		}
		
		fireTableCellUpdated(row,col);
	}




}