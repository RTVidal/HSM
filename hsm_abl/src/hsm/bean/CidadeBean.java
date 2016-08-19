package hsm.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hsm.dao.GenericDAO;
import hsm.modelo.Cidade;
import hsm.modelo.Estado;
import hsm.servico.CidadeServico;
import hsm.util.Mensagem;

@Controller
@Scope("session")
public class CidadeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4640543846520409548L;

	private Cidade cidade = new Cidade();
	private List<Cidade> cidades;
	private Cidade cidadeSelecionada;

	@Autowired
	private CidadeServico cidadeServico;

	public void IniciarBean() {
		cidades = new GenericDAO<Cidade>(Cidade.class).listarTodos();
	}

	public void Salvar() {
		cidadeServico.salvar(cidade);
		Mensagem.informacao("Cidade cadastrada com sucesso!");
		cidade = new Cidade();
		cidadeSelecionada = null;
		Consultar();
		// RequestContext.getCurrentInstance().execute("PF('cadastroCidadeDialog').hide()");
	}

	public void NovaCidade() {
		cidade = new Cidade();
	}

	public void cancelar() {
		cidade = new Cidade();
		cidadeSelecionada = null;
	}

	public void excluir() {
		cidadeServico.excluir(cidadeSelecionada);
		cidadeSelecionada = null;
		Consultar();
	}

	public void onRowEdit(RowEditEvent event) {
		cidade = (Cidade) event.getObject();
		Salvar();
	}

	public void onCellEdit(CellEditEvent event) {
		DataTable table = (DataTable) event.getSource();
		cidade = (Cidade) table.getRowData();
		Salvar();
	}

	public void Consultar() {
		cidades = cidadeServico.listarTodos();
	}

	public List<Estado> getEstados() {
		return Arrays.asList(Estado.values());
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cidade getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada(Cidade cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}

}
