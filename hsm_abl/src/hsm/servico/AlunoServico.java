package hsm.servico;

import java.util.List;

import hsm.modelo.Aluno;

public interface AlunoServico {

	public void salvar(Aluno aluno);
	public List<Aluno> listarTodos();
	
}
