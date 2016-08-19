/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

//import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rafael
 */
@Entity
public class Curso implements Serializable{
    
	private static final long serialVersionUID = -5096984551772988025L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String descricao;
    private double duracao = 1;
    private TipoCurso tipo;
    private Date dataCriacao;

    public Curso(){}
    
    public Curso(String nomeCurso) {
		this.nome = nomeCurso;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "Informe o nome")
    @Length(min = 4, max = 50, message = "O nome deve ter entre 4 e 50 caracteres")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "Informe a descrição")
    @Length(min = 4, max = 255, message = "A descrição deve ter entre 4 e 250 caracteres")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Min(value = 1, message = "A duração deve ser no mínimo 1")
    @Max(value = 10, message = "A duração deve ser no máximo 10")
    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    @NotNull(message = "Selecione o tipo")
    public TipoCurso getTipo() {
        return tipo;
    }

    public void setTipo(TipoCurso tipo) {
        this.tipo = tipo;
    }

    @NotNull(message = "Selecione a data de criação")
    @Past(message = "A data de criação não pode ser superior a hoje")
    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public String ObterImagem()
    {
    	return nome.toLowerCase().replaceAll("ã", "a").replaceAll("é", "e").replace(" ", "-").concat(".png");
    	//return "./Resources/Images/" + nome.toLowerCase().replaceAll("ã", "a").replaceAll("é", "e").replace(" ", "-").concat(".png");
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}
