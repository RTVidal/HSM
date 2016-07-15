/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.modelo;

/**
 *
 * @author Rafael
 */
public enum TipoCurso {
    
    CORDAS("Cordas"),
    MADEIRAS("Madeiras"),
    METAIS("Metais"),
    PERCURSSAO("Percurssão");
    
    private String descricao;
    
    private TipoCurso(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
