package hsm.servico;

import java.util.List;

import hsm.modelo.Curso;

public interface CursoServico {

	public void salvar(Curso curso);
	
	public List<Curso> listarTodos();
	
	public void Excluir(Curso curso);
	
	public List<Curso> listarCursosAccordion();	
}
