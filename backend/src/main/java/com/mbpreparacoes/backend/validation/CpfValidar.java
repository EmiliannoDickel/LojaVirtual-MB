package com.mbpreparacoes.backend.validation;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Component
public class CpfValidar {
    public boolean validarCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            return false;
        }
        return isCpfValido(cpf);
    }

    private boolean isCpfValido(String cpf) {
        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int primeiroDigito = calcularDigito(cpf, pesos);

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int segundoDigito = calcularDigito(cpf, pesos);

        return (primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                segundoDigito == Character.getNumericValue(cpf.charAt(10)));
    }

    private int calcularDigito(String cpf, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < pesos.length - 1; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * pesos[i];
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }
}
