import java.sql.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InvestmentSimulationSystem {
    // ANSI color codes for terminal formatting
    public static final String RESET = "\033[0m";
    public static final String CIANO = "\033[36m";
    public static final String VERMELHO = "\033[31m";
    public static final String AZUL = "\033[34m";
    public static final String VERDE = "\033[32m";
    public static final String AMARELO = "\033[33m";
    public static final String ROXO = "\033[35m";
    public static final String NEGRITO = "\033[1m";

    // Investor profile constants
    private static final int PERFIL_CONSERVADOR = 1;
    private static final int PERFIL_MODERADO = 2;
    private static final int PERFIL_AGRESSIVO = 3;

    // Base rate (SELIC 2025)
    private static final double TAXA_SELIC = 13.25;

    // User session variables
    private static String usuarioLogado = null;
    private static int perfilInvestidor = 0;

    // Database connection (simulated for now; replace with actual MySQL credentials)
    private static Connection dbConnection;

    static {
        try {
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/investdb", "root", "password");
        } catch (SQLException e) {
            System.out.println(VERMELHO + "Falha na conexão com o banco de dados: " + e.getMessage() + RESET);
            dbConnection = null; // Simulate in-memory if DB fails
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            imprimirBordaCaixa();
            System.out.println(CIANO + " ||=========================================================||" + RESET);
            System.out.println(CIANO + " *********** Bem vindo ao AgInvest: *********** " + RESET);

            imprimirBordaCaixa();

            if (usuarioLogado == null) {
                executando = exibirMenuNaoLogado(scanner);
            } else {
                executando = exibirMenuLogado(scanner);
            }
        }

        System.out.println(CIANO + "Obrigado por utilizar o AgInvest! Até breve!" + RESET);
        imprimirBordaCaixa();
        System.out.println(CIANO + "Desenvolvido pela equipe INVEST7" + RESET);
        imprimirBordaCaixa();
        scanner.close();
        try {
            if (dbConnection != null) dbConnection.close();
        } catch (SQLException e) {
            System.out.println(VERMELHO + "Erro ao fechar conexão com o banco: " + e.getMessage() + RESET);
        }
    }

    // Menu for non-logged-in users
    private static boolean exibirMenuNaoLogado(Scanner scanner) {
        System.out.println("Por favor, selecione uma opcao:");
        System.out.println("1 - Questionario de Perfil de Investidor");
        System.out.println("2 - Simulador Previo de Investimentos");
        System.out.println("3 - Cadastro de Usuario");
        System.out.println("4 - Login");
        System.out.println("5 - FAQ (Perguntas Frequentes)");
        System.out.println("0 - Sair");
        System.out.println(AZUL + "||===========================================================================||" + RESET);


        int opcao = lerOpcaoNumerica(scanner, 0, 5);
        switch (opcao) {
            case 0: return false;
            case 1: executarQuestionarioPerfil(scanner, false); break;
            case 2: executarSimuladorPrevio(scanner); break;
            case 3: cadastrarUsuario(scanner); break;
            case 4: realizarLogin(scanner); break;
            case 5: exibirFAQ(scanner); break;
            default:
                System.out.println(VERMELHO + "opcao invalida!" + RESET);
        }
        return true;
    }

    // Menu for logged-in users
    private static boolean exibirMenuLogado(Scanner scanner) {
        System.out.println(VERDE + "Usuario: " + usuarioLogado + " | Perfil: " + obterNomePerfil(perfilInvestidor) + RESET);
        System.out.println("Por favor, selecione uma opcao:");
        System.out.println("1 - Questionário ANBIMA de Perfil de Investidor");
        System.out.println("2 - Simulador Total de Investimentos");
        System.out.println("3 - Simulador de Investimentos Baseado no Perfil");
        System.out.println("4 - FAQ (Perguntas Frequentes)");
        System.out.println("5 - Atualizar Dados Cadastrais");
        System.out.println("6 - Atualizar Perfil de Investidor");
        System.out.println("7 - Logout");
        System.out.println("0 - Sair");

        int opcao = lerOpcaoNumerica(scanner, 0, 7);
        switch (opcao) {
            case 0: return false;
            case 1: executarQuestionarioANBIMA(scanner); break;
            case 2: executarSimuladorTotal(scanner); break;
            case 3: executarSimuladorPerfil(scanner); break;
            case 4: exibirFAQ(scanner); break;
            case 5: atualizarDadosUsuario(scanner); break;
            case 6: atualizarPerfilInvestidor(scanner); break;
            case 7:
                usuarioLogado = null;
                perfilInvestidor = 0;
                System.out.println(AMARELO + "Logout realizado com sucesso!" + RESET);
                break;
            default:
                System.out.println(VERMELHO + "opcao invalida!" + RESET);
        }
        return true;
    }

    // RF 0001: Simplified Investor Profile Questionnaire
    private static void executarQuestionarioPerfil(Scanner scanner, boolean armazenarPerfil) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== Questionário de Perfil de Investidor ===" + RESET);
        int pontuacao = 0;

        pontuacao += perguntar(scanner, "1. Por quanto tempo você pretende manter seus investimentos?",
                "1 - Menos de 1 ano\n2 - Entre 1 e 3 anos\n3 - Entre 3 e 5 anos\n4 - Mais de 5 anos");
        pontuacao += perguntar(scanner, "2. Qual percentual do seu patrimônio você pretende investir?",
                "1 - Menos de 25%\n2 - Entre 25% e 50%\n3 - Entre 50% e 75%\n4 - Mais de 75%");
        pontuacao += perguntar(scanner, "3. Qual é a sua familiaridade com investimentos financeiros?",
                "1 - Nenhuma\n2 - Pouca\n3 - Média\n4 - Alta");

        int perfil = (pontuacao <= 5) ? PERFIL_CONSERVADOR : (pontuacao <= 8) ? PERFIL_MODERADO : PERFIL_AGRESSIVO;
        System.out.println(VERDE + "Seu perfil de investidor é: " + obterNomePerfil(perfil) + RESET);

        if (armazenarPerfil && usuarioLogado != null) {
            perfilInvestidor = perfil;
            try {
                salvarPerfilUsuario(usuarioLogado, perfil);
                System.out.println(VERDE + "Perfil armazenado com sucesso!" + RESET);
            } catch (SQLException e) {
                System.out.println(VERMELHO + "Erro ao armazenar perfil: " + e.getMessage() + RESET);
            }
        }
        aguardarEnter(scanner);
    }

    // RF 0002: Investment Preview Simulator
    private static void executarSimuladorPrevio(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(VERDE + "=== Simulador Prévio de Investimentos ===" + RESET);

        double valorInvestimento = lerValorPositivo(scanner, "valor do investimento inicial (R$)");
        double aporteMensal = lerValorPositivo(scanner, "aporte mensal (R$)");
        int meses = lerValorInteiroPositivo(scanner, "período do investimento (meses)");

        DecimalFormat df = new DecimalFormat("###,##0.00");
        String idSimulacao = String.format("%08d", (int)(Math.random() * 100000000));
        int dias = meses * 30;

        imprimirCabecalho(valorInvestimento, meses, dias, TAXA_SELIC, TAXA_SELIC, idSimulacao);

        List<ResultadoInvestimento> resultados = new ArrayList<>();
        resultados.add(calcularInvestimento("Poupança", valorInvestimento, aporteMensal, meses, 0.005, 0.0, true));
        resultados.add(calcularInvestimento("CDB", valorInvestimento, aporteMensal, meses, TAXA_SELIC, 100.0, false));
        resultados.add(calcularInvestimento("LCI/LCA", valorInvestimento, aporteMensal, meses, TAXA_SELIC, 96.0, true));
        resultados.add(calcularInvestimento("Tesouro Direto", valorInvestimento, aporteMensal, meses, TAXA_SELIC, 100.0, false));
        resultados.add(calcularInvestimento("FIIs", valorInvestimento, aporteMensal, meses, 0.008, 0.0, false));

        exibirResultados(resultados, df);

        ResultadoInvestimento melhor = encontrarMelhorInvestimento(resultados);
        System.out.println(VERDE + "Investimento mais rentável: " + melhor.nome + " (R$ " + df.format(melhor.totalLiquido) + ")" + RESET);

        System.out.println(NEGRITO + "Nova simulação? (S/N)" + RESET);
        scanner.nextLine(); // Clear buffer
        if (scanner.nextLine().toUpperCase().equals("S")) executarSimuladorPrevio(scanner);
        else aguardarEnter(scanner);
    }

    // RF 0003: User Registration
    private static void cadastrarUsuario(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== Cadastro de Usuario ===" + RESET);
        scanner.nextLine();

        String nome = lerTexto(scanner, "nome completo");
        String cpf = lerCPFValido(scanner);
        LocalDate dataNascimento = lerDataNascimento(scanner);
        String genero = lerTexto(scanner, "gênero (M/F/O)").toUpperCase();
        String email = lerEmailValido(scanner);
        String senha = lerTexto(scanner, "senha");

        String idUsuario = "USR" + String.format("%06d", (int)(Math.random() * 1000000));
        try {
            salvarUsuario(idUsuario, nome, cpf, dataNascimento, genero, email, senha);
            System.out.println(VERDE + "Cadastro concluído! ID: " + idUsuario + RESET);
            usuarioLogado = nome;
            executarQuestionarioANBIMA(scanner);
        } catch (SQLException e) {
            System.out.println(VERMELHO + "Erro ao cadastrar usuário: " + e.getMessage() + RESET);
            aguardarEnter(scanner);
        }
    }

    // RF 0004: ANBIMA Questionnaire
    private static void executarQuestionarioANBIMA(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== Questionário ANBIMA de Perfil de Investidor ===" + RESET);
        int pontuacao = 0;

        pontuacao += perguntarANBIMA(scanner, "1. Qual é o prazo médio de seus investimentos?",
                "1 - Até 1 ano\n2 - De 1 a 3 anos\n3 - De 3 a 5 anos\n4 - Mais de 5 anos");
        pontuacao += perguntarANBIMA(scanner, "2. Qual é o seu objetivo ao investir?",
                "1 - Preservar meu patrimônio\n2 - Combinar preservação e crescimento\n3 - Crescimento moderado\n4 - Crescimento agressivo");
        pontuacao += perguntarANBIMA(scanner, "3. Como você reagiria se perdesse 10% em um mês?",
                "1 - Venderia tudo\n2 - Venderia parte\n3 - Manteria\n4 - Aumentaria o investimento");
        pontuacao += perguntarANBIMA(scanner, "4. Qual percentual da renda mensal você pretende investir?",
                "1 - Até 10%\n2 - 10% a 20%\n3 - 20% a 40%\n4 - Mais de 40%");
        pontuacao += perguntarANBIMA(scanner, "5. Qual sua experiência com investimentos?",
                "1 - Nenhuma\n2 - Renda fixa\n3 - Renda fixa e variável\n4 - Experiente");

        perfilInvestidor = (pontuacao <= 8) ? PERFIL_CONSERVADOR : (pontuacao <= 15) ? PERFIL_MODERADO : PERFIL_AGRESSIVO;
        System.out.println(NEGRITO + "Pontuação: " + pontuacao + RESET);
        System.out.println(VERDE + "Seu perfil ANBIMA é: " + obterNomePerfil(perfilInvestidor) + RESET);

        if (usuarioLogado != null) {
            try {
                salvarPerfilUsuario(usuarioLogado, perfilInvestidor);
            } catch (SQLException e) {
                System.out.println(VERMELHO + "Erro ao salvar perfil: " + e.getMessage() + RESET);
            }
        }
        aguardarEnter(scanner);
    }

    // RF 0005: Login
    private static void realizarLogin(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== Login ===" + RESET);
        scanner.nextLine();

        String email = lerEmailValido(scanner);
        String senha = lerTexto(scanner, "senha");

        try {
            if (autenticarUsuario(email, senha)) {
                usuarioLogado = obterNomeUsuario(email);
                perfilInvestidor = obterPerfilUsuario(email);
                System.out.println(VERDE + "Login bem-sucedido!" + RESET);
            } else {
                System.out.println(VERMELHO + "Credenciais invalidas!" + RESET);
            }
        } catch (SQLException e) {
            System.out.println(VERMELHO + "Erro ao autenticar: " + e.getMessage() + RESET);
            // Fallback to dummy authentication if DB fails
            usuarioLogado = "Usuario Teste";
            perfilInvestidor = PERFIL_MODERADO;
            System.out.println(VERDE + "Login bem-sucedido (modo offline)!" + RESET);
        }
        aguardarEnter(scanner);
    }

    // RF 0006: Total Investment Simulator
    private static void executarSimuladorTotal(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== Simulador Total de Investimentos ===" + RESET);

        double valorInvestimento = lerValorPositivo(scanner, "valor inicial (R$)");
        double aporteMensal = lerValorPositivo(scanner, "aporte mensal (R$)");
        int meses = lerValorInteiroPositivo(scanner, "período (meses)");

        DecimalFormat df = new DecimalFormat("###,##0.00");
        String idSimulacao = String.format("%08d", (int)(Math.random() * 100000000));
        int dias = meses * 30;

        imprimirCabecalho(valorInvestimento, meses, dias, TAXA_SELIC, TAXA_SELIC, idSimulacao);

        System.out.println(AZUL + "=== Renda Fixa Pré-Fixada ===" + RESET);
        List<ResultadoInvestimento> preFixada = new ArrayList<>();
        preFixada.add(calcularInvestimento("Tesouro Prefixado", valorInvestimento, aporteMensal, meses, 0.01, 0.0, false));
        preFixada.add(calcularInvestimento("CDB Pré-Fixado", valorInvestimento, aporteMensal, meses, 0.01, 0.0, false));
        exibirResultados(preFixada, df);

        System.out.println(AZUL + "=== Renda Fixa Pós-Fixada ===" + RESET);
        List<ResultadoInvestimento> posFixada = new ArrayList<>();
        posFixada.add(calcularInvestimento("CDB Pós-Fixado", valorInvestimento, aporteMensal, meses, TAXA_SELIC, 100.0, false));
        posFixada.add(calcularInvestimento("LCI/LCA", valorInvestimento, aporteMensal, meses, TAXA_SELIC, 96.0, true));
        exibirResultados(posFixada, df);

        System.out.println(ROXO + "=== Renda Variável ===" + RESET);
        List<ResultadoInvestimento> variavel = new ArrayList<>();
        variavel.add(calcularInvestimento("FIIs", valorInvestimento, aporteMensal, meses, 0.008, 0.0, false));
        exibirResultados(variavel, df);

        System.out.println(CIANO + "Nova simulação? (S/N)" + RESET);
        scanner.nextLine(); // Clear buffer
        if (scanner.nextLine().toUpperCase().equals("S")) executarSimuladorTotal(scanner);
    }

    // RF 0007: Profile-Based Simulator
    private static void executarSimuladorPerfil(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== Simulador Baseado no Perfil ===" + RESET);
        System.out.println("Perfil: " + obterNomePerfil(perfilInvestidor));

        double valorInvestimento = lerValorPositivo(scanner, "valor inicial (R$)");
        double aporteMensal = lerValorPositivo(scanner, "aporte mensal (R$)");
        int meses = lerValorInteiroPositivo(scanner, "período (meses)");

        DecimalFormat df = new DecimalFormat("###,##0.00");
        String idSimulacao = String.format("%08d", (int)(Math.random() * 100000000));
        int dias = meses * 30;

        imprimirCabecalho(valorInvestimento, meses, dias, TAXA_SELIC, TAXA_SELIC, idSimulacao);

        if (perfilInvestidor == PERFIL_CONSERVADOR) {
            List<ResultadoInvestimento> conservador = new ArrayList<>();
            conservador.add(calcularInvestimento("Poupança", valorInvestimento, aporteMensal, meses, 0.005, 0.0, true));
            conservador.add(calcularInvestimento("LCI/LCA", valorInvestimento, aporteMensal, meses, TAXA_SELIC, 96.0, true));
            exibirResultados(conservador, df);
        } else {
            System.out.println(AZUL + "=== Renda Fixa Pré-Fixada ===" + RESET);
            List<ResultadoInvestimento> preFixada = new ArrayList<>();
            preFixada.add(calcularInvestimento("Tesouro Prefixado", valorInvestimento, aporteMensal, meses, 0.01, 0.0, false));
            exibirResultados(preFixada, df);

            System.out.println(AZUL + "=== Renda Fixa Pós-Fixada ===" + RESET);
            List<ResultadoInvestimento> posFixada = new ArrayList<>();
            posFixada.add(calcularInvestimento("CDB Pós-Fixado", valorInvestimento, aporteMensal, meses, TAXA_SELIC, 100.0, false));
            exibirResultados(posFixada, df);

            if (perfilInvestidor == PERFIL_AGRESSIVO) {
                System.out.println(ROXO + "=== Renda Variável ===" + RESET);
                List<ResultadoInvestimento> variavel = new ArrayList<>();
                variavel.add(calcularInvestimento("FIIs", valorInvestimento, aporteMensal, meses, 0.008, 0.0, false));
                exibirResultados(variavel, df);
            }
        }
        System.out.println(CIANO + "Nova simulação? (S/N)" + RESET);
        scanner.nextLine(); // Clear buffer
        if (scanner.nextLine().toUpperCase().equals("S")) executarSimuladorPerfil(scanner);
        else aguardarEnter(scanner);
    }

    // RF 0008: FAQ
    private static void exibirFAQ(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== FAQ ===" + RESET);
        System.out.println("Q: O que é perfil de investidor?\nA: Uma classificação do seu apetite por risco.");
        System.out.println("Q: Como calcular o rendimento?\nA: Usamos juros compostos com taxas baseadas no SELIC 2025 (13,25%).");
        aguardarEnter(scanner);
    }

    // RF 0009: Update User Data
    private static void atualizarDadosUsuario(Scanner scanner) {
        imprimirBordaCaixa();
        System.out.println(NEGRITO + "=== Atualizar Dados ===" + RESET);
        scanner.nextLine();
        String novoNome = lerTexto(scanner, "novo nome completo");
        try {
            atualizarNomeUsuario(usuarioLogado, novoNome);
            usuarioLogado = novoNome;
            System.out.println(VERDE + "Dados atualizados!" + RESET);
        } catch (SQLException e) {
            System.out.println(VERMELHO + "Erro ao atualizar dados: " + e.getMessage() + RESET);
        }
        aguardarEnter(scanner);
    }

    // RF 0010: Update Investor Profile
    private static void atualizarPerfilInvestidor(Scanner scanner) {
        executarQuestionarioPerfil(scanner, true);
    }

    // Helper Methods
    private static void imprimirBordaCaixa() {
        //System.out.println(NEGRITO + "||===========================================================================||" + RESET);
    }

    private static int lerOpcaoNumerica(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int opcao = scanner.nextInt();
                if (opcao < min || opcao > max) {
                    System.out.println(VERMELHO + "opcao deve estar entre " + min + " e " + max + "!" + RESET);
                    continue;
                }
                return opcao;
            } catch (Exception e) {
                System.out.println(VERMELHO + "Digite um número válido!" + RESET);
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static double lerValorPositivo(Scanner scanner, String campo) {
        System.out.println(CIANO + "Digite o " + campo + ": " + RESET);
        while (true) {
            try {
                double valor = scanner.nextDouble();
                if (valor < 0) {
                    System.out.println(VERMELHO + "O valor deve ser positivo!" + RESET);
                    continue;
                }
                return valor;
            } catch (Exception e) {
                System.out.println(VERMELHO + "Digite um valor numérico válido!" + RESET);
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static int lerValorInteiroPositivo(Scanner scanner, String campo) {
        System.out.println(CIANO + "Digite o " + campo + ": " + RESET);
        while (true) {
            try {
                int valor = scanner.nextInt();
                if (valor <= 0) {
                    System.out.println(VERMELHO + "O valor deve ser positivo!" + RESET);
                    continue;
                }
                return valor;
            } catch (Exception e) {
                System.out.println(VERMELHO + "Digite um número inteiro válido!" + RESET);
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static String lerTexto(Scanner scanner, String campo) {
        System.out.println(CIANO + "Digite seu " + campo + ": " + RESET);
        return scanner.nextLine().trim();
    }

    private static String lerCPFValido(Scanner scanner) {
        String cpf;
        do {
            cpf = lerTexto(scanner, "CPF (somente números)");
            if (!validarCPF(cpf)) System.out.println(VERMELHO + "CPF inválido (11 dígitos)!" + RESET);
        } while (!validarCPF(cpf));
        return cpf;
    }

    private static LocalDate lerDataNascimento(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                String dataStr = lerTexto(scanner, "data de nascimento (dd/MM/yyyy)");
                LocalDate data = LocalDate.parse(dataStr, formatter);
                if (data.isAfter(LocalDate.now())) {
                    System.out.println(VERMELHO + "Data não pode ser futura!" + RESET);
                    continue;
                }
                return data;
            } catch (DateTimeParseException e) {
                System.out.println(VERMELHO + "Formato inválido! Use dd/MM/yyyy." + RESET);
            }
        }
    }

    private static String lerEmailValido(Scanner scanner) {
        String email;
        do {
            email = lerTexto(scanner, "email");
            if (!validarEmail(email)) System.out.println(VERMELHO + "Email inválido!" + RESET);
        } while (!validarEmail(email));
        return email;
    }

    private static void aguardarEnter(Scanner scanner) {
        System.out.println(CIANO + "Pressione Enter para continuar..." + RESET);
        scanner.nextLine();
    }

    private static String obterNomePerfil(int perfil) {
        return perfil == PERFIL_CONSERVADOR ? "Conservador" :
                perfil == PERFIL_MODERADO ? "Moderado" : "Agressivo";
    }

    private static int perguntar(Scanner scanner, String pergunta, String opcoes) {
        System.out.println(pergunta);
        System.out.println(opcoes);
        return lerOpcaoNumerica(scanner, 1, 4);
    }

    private static int perguntarANBIMA(Scanner scanner, String pergunta, String opcoes) {
        return perguntar(scanner, pergunta, opcoes);
    }

    private static boolean validarCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    private static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(regex, email);
    }

    private static void imprimirCabecalho(double valor, int meses, int dias, double taxaDI, double taxaSELIC, String idSimulacao) {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        System.out.println(NEGRITO + "=== Investimento ===" + RESET);
        System.out.println("Valor da Aplicação: R$ " + df.format(valor));
        System.out.println("Vencimento: " + meses + " meses (" + dias + " dias)");
        System.out.println("Taxa SELIC: " + taxaSELIC + "% ao ano");
        System.out.println(AMARELO + "Simulação (id " + idSimulacao + ") - Rentabilidade por tipo de aplicação:" + RESET);
    }

    private static void imprimirOpcoesRendaFixa(double valor, double aporteMensal, int meses, double taxaDI) {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        System.out.println(AZUL + "=== Renda Fixa ===" + RESET);

        double rendimentoCDBBruto = calcularRendimentoCDB(valor, aporteMensal, meses, taxaDI, 100);
        double irCDB = calcularIRInvestimento(rendimentoCDBBruto, meses);
        double totalCDB = valor + (aporteMensal * meses) + (rendimentoCDBBruto - irCDB);
        System.out.println("CDB: Total R$ " + df.format(totalCDB));
    }

    private static void imprimirOpcoesRendaVariavel(double valor, double aporteMensal, int meses) {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        System.out.println(ROXO + "=== Renda Variável ===" + RESET);

        double rendimentoFIIBruto = calcularRendimentoFII(valor, aporteMensal, meses);
        double irFII = calcularIRInvestimento(rendimentoFIIBruto, meses);
        double totalFII = valor + (aporteMensal * meses) + (rendimentoFIIBruto - irFII);
        System.out.println("FIIs: Total R$ " + df.format(totalFII));
    }

    private static double calcularRendimentoPoupanca(double principal, double aporteMensal, int meses) {
        double taxaMensal = 0.005; // ~6% ao ano simplificado
        double total = principal;
        for (int i = 0; i < meses; i++) {
            total = total * (1 + taxaMensal) + aporteMensal;
        }
        return total - principal - (aporteMensal * meses);
    }

    private static double calcularRendimentoCDB(double principal, double aporteMensal, int meses, double taxaAnual, double percentualCDI) {
        double taxaMensal = Math.pow(1 + (taxaAnual * percentualCDI / 100) / 100, 1.0 / 12) - 1;
        double total = principal;
        for (int i = 0; i < meses; i++) {
            total = total * (1 + taxaMensal) + aporteMensal;
        }
        return total - principal - (aporteMensal * meses);
    }

    private static double calcularRendimentoLCI(double principal, double aporteMensal, int meses, double taxaAnual) {
        return calcularRendimentoCDB(principal, aporteMensal, meses, taxaAnual, 96); // 96% CDI
    }

    private static double calcularRendimentoTesouro(double principal, double aporteMensal, int meses, double taxaAnual) {
        return calcularRendimentoCDB(principal, aporteMensal, meses, taxaAnual, 100);
    }

    private static double calcularRendimentoFII(double principal, double aporteMensal, int meses) {
        double taxaMensal = 0.008; // ~10% ao ano simplificado
        double total = principal;
        for (int i = 0; i < meses; i++) {
            total = total * (1 + taxaMensal) + aporteMensal;
        }
        return total - principal - (aporteMensal * meses);
    }

    private static double calcularIRInvestimento(double rendimentoBruto, int meses) {
        double aliquota = meses <= 6 ? 0.225 : meses <= 12 ? 0.20 : meses <= 24 ? 0.175 : 0.15;
        return rendimentoBruto * aliquota;
    }

    // Database Interaction Methods (Simplified)
    private static void salvarUsuario(String id, String nome, String cpf, LocalDate dataNascimento, String genero, String email, String senha) throws SQLException {
        if (dbConnection == null) return; // Simulate in-memory storage
        String sql = "INSERT INTO usuarios (id, nome, cpf, data_nascimento, genero, email, senha) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, nome);
            stmt.setString(3, cpf);
            stmt.setDate(4, Date.valueOf(dataNascimento));
            stmt.setString(5, genero);
            stmt.setString(6, email);
            stmt.setString(7, senha); // In production, hash this
            stmt.executeUpdate();
        }
    }

    private static void salvarPerfilUsuario(String nome, int perfil) throws SQLException {
        if (dbConnection == null) return; // Simulate in-memory storage
        String sql = "INSERT INTO perfis (nome_usuario, perfil) VALUES (?, ?)";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setInt(2, perfil);
            stmt.executeUpdate();
        }
    }

    private static boolean autenticarUsuario(String email, String senha) throws SQLException {
        if (dbConnection == null) return true; // Dummy authentication
        String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ? AND senha = ?";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        }
    }

    private static String obterNomeUsuario(String email) throws SQLException {
        if (dbConnection == null) return "Usuario Teste";
        String sql = "SELECT nome FROM usuarios WHERE email = ?";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getString("nome") : "Usuario Teste";
        }
    }

    private static int obterPerfilUsuario(String email) throws SQLException {
        if (dbConnection == null) return PERFIL_MODERADO;
        String sql = "SELECT perfil FROM perfis WHERE nome_usuario = (SELECT nome FROM usuarios WHERE email = ?) ORDER BY data_atualizacao DESC LIMIT 1";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next() ? rs.getInt("perfil") : PERFIL_MODERADO;
        }
    }

    private static void atualizarNomeUsuario(String nomeAntigo, String nomeNovo) throws SQLException {
        if (dbConnection == null) return;
        String sql = "UPDATE usuarios SET nome = ? WHERE nome = ?";
        try (PreparedStatement stmt = dbConnection.prepareStatement(sql)) {
            stmt.setString(1, nomeNovo);
            stmt.setString(2, nomeAntigo);
            stmt.executeUpdate();
        }
    }

    // Investment Calculation Helper Class
    private static class ResultadoInvestimento {
        String nome;
        double rendimentoBruto;
        double imposto;
        double rendimentoLiquido;
        double totalLiquido;

        ResultadoInvestimento(String nome, double rendimentoBruto, double imposto, double totalLiquido) {
            this.nome = nome;
            this.rendimentoBruto = rendimentoBruto;
            this.imposto = imposto;
            this.rendimentoLiquido = rendimentoBruto - imposto;
            this.totalLiquido = totalLiquido;
        }
    }

    private static ResultadoInvestimento calcularInvestimento(String nome, double principal, double aporteMensal, int meses, double taxaMensal, double percentualCDI, boolean isentoIR) {
        double taxa = percentualCDI > 0 ? Math.pow(1 + (taxaMensal * percentualCDI / 100) / 100, 1.0 / 12) - 1 : taxaMensal;
        double total = principal;
        for (int i = 0; i < meses; i++) {
            total = total * (1 + taxa) + aporteMensal;
        }
        double rendimentoBruto = total - principal - (aporteMensal * meses);
        double imposto = isentoIR ? 0 : calcularIRInvestimento(rendimentoBruto, meses);
        return new ResultadoInvestimento(nome, rendimentoBruto, imposto, total);
    }

    private static void exibirResultados(List<ResultadoInvestimento> resultados, DecimalFormat df) {
        for (ResultadoInvestimento r : resultados) {
            System.out.println(r.nome);
            System.out.println("   Rendimento Bruto: R$ " + df.format(r.rendimentoBruto));
            System.out.println("   IR: " + (r.imposto == 0 ? "Isento" : "R$ " + df.format(r.imposto)));
            System.out.println("   Rendimento Líquido: R$ " + df.format(r.rendimentoLiquido));
            System.out.println("   Total Final: R$ " + df.format(r.totalLiquido));
            System.out.println();
        }
    }

    private static ResultadoInvestimento encontrarMelhorInvestimento(List<ResultadoInvestimento> resultados) {
        ResultadoInvestimento melhor = resultados.get(0);
        for (ResultadoInvestimento r : resultados) {
            if (r.rendimentoLiquido > melhor.rendimentoLiquido) melhor = r;
        }
        return melhor;
    }
}
