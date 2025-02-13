package com.mbpreparacoes.backend.validation;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
public class MailValidar {

    public static boolean validarMail(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        return EmailValidator.getInstance().isValid(email);
}
}
