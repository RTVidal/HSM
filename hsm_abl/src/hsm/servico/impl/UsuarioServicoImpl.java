package hsm.servico.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import hsm.modelo.Usuario;
import hsm.servico.UsuarioServico;

@Service("usuarioServico")
public class UsuarioServicoImpl implements UsuarioServico{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario obterUsuarioPeloLogin(String login) {
		List<Usuario> usuarios = em.createQuery("from Usuario where login = :login").setParameter("login", login).getResultList();
		
		if(usuarios.isEmpty())
		{
		return null;
		} else {
			return usuarios.get(0);			
		}
		
	}

}
