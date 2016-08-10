package hsm.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import hsm.dao.CidadeDAO;
import hsm.dao.GenericDAO;
import hsm.modelo.Cidade;
import hsm.modelo.Estado;

@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4640543846520409548L;

	private Cidade cidade = new Cidade();
	private List<Cidade> cidades;
	private Cidade cidadeSelecionada;

	public void IniciarBean() {
		cidades = new GenericDAO<Cidade>(Cidade.class).listarTodos();
	}

	public void Salvar() {
		new GenericDAO<Cidade>(Cidade.class).Salvar(cidade);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cidade cadastrada com sucesso!"));
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
		new GenericDAO<Cidade>(Cidade.class).Excluir(cidadeSelecionada);
		cidadeSelecionada = null;
		Consultar();
	}

	public void onRowEdit(RowEditEvent event) {
		cidade = (Cidade) event.getObject();
		Salvar();
	}

	public void onCellEdit(CellEditEvent event) {
		DataTable table = (DataTable) event.getSource();
		cidade = (Cidade)table.getRowData();
		Salvar();
	}

	public void Consultar() {
		cidades = new GenericDAO<Cidade>(Cidade.class).listarTodos();
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
