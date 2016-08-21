package hsm.servico;

import java.util.List;

import hsm.modelo.Matricula;
import hsm.modelo.MatriculaVO;

public interface MatriculaServico {

	public List<MatriculaVO> listarTodos();
	public void salvar(Matricula matricula);
	public List<Matricula> listarTodasAtivas();
	public Matricula obterPorId(Integer id);
}
