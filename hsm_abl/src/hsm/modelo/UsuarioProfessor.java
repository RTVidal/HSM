package hsm.modelo;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
		@NamedQuery(name = UsuarioProfessor.LISTAR_TODOS, query = UsuarioProfessor.LISTAR_TODOS)
		)
public class UsuarioProfessor extends Usuario {

	private static final long serialVersionUID = 5210949826193020716L;

	public static final String LISTAR_TODOS = "from UsuarioProfessor";

	private String grauInstrucao;

	public String getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}
}
