package hsm.servico;

import java.util.List;

import hsm.modelo.Cidade;
import hsm.modelo.Estado;

public interface CidadeServico {

	public void salvar(Cidade cidade);
	public List<Cidade> listarTodos();
	public void excluir(Cidade cidade);
	public List<Cidade> obterCidadesDoEstado(Estado estado);
}
