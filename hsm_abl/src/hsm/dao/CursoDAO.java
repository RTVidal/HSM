/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import hsm.modelo.Curso;

/**
 *
 * @author Rafael
 */
public class CursoDAO {

	public void Salvar(Curso curso) {
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.merge(curso);

		em.getTransaction().commit();

		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> listarCursos() {		
		try
		{
			EntityManager em = JPAUtil.getEntityManager();		
			
			return em.createQuery("from Curso").getResultList();
		} catch (Exception e)
		{
			System.out.println("Erro ao listar cursos: " + e.getMessage());
			
			return new ArrayList<Curso>();
		}
	}

	public void Excluir(Curso curso) {
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		curso = em.merge(curso);
		
		em.remove(curso);

		em.getTransaction().commit();

		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> listarCursosAccordion() {
		try
		{
			EntityManager em = JPAUtil.getEntityManager();		
			
			return em.createQuery("from Curso where nome in ('Violino' , 'Bateria', 'Clarinete'," + 
			"'Flauta', 'Guitarra', 'Violão', 'Oboé') order by nome").getResultList();
		} catch (Exception e)
		{
			System.out.println("Erro ao listar cursos: " + e.getMessage());
			
			return new ArrayList<Curso>();
		}
	}
}
