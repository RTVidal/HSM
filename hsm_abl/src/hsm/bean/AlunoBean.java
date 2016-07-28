package hsm.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hsm.dao.CidadeDAO;
import hsm.dao.GenericDAO;
import hsm.modelo.Aluno;
import hsm.modelo.Cidade;
import hsm.modelo.Estado;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable{

	private static final long serialVersionUID = -8991739415667347069L;
	
	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Estado> estados;
	private Integer idCidade;
	
	public void IniciarBean()
	{
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
		estados = Arrays.asList(Estado.values());
	}
	
	public void NovoAluno()
	{
		aluno = new Aluno();
	}
	
	public void Salvar()
	{
		aluno.getEndereco().setCidade(new GenericDAO<Cidade>(Cidade.class).ObterPorID(idCidade));
		
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
	
	public String getDataAtual()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		return new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
	}
	
	public List<Cidade> getCidadesDoEstado()
	{
		return CidadeDAO.ObterCidadesDoEstado(aluno.getEndereco().getCidade().getEstado());
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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}
}
