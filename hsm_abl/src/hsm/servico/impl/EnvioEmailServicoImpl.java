package hsm.servico.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import hsm.servico.EnvioEmailServico;

@Service
public class EnvioEmailServicoImpl implements EnvioEmailServico {

	@Override
	@Scheduled(cron = "30 03 21 * * *")
	public void enviarEmail() {
		System.out.println("Enviando email cron...");		
	}	
}
