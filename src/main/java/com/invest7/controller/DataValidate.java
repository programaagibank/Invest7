package com.invest7.controller;

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DataValidate {
    public Date validarData(String dataString){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {

            data = dateFormat.parse(dataString);
        } catch (ParseException e) {
            // Caso a data não esteja no formato correto, exibe uma mensagem de erro
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
        }
        return data;
    }
}
