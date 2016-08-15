package hsm.servico;

import java.util.List;

import hsm.modelo.Matricula;

public interface MatriculaServico {

	public List<Matricula> listarTodos();
	public void salvar(Matricula matricula);
}
