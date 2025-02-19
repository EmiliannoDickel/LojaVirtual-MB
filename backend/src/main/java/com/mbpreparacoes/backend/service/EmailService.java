package com.mbpreparacoes.backend.service;


import com.mbpreparacoes.backend.entity.Email;
import freemarker.template.Configuration;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Configuration freemarkerConfiguration;

    @Value("${spring.mail.username}")
    private String remetente;

    public String enviarEmail(Email email) {
        try {
            if (email == null || email.getDestinatario() == null || email.getTitulo() == null || email.getMensagem() == null) {
                return "Erro: Dados do e-mail estão incompletos!";
            }
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(email.getDestinatario());
            simpleMailMessage.setSubject(email.getTitulo());
            simpleMailMessage.setText(email.getMensagem());
            javaMailSender.send(simpleMailMessage);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            return "Email com Erro!";
        }
    }

    public void enviarEmailTemplate(String destinatario, String Titulo, Map<String, Object> propriedades) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setSubject(Titulo);
            mimeMessageHelper.setFrom(remetente);
            mimeMessageHelper.setTo(destinatario);

            mimeMessageHelper.setText(getConteudoTemplate(propriedades),  true);
            javaMailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String getConteudoTemplate (Map<String, Object> model){
        StringBuffer content = new StringBuffer();
        try {
            content.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("email-recuperacao-codigo.ftl"), model));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

