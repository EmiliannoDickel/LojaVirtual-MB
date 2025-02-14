package com.mbpreparacoes.backend.service;

import com.mbpreparacoes.backend.entity.Email;
import com.mbpreparacoes.backend.entity.Pessoa;
import com.mbpreparacoes.backend.repository.PessoaRepository;
import com.mbpreparacoes.backend.validation.CpfValidar;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PessoaGestaoService {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Autowired
    private CpfValidar cpfValidar;

    @Autowired
    private EmailService emailService;

    public String soliciarCodigo(String Email) {
        Pessoa objeto = pessoaRepository.findByEmail(Email);
        objeto.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(objeto.getId()));
        objeto.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(objeto);
        Email email = new Email();
        email.setDestinatario(objeto.getEmail());
        email.setTitulo("Recuperação De Senha");
        email.setMensagem("Olá, o seu código de recuperação de senha é " + objeto.getCodigoRecuperacaoSenha());
        emailService.enviarEmail(email);
        return "Código Enviado Com Sucesso!";
    }

    public String alterarSenha(Pessoa objeto) {
        Pessoa objetoBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(objeto.getEmail(), objeto.getCodigoRecuperacaoSenha());
        if (objetoBanco != null) {
            Date diferenca = new Date(new Date().getTime() - objetoBanco.getDataEnvioCodigo().getTime());

            if (diferenca.getTime() / 1000 < 900) { //diferencao em milisengundo dividido por 1000 para dar segundos < que 900 que eh 15minutos em segundos
                objetoBanco.setSenha(objeto.getSenha()); //spring security - depois ...
                objetoBanco.setCodigoRecuperacaoSenha(null);
                pessoaRepository.saveAndFlush(objetoBanco);
                return "Senha alterada com sucesso!";
            } else {
                return "Tempo para alterar senha expirado, solicite o código novamente!";
            }
        } else {
            return "Email ou código não encontados. ";
        }
    }

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
        //Garantir codigo unico

    }
}
