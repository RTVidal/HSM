package hsm.servico;

import java.util.List;

import hsm.modelo.UsuarioProfessor;

public interface UsuarioProfessorServico {
	
	public void salvar(UsuarioProfessor usuarioProfessor);
	public List<UsuarioProfessor> listarTodos();
}
