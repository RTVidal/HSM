package hsm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hsm.modelo.Cidade;
import hsm.modelo.Estado;

public class CidadeDAO {

	@SuppressWarnings("unchecked")
	public static List<Cidade> ObterCidadesDoEstado(Estado estado)
	{
		EntityManager em = JPAUtil.getEntityManager();
		
		//em.create
		Query query = em.createQuery("from Cidade where estado = :uf");
		query.setParameter("uf", estado);
		
		
		List<Cidade> cidades = query.getResultList();
	
		em.close();
		
		return cidades;
	}
	
	
}
