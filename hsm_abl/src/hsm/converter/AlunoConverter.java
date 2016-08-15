package hsm.converter;

import javax.faces.convert.FacesConverter;

import hsm.modelo.Aluno;

@FacesConverter("alunoConverter")
public class AlunoConverter extends EntityConverter<Aluno>{

	public AlunoConverter() {
		super(Aluno.class);
	}
	
}
