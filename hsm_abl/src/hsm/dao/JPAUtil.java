/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rafael
 */
public class JPAUtil {
    
	public static EntityManagerFactory factory;
	
    public static EntityManager getEntityManager()
    {
        factory = Persistence.createEntityManagerFactory("escola_musica");
        
        return factory.createEntityManager();
    }
    
    public static void fecharConexao()
    {
    	factory.close();
    }

}
