package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import hsm.exception.LoginRepetidoException;
import hsm.modelo.Usuario;
import hsm.modelo.UsuarioProfessor;
import hsm.servico.UsuarioProfessorServico;
import hsm.servico.UsuarioServico;
import hsm.util.GeradorSenhaAleatoria;

@Service
@Transactional
public class UsuarioProfessorServicoImp implements UsuarioProfessorServico {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private UsuarioServico usuarioServico;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void salvar(UsuarioProfessor usuarioProfessor) {
		usuarioProfessor.setLogin(usuarioProfessor.getEmail());
		Usuario usuarioSalvo = usuarioServico.obterUsuarioPeloLogin(usuarioProfessor.getLogin());

		if (usuarioSalvo != null && !usuarioSalvo.getId().equals(usuarioProfessor.getId())) {
			throw new LoginRepetidoException("Já existe um usuário cadastrado com este e-mail");
		}

		if (usuarioProfessor.getId() == null) {
			String senhaGerada = GeradorSenhaAleatoria.gerarSenha(6);
			//TODO - ENVIAR SENHA POR EMAIL
			System.out.println(senhaGerada);
			
			String senhaCripto = passwordEncoder.encodePassword(senhaGerada, null);
			usuarioProfessor.setSenha(senhaCripto);
		}
		
		em.merge(usuarioProfessor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioProfessor> listarTodos() {
		return em.createNamedQuery(UsuarioProfessor.LISTAR_TODOS).getResultList();
	}

}
