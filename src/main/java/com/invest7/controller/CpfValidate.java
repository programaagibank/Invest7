package com.invest7.controller;

import java.util.regex.Pattern;

public class CpfValidate {
    private static final Pattern ALL_SAME_DIGITS = Pattern.compile("^(\\d)\\1{10}$");

    public static String validaCpf(String cpf) {
        if (cpf == null) {
            return null;
        }

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return null;
        }

        if (ALL_SAME_DIGITS.matcher(cpf).matches()) {
            return null;
        }

        String base = cpf.substring(0, 9);
        int[] firstWeights = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] secondWeights = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int firstDigit = calculateDigit(base, firstWeights);
        int secondDigit = calculateDigit(base + firstDigit, secondWeights);

        String computedCpf = base + firstDigit + secondDigit;
        return cpf.equals(computedCpf) ? cpf : null;
    }

    private static int calculateDigit(String number, int[] weights) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i)) * weights[i];
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }
}