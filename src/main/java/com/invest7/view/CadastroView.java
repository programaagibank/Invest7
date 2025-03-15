package com.invest7.view;

import com.invest7.controller.DataValidate;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.invest7.controller.CpfValidate;
import com.invest7.controller.HashSenha;
import com.invest7.controller.UserCreateController;


public class CadastroView {
    public void CriarUsuario(){
        Scanner sc = new Scanner(System.in);
        String nome = null,dataString=null, cpf = null, endereco = null, genero = null, email = null, senha = null, senhaHash = null;
        Date data_nasc = null;
        DataValidate data = new DataValidate();
        HashSenha senhacrip = new HashSenha();
        String escolha = null;
        int opcaoGenero = 0;
        boolean digitoCerto = false;
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        UserCreateController userCreate = new UserCreateController();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("-----------TELA DE CADASTRO--------");


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

        boolean resultadoCPF = true;
        while (resultadoCPF) {
            System.out.println("2- Digite o seu CPF: ");
            cpf = sc.nextLine();
            String cpfValidado = CpfValidate.validaCpf(cpf);

            if (cpfValidado != null) {
                boolean cpfExiste = userCreate.verificaCPF(cpfValidado);

                if (cpfExiste) {
                    System.out.println("CPF já cadastrado. Tente novamente.");
                } else {
                    resultadoCPF = false;
                }
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
                System.out.println("Endereco Incorreto, digite novamente...");
                sc.next();
            }
        }

        while (data_nasc == null) {
            System.out.println("4- Digite uma data (no formato yyyy/MM/dd): ");
            dataString = sc.nextLine();

            // Valida a data
            dataString= data.validarData(dataString);
        }

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

        boolean resultadoEmail = true;
        while (resultadoEmail) {
            System.out.println("6- Digite o seu email: ");
            email = sc.nextLine();
            if (validarEmail(email)) {
                boolean emailExiste = userCreate.verificaEmail(email);
                if (emailExiste) {
                    System.out.println("Email já cadastrado. Tente novamente.");
                } else {
                    resultadoEmail = false;
                }
            } else {
                System.out.println("Email inválido! O email deve conter '@' e um domínio válido. Tente novamente.");
            }
        }


        do {
            System.out.println("7- Digite a sua senha: ");
            senha = sc.nextLine();
            System.out.println("Confirme a sua senha: ");
            escolha = sc.nextLine();

            if (!senha.equals(escolha)) {
                System.out.println("As senhas não coincidem. Tente novamente.");
            }

        } while (!senha.equals(escolha));


        senhaHash = senhacrip.hashSenha(senha);
        System.out.print("senha " + senha + " = senha criptografada = " + senhaHash);
        System.out.println();

        boolean    resultadoCliente = userCreate.criarUser(nome, email, senhaHash, cpf, endereco,genero, dataString);
        if (!resultadoCliente) {
            System.out.println("Por algum motivo deu erro, faça o cadastro novamente!!");
        } else {
            menuPrincipal.ExibirMenuPrincipal();
        }


    }

    public boolean validarEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
}
