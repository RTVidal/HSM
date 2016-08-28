package hsm.servico;

import hsm.modelo.Usuario;

public interface UsuarioServico {
	
	public Usuario obterUsuarioPeloLogin(String login);

}
