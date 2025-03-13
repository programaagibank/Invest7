package com.invest7.view;

import com.invest7.controller.DataValidate;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.invest7.controller.CpfValidate;



public class CadastroView {
    public void CriarUsuario(){
        Scanner sc = new Scanner(System.in);
        String nome, cpf, endereco, idade, email, senha;
        Date data_nasc;
        DataValidate data = new DataValidate();;
        boolean digitoCerto = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("-----------TELA DE CADASTRO--------");

        while (!digitoCerto) {
            System.out.println("1- Digite o seu nome: ");
            if (sc.hasNextLine()) {
                 nome = sc.nextLine();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }
       digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("2- Digite o seu CPF: ");
            cpf = sc.nextLine();
            String cpfValidado = CpfValidate.validaCpf(cpf);
            if (cpfValidado != null) {
                digitoCerto = true;
                System.out.println("CPF válido! Continuando cadastro...");
            } else {
                System.out.println("CPF inválido! Tente novamente.");
            }
        }



        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("3- Digite o seu endereco: ");
            if (sc.hasNextLine()) {
                endereco = sc.nextLine();
                digitoCerto = true;
            } else {
                System.out.println("Valor Incorreto, digite novamente...");
                sc.next();
            }
        }
        data_nasc = null; // Inicializa a variável antes do loop

        while (data_nasc == null) {
            System.out.print("Digite uma data (no formato dd/MM/yyyy): ");
            String dataString = sc.nextLine();

            // Valida a data
            data_nasc = data.validarData(dataString);
        }

        System.out.println("Data válida recebida: " + data_nasc); // Confirmação opcional


    }
}
