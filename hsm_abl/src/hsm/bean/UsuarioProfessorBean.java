package hsm.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import hsm.exception.LoginRepetidoException;
import hsm.modelo.UsuarioProfessor;
import hsm.servico.UsuarioProfessorServico;
import hsm.util.Mensagem;

@Controller
@Scope("session")
public class UsuarioProfessorBean implements Serializable {

	private static final long serialVersionUID = -3000312064179647928L;

	private UsuarioProfessor usuarioProfessor;
	private List<UsuarioProfessor> usuariosProfessor;
	
	@Autowired
	private UsuarioProfessorServico usuarioProfessorServico;
	
	public void iniciarBean()
	{
		usuariosProfessor = usuarioProfessorServico.listarTodos();
	}
	
	public void novo()
	{
		usuarioProfessor = new UsuarioProfessor();
	}
	
	public void salvar(){
		try {
			usuarioProfessorServico.salvar(usuarioProfessor);
			atualizarLista();
			usuarioProfessor = null;
			Mensagem.informacao("Usuário salvo com sucesso");
		} catch (LoginRepetidoException e) {
			Mensagem.erro(e.getMessage());
		}
	}
	
	public void editar(UsuarioProfessor usuarioProfessor)
	{
		this.usuarioProfessor = usuarioProfessor;
	}
	
	public void cancelar()
	{
		this.usuarioProfessor = null;
	}
	
	private void atualizarLista()
	{
		usuariosProfessor = usuarioProfessorServico.listarTodos();
	}

	public UsuarioProfessor getUsuarioProfessor() {
		return usuarioProfessor;
	}

	public void setUsuarioProfessor(UsuarioProfessor usuarioProfessor) {
		this.usuarioProfessor = usuarioProfessor;
	}

	public List<UsuarioProfessor> getUsuariosProfessor() {
		return usuariosProfessor;
	}

	public void setUsuariosProfessor(List<UsuarioProfessor> usuariosProfessor) {
		this.usuariosProfessor = usuariosProfessor;
	}
	
}
