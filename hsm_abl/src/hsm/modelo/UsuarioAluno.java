package hsm.modelo;

import javax.persistence.Entity;

@Entity
public class UsuarioAluno extends Usuario {

	private static final long serialVersionUID = 1536507345669536207L;

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
