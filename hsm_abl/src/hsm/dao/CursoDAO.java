/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.dao;

import hsm.modelo.Curso;
import javax.persistence.EntityManager;

/**
 *
 * @author Rafael
 */
public class CursoDAO {
    
    public void Salvar(Curso curso)
    {
        EntityManager em = JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        
        em.merge(curso);
        
        em.getTransaction().commit();
        
        em.close();
    }
}
