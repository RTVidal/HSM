/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hsm.dao.CursoDAO;
import hsm.dao.GenericDAO;
import hsm.modelo.Curso;
import hsm.modelo.TipoCurso;

/**
 *
 * @author Rafael
 */
@ManagedBean
@ViewScoped
public class CursoBean implements Serializable{
	
	private static final long serialVersionUID = 2238454125561714010L;
	
	private Curso curso;
    private List<TipoCurso> tipos;
    private List<Curso> cursos = new ArrayList<Curso>();
    private List<Curso> cursosAccordion = new ArrayList<Curso>();
    private List<Curso> cursosFiltrados;
    private Curso cursoExcluir;
    /**
     * Creates a new instance of CursoBean
     */
    
    public void IniciarBean()
    {
    	//cursos = new CursoDAO().listarCursos();
    	cursos = new GenericDAO<Curso>(Curso.class).listarTodos();
    	cursosAccordion = new CursoDAO().listarCursosAccordion();
    	tipos = Arrays.asList(TipoCurso.values());
    }
    
    public void NovoCurso()
    {
    	curso = new Curso();
    }
    
    public void Salvar() throws Exception
    {
    	Thread.sleep(2000);
    	
    	new GenericDAO<Curso>(Curso.class).Salvar(curso);
        //new CursoDAO().Salvar(curso);
        
    	cursos = new GenericDAO<Curso>(Curso.class).listarTodos();
        //cursos = new CursoDAO().listarCursos();
        curso = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso salvo com sucesso!"));
    }
    
    public void Editar(Curso curso)
    {
    	this.curso = curso;
    }
    
    public void PrepararExclusao(Curso curso)
    {
    	this.cursoExcluir = curso;
    }
    
    public void Excluir()
    {
    	new CursoDAO().Excluir(cursoExcluir);
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Curso excluído com sucesso!"));
    	cursos = new CursoDAO().listarCursos();    
    	cursosFiltrados = null;
    }    
    
    public void Voltar()
    {
    	curso = null;
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

	public List<Curso> getCursosAccordion() {
		return cursosAccordion;
	}

	public void setCursosAccordion(List<Curso> cursosAccordion) {
		this.cursosAccordion = cursosAccordion;
	}

	public Curso getCursoExcluir() {
		return cursoExcluir;
	}

	public void setCursoExcluir(Curso cursoExcluir) {
		this.cursoExcluir = cursoExcluir;
	}

	public List<Curso> getCursosFiltrados() {
		return cursosFiltrados;
	}

	public void setCursosFiltrados(List<Curso> cursosFiltrados) {
		this.cursosFiltrados = cursosFiltrados;
	}
}

