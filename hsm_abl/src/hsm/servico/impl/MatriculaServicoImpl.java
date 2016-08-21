package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hsm.modelo.Matricula;
import hsm.modelo.MatriculaVO;
import hsm.servico.MatriculaServico;

@Service("matriculaServico")
@Transactional
public class MatriculaServicoImpl implements MatriculaServico{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MatriculaVO> listarTodos() {
		return em.createNamedQuery(Matricula.LISTAR_TODOS).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listarTodasAtivas() {
		return em.createNamedQuery("matricula.ListarTodasAtivas").getResultList();
	}

	@Override
	public void salvar(Matricula matricula) {
		em.merge(matricula);		
	}

	@Override
	public Matricula obterPorId(Integer id) {
		return em.find(Matricula.class, id);
	}

}
