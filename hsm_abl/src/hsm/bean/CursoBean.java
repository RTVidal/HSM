/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.bean;

import hsm.modelo.Curso;
import hsm.modelo.TipoCurso;
import hsm.dao.CursoDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rafael
 */
@ManagedBean
@SessionScoped
public class CursoBean {

    private Curso curso;
    private List<TipoCurso> tipos = Arrays.asList(TipoCurso.values());
    private List<Curso> cursos = new ArrayList<Curso>();
    /**
     * Creates a new instance of CursoBean
     */
    public CursoBean() {
    	cursos = new CursoDAO().listarCursos();
    	curso = new Curso();
    }
    
    public String Salvar()
    {
        new CursoDAO().Salvar(curso);
        
        cursos = new CursoDAO().listarCursos();
        curso = new Curso();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso salvo com sucesso!"));
        
        return "curso_lista?faces-redirect=true";
    }
    
    public String Editar(Curso curso)
    {
    	this.curso = curso;
    	return "curso_formulario?faces-redirect=true";
    }
    
    public void PrepararExclusao(Curso curso)
    {
    	this.curso = curso;
    }
    
    public void Excluir()
    {
    	new CursoDAO().Excluir(curso);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso excluído com sucesso!"));
    	cursos = new CursoDAO().listarCursos();    	
    }
    
    public String getDataAtual()
    {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}

