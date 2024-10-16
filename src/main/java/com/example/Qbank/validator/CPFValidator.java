package com.example.Qbank.validator;

public class CPFValidator {

    public static boolean isValidCPF(String cpf) {
        String cleanCpf = cpf.replaceAll("\\D", "");

        if (cleanCpf.length() != 11) {
            return false;
        }

        if (cleanCpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int firstCheckSum = 0;
        for (int i = 0; i < 9; i++) {
            firstCheckSum += (cleanCpf.charAt(i) - '0') * (10 - i);
        }
        int firstCheckDigit = 11 - (firstCheckSum % 11);
        if (firstCheckDigit >= 10) {
            firstCheckDigit = 0;
        }
        if (firstCheckDigit != (cleanCpf.charAt(9) - '0')) {
            return false;
        }

        int secondCheckSum = 0;
        for (int i = 0; i < 10; i++) {
            secondCheckSum += (cleanCpf.charAt(i) - '0') * (11 - i);
        }
        int secondCheckDigit = 11 - (secondCheckSum % 11);
        if (secondCheckDigit >= 10) {
            secondCheckDigit = 0;
        }

        return secondCheckDigit == (cleanCpf.charAt(10) - '0');
    }
}
