package com.invest7.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final String PROPERTIES_FILE = "/db.properties";
    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = ConnectionFactory.class.getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                throw new IllegalArgumentException("Arquivo de propriedades não encontrado.");
            }
            Properties props = new Properties();
            props.load(input);
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar as configurações do banco de dados.", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
