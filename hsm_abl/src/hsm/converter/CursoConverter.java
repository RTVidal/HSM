package hsm.converter;

import javax.faces.convert.FacesConverter;

import hsm.modelo.Curso;

@FacesConverter("cursoConverter")
public class CursoConverter extends EntityConverter<Curso>{

	public CursoConverter() {
		super(Curso.class);
	}
	
}
