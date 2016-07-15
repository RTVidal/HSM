/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.bean;

import hsm.modelo.Curso;
import hsm.modelo.TipoCurso;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rafael
 */
@ManagedBean
public class CursoBean {

    private Curso curso = new Curso();
    private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
    /**
     * Creates a new instance of CursoBean
     */
    public CursoBean() {
    }
    
    public void Salvar()
    {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso salvo com sucesso!"));
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public List<TipoCurso> getTipos() {
        return tipos;
    }

    public void setTipos(List<TipoCurso> tipos) {
        this.tipos = tipos;
    }
    
}
