package hsm.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

	private final Class<T> classe;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	public void Salvar(T t) {
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
			
		em.close();
		//JPAUtil.fecharConexao();
	}

	public void Excluir(T t) {
		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();

		em.close();
		//JPAUtil.fecharConexao();
	}
	
	public List<T> listarTodos()
	{
		EntityManager em = JPAUtil.getEntityManager();
		
		List<T> resultados = em.createQuery("select c from " + classe.getName() + " c", classe).getResultList();
		
		em.close();
		//JPAUtil.fecharConexao();
		
		return resultados;
	}
	
	public T ObterPorID(Integer id)
	{
		EntityManager em = JPAUtil.getEntityManager();
		
		T t = em.createQuery("from " + classe.getName() + " where id = :id", classe).setParameter("id", id).getSingleResult();
		
		em.close();
		//JPAUtil.fecharConexao();
		
		return t;
	}
}
