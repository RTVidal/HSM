package hsm.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hsm.dao.GenericDAO;
import hsm.modelo.Aluno;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable{

	private static final long serialVersionUID = -8991739415667347069L;
	
	private Aluno aluno;
	private List<Aluno> alunos;
	
	public void IniciarBean()
	{
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
	}
	
	public void NovoAluno()
	{
		aluno = new Aluno();
	}
	
	public void Salvar()
	{
		new GenericDAO<Aluno>(Aluno.class).Salvar(aluno);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno cadastrado com sucesso!"));
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
		aluno = null;
	}
	
	public void Editar(Aluno aluno)
	{
		this.aluno = aluno;
		
	}
	
	public void Voltar()
	{
		this.aluno = null;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
