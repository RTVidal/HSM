package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hsm.modelo.Matricula;
import hsm.servico.MatriculaServico;

@Service("matriculaServico")
@Transactional
public class MatriculaServicoImpl implements MatriculaServico{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listarTodos() {
		return em.createQuery("from Matricula").getResultList();
	}

	@Override
	public void salvar(Matricula matricula) {
		em.merge(matricula);		
	}

}
