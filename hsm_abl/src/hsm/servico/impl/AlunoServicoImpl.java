package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hsm.modelo.Aluno;
import hsm.servico.AlunoServico;

@Service("alunoServico")
@Transactional
public class AlunoServicoImpl implements AlunoServico {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void salvar(Aluno aluno) {
		em.merge(aluno);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listarTodos() {
		return em.createQuery("from Aluno").getResultList();
	}

}
