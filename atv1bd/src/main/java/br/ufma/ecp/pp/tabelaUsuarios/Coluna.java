package br.ufma.ecp.pp.tabelaUsuarios;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Coluna {
	
	String nome();
	
	int pos();
}
