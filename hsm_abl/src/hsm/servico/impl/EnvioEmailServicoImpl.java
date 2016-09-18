package hsm.servico.impl;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import hsm.servico.EnvioEmailServico;

@Service
public class EnvioEmailServicoImpl implements EnvioEmailServico {

	@Override
	@Scheduled(fixedDelay = 10000000)
	public void enviarEmail() {

		try {
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost("smtp.gmail.com");
			mailSender.setPort(587);
			mailSender.setProtocol("smtp");
			mailSender.setUsername("rafaelvidal4@gmail.com");
			mailSender.setPassword("******");
			mailSender.setDefaultEncoding("utf-8");

			Properties properties = new Properties();
			properties.setProperty("usernamente", "rafaelvidal4@gmail.com");
			properties.setProperty("password", "******");
			properties.setProperty("mail.smtp.auth", "true");
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.transport.protocol", "smtp");

			mailSender.setJavaMailProperties(properties);

			MimeMessage msg = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg, false);
			helper.setFrom("rafaelvidal4@gmail.com");
			helper.setSubject("Teste de envio de email");
			helper.setText("Conteúdo do email", false);
			helper.addTo("rafaelvidal4@gmail.com");
			
			mailSender.send(msg);
			
			System.out.println("enviou email");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
