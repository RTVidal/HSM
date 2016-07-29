package hsm.converter;

import javax.faces.convert.FacesConverter;

import hsm.modelo.Cidade;

@FacesConverter("cidadeEntityConverter")
public class CidadeEntityConverter extends EntityConverter<Cidade>{

	public CidadeEntityConverter() {
		super(Cidade.class);
	}
	
}
