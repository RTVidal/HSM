package hsm.modelo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Embeddable
public class Endereco {
	
	private String logradouro;
	private Integer numero;
	private String CEP;
	private Cidade cidade = new Cidade();
	
	@NotEmpty(message = "Informe o logradouro")
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	@NotNull(message = "Informe o número!")
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	@NotEmpty(message = "Informe o CEP")
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	@NotNull(message = "Selecione a cidade")
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
