package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hsm.modelo.UsuarioProfessor;
import hsm.servico.UsuarioProfessorServico;

@Service
@Transactional
public class UsuarioProfessorServicoImp implements UsuarioProfessorServico{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void salvar(UsuarioProfessor usuarioProfessor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioProfessor> listarTodos() {
		return em.createNamedQuery(UsuarioProfessor.LISTAR_TODOS).getResultList();
	}

}
