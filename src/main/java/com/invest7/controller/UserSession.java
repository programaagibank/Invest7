package com.invest7.controller;

public class UserSession {
    private static int loggedInUserId = -1; // Valor padrão para indicar "não logado"

    public static void setLoggedInUserId(int userId) {
        loggedInUserId = userId;
        System.out.println("ID do usuário armazenado na sessão: " + loggedInUserId); // Log para depuração
    }

    public static int getLoggedInUserId() {
        return loggedInUserId;
    }

    public static void clear() {
        loggedInUserId = -1; // Limpa a sessão
    }
}
