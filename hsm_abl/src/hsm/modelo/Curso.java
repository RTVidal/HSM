/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.modelo;

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
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String descricao;
    private double duracao = 1;
    private TipoCurso tipo;
    private Date dataCriacao;

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
}
