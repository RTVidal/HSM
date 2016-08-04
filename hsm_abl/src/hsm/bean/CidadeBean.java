package hsm.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
	
	private Cidade cidade;
	private List<Cidade> cidades;
	
	public void IniciarBean()
	{
		cidades = new GenericDAO<Cidade>(Cidade.class).listarTodos();		
	}
	
	public void Salvar()
	{
		new GenericDAO<Cidade>(Cidade.class).Salvar(cidade);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cidade cadastrada com sucesso!"));
		cidade = null;
		
		Consultar();
	}
	
	public void NovaCidade()
	{
		cidade = new Cidade();
	}
	
	public void Consultar()
	{
		
	}
	
	public List<Estado> getEstados()
	{
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
	
	

}
