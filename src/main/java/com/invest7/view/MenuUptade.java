package com.invest7.view;

import com.invest7.controller.DataValidate;
import com.invest7.controller.UserController;
import com.invest7.model.UserModel;

import java.util.Scanner;

public class MenuUptade {
    public void MenuUptade(){
        Scanner sc = new Scanner(System.in);
        String nome = null,dataString=null, endereco = null, genero = null, email = null, data_nasc = null;
        DataValidate data = new DataValidate();
        String escolha = null;
        int opcaoGenero = 0;
        boolean digitoCerto = false;
        UserController userU = new UserController();

        System.out.println("*********** Menu de Uptade **********");
        System.out.println();
        while (!digitoCerto) {
            System.out.println("1- Digite o seu nome: ");
            if (sc.hasNextLine()) {
                nome = sc.nextLine();
                digitoCerto = true;
            } else {
                System.out.println("Nome Incorreto, digite novamente...");
                sc.next();
            }
        }

        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("3- Digite o seu endereco: ");
            if (sc.hasNextLine()) {
                endereco = sc.nextLine();
                digitoCerto = true;
            } else {
                System.out.println("Endereco Incorreto, digite novamente...");
                sc.next();
            }
        }


        do  {
            System.out.println("4- Digite uma data (no formato yyyy/MM/dd): ");
            dataString = sc.nextLine();

            // Valida a data
            data_nasc = data.validarData(dataString);
            if (data_nasc == null) {
                System.out.println("Data inválida. Por favor, tente novamente.");
            }
        }while (data_nasc == null);


        digitoCerto = false;
        while (!digitoCerto) {
            System.out.println("5- Qual seu genero: ");
            System.out.println("1- masculino");
            System.out.println("2- feminino");
            System.out.println("3- Outros");

            if (sc.hasNextInt()) {
                opcaoGenero = sc.nextInt();
                sc.nextLine();
                switch (opcaoGenero) {
                    case 1:
                        genero = "Masculino";
                        digitoCerto = true;
                        break;
                    case 2:
                        genero = "Feminino";
                        digitoCerto = true;
                        break;
                    case 3:
                        genero = "Outros";
                        digitoCerto = true;
                        break;
                    default:
                        System.out.println("Opcao invalida, digite novamente...");
                        break;
                }
            }else{
                System.out.println("Digite o numero da opcao...");
                sc.next();
            }
        }


        boolean    resultadoCliente = userU.uptadeUser(nome, endereco,genero, data_nasc);
        if (!resultadoCliente) {
            System.out.println("Ocorreu algum problema na hora de atualizar os dados!!! ");
            System.out.println();
        } else {
            System.out.println("Dados atualizados !!! ");
            System.out.println();
        }

    }
}
