package hsm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hsm.modelo.Aluno;
import hsm.modelo.Curso;
import hsm.modelo.Matricula;
import hsm.servico.AlunoServico;
import hsm.servico.CursoServico;
import hsm.servico.MatriculaServico;

@Controller("matriculaBean")
@Scope("session")
public class MatriculaBean implements Serializable {

	private static final long serialVersionUID = 3206093015403665109L;

	private Matricula matricula;
	private List<Matricula> matriculas;
	private List<Aluno> alunos;
	private List<Curso> cursos;

	@Autowired
	private MatriculaServico matriculaServico;

	@Autowired
	private AlunoServico alunoServico;

	@Autowired
	private CursoServico cursoServico;

	public void iniciarBean() {
		atualizarMatriculas();
		alunos = alunoServico.listarTodos();
		cursos = cursoServico.listarTodos();
	}

	public void salvar() {
		matriculaServico.salvar(matricula);
		atualizarMatriculas();
		matricula = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Matrícula efetuada com sucesso!"));
	}
	
	public void nova()
	{
		matricula = new Matricula();
	}
	
	public void editar(Matricula matricula)
	{
		this.matricula = matricula;
	}
	
	public void cancelar()
	{
		matricula = null;
	}

	private void atualizarMatriculas() {
		matriculas = matriculaServico.listarTodos();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
