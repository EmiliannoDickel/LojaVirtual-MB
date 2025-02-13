package com.mbpreparacoes.backend.validation;

import org.springframework.stereotype.Component;

@Component
public class CpfValidar {

    public boolean validarCpf(String cpf) {
        System.out.println("Validando CPF: " + cpf);
        if (cpf == null || cpf.isEmpty()) {
            return false; // CPF não pode ser nulo ou vazio
        }

        // Remove qualquer caractere não numérico (como . e -)
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (!cpf.matches("\\d{11}")) {
            return false; // CPF deve ter 11 números
        }

        return isCpfValido(cpf);
    }

    private boolean isCpfValido(String cpf) {
        // Calcula os dois últimos dígitos verificadores
        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int primeiroDigito = calcularDigito(cpf, pesos);

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int segundoDigito = calcularDigito(cpf, pesos);

        // Verifica se os dígitos calculados correspondem aos últimos dois do CPF
        return (primeiroDigito == Character.getNumericValue(cpf.charAt(9)) &&
                segundoDigito == Character.getNumericValue(cpf.charAt(10)));
    }

    private int calcularDigito(String cpf, int[] pesos) {
        int soma = 0;
        for (int i = 0; i < pesos.length; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * pesos[i];
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }
}
