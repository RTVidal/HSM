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

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

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
		new GenericDAO<Aluno>(Aluno.class).Salvar(aluno);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aluno cadastrado com sucesso!"));
		alunos = new GenericDAO<Aluno>(Aluno.class).listarTodos();
		aluno = null;
	}
	
	public void Editar(Aluno aluno)
	{
		this.aluno = aluno;
		
		if(aluno.getEndereco().getCidade() == null)
		{
			aluno.getEndereco().setCidade(new Cidade());
		}
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
	
	public void EnviarFoto(FileUploadEvent event)
	{
		try {
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
			
			aluno.setFoto(foto);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
}
