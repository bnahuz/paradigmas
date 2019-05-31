package br.ufma.ecp.pp.dados.atv1bd;

import java.util.Arrays;
import java.util.List;

public class EventoDAO {

	public List<Evento> recover() {
		
		List<Evento> lista = Arrays.asList(
			new Evento ("12", "JIM 2018", 2018),
			new Evento ("34", "Eacomp 2016", 2016)
		);
		return lista;
		

	}

	public void atualiza(Evento obj) {
		// TODO Auto-generated method stub
		
	}

	public void add(Evento obj) {
		// TODO Auto-generated method stub
		
	}
	

}
