package hsm.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hsm.dao.GenericDAO;
import hsm.modelo.Aluno;
import hsm.modelo.Cidade;
import hsm.modelo.Estado;
import hsm.servico.AlunoServico;
import hsm.servico.CidadeServico;
import hsm.util.Mensagem;

@Controller()
@Scope("session")
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = -8991739415667347069L;

	private Aluno aluno;
	private List<Aluno> alunos;
	private List<Estado> estados;

	@Autowired
	private AlunoServico alunoServico;

	@Autowired
	private CidadeServico cidadeServico;

	public void IniciarBean() {
		alunos = alunoServico.listarTodos();
		estados = Arrays.asList(Estado.values());
	}

	public void NovoAluno() {
		aluno = new Aluno();
	}

	public void Salvar() {
		alunoServico.salvar(aluno);
		Mensagem.informacao("Aluno cadastrado com sucesso!");
		alunos = alunoServico.listarTodos();
		aluno = null;
	}

	public void Editar(Aluno aluno) {
		this.aluno = aluno;

		if (aluno.getEndereco().getCidade() == null) {
			aluno.getEndereco().setCidade(new Cidade());
		}
	}

	public void Voltar() {
		this.aluno = null;
	}

	public String getDataAtual() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		return new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
	}

	public List<Cidade> getCidadesDoEstado() {
		return cidadeServico.obterCidadesDoEstado(aluno.getEndereco().getCidade().getEstado());
	}

	public void EnviarFoto(FileUploadEvent event) {
		try {
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());

			aluno.setFoto(foto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StreamedContent getImagemAluno() {
		Map<String, String> mapaParametros = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		String idAluno = mapaParametros.get("id_aluno");
		if (idAluno != null) {
			Aluno alunoBanco = new GenericDAO<Aluno>(Aluno.class).ObterPorID(Integer.parseInt(idAluno));
			return alunoBanco.getImagem();
		}

		return new DefaultStreamedContent();
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
