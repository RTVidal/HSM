package hsm.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import hsm.modelo.Aluno;

@ManagedBean
@ViewScoped
public class TesteBean {

	private Aluno aluno = new Aluno();
	
	public void upload(FileUploadEvent event) {
		
		try {
			System.out.println("foto..");
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
			
			aluno.setFoto(foto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
