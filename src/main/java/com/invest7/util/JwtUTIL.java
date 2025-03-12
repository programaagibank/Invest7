/*
package com.invest7.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import javax.crypto.SecretKey;

public class JwtUtil {
    private static final String SECRET_KEY = "ChaveZuperSecreta"; // ⚠️ Atenção em produção!
    private static final long EXPIRATION_TIME = 86400000; // 24 horas

    // Método para gerar o token JWT
    public static String generateToken(String email) {
        // Criar uma chave segura baseada na string SECRET_KEY
        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts.builder()
                .setSubject(email)   // Define o email do usuário como "dono" do token
                .setIssuedAt(new Date())  // Data de criação
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))  // Expiração
                .signWith(key, SignatureAlgorithm.HS256)  // Algoritmo de assinatura
                .compact();
    }

    // Método para validar o token e extrair o email
    public static String validateToken(String token) {
        try {
            // Criar uma chave segura baseada na string SECRET_KEY
            SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)  // Usa a chave secreta para decodificar
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return claims.getSubject();  // Retorna o email do usuário
        } catch (Exception e) {
            return null;  // Token inválido ou expirado
        }
    }
}

 */