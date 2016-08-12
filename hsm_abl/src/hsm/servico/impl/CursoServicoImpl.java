package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hsm.modelo.Curso;
import hsm.servico.CursoServico;

@Service(value = "cursoServico")
@Transactional
public class CursoServicoImpl implements CursoServico{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void salvar(Curso curso) {
		em.merge(curso);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarTodos() {
		return em.createQuery("from Curso").getResultList();
	}

	@Override
	public void Excluir(Curso curso) {		
		curso = em.merge(curso);
		em.remove(curso);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarCursosAccordion() {
		return em.createQuery("from Curso where nome in ('Violino' , 'Bateria', 'Clarinete'," + 
				"'Flauta', 'Guitarra', 'Violão', 'Oboé') order by nome").getResultList();
	}
	
}
