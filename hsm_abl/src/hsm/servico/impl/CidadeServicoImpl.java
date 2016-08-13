package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hsm.modelo.Cidade;
import hsm.modelo.Estado;
import hsm.servico.CidadeServico;

@Service
@Transactional
public class CidadeServicoImpl implements CidadeServico {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Cidade cidade) {
		em.merge(cidade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listarTodos() {
		return em.createQuery("from Cidade order by nome").getResultList();
	}

	@Override
	public void excluir(Cidade cidade) {
		em.remove(em.merge(cidade));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> obterCidadesDoEstado(Estado estado) {
		return em.createQuery("from Cidade where estado = :uf order by nome").setParameter("uf", estado)
				.getResultList();
	}

}
