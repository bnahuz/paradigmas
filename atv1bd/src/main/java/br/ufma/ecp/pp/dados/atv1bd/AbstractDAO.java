package br.ufma.ecp.pp.dados.atv1bd;

import java.util.List;

import br.ufma.ecp.pp.dados.atv1bd.Usuario;

public interface AbstractDAO<T> {
	
	List<T> recover();
	
	void atualiza(T obj);
	
	void add(T obj);
	
}
