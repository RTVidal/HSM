package hsm.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hsm.modelo.Matricula;
import hsm.servico.MatriculaServico;

@Controller("turmaBean")
@Scope("session")
public class TurmaBean implements Serializable
{	
	private static final long serialVersionUID = 1557905709340838149L;
	
	private List<Matricula> matriculas;
	private List<Matricula> matriculasInseridas;
	
	@Autowired
	private MatriculaServico matriculaServico;
	
	public void iniciarBean()
	{
		matriculas = matriculaServico.listarTodasAtivas();
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Matricula> getMatriculasInseridas() {
		return matriculasInseridas;
	}

	public void setMatriculasInseridas(List<Matricula> matriculasInseridas) {
		this.matriculasInseridas = matriculasInseridas;
	}
	
}
