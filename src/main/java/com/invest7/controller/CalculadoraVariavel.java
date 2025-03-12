import java.util.Scanner;
import java.text.DecimalFormat;


public class CalculadoraVariavel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SimualarFundoImobiliario(scanner);
        SimualarAcao(scanner);
        scanner.close();
    }
    public static void SimualarFundoImobiliario(Scanner scanner) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double saldoDividendos = 0;



        System.out.print("Digite o preço do ativo: R$ ");
        System.out.println();
        double precoCota = 100; // scanner.nextDouble();


        System.out.print("Digite a quantidade de cotas compradas: ");
        int quantidadeCotas = 1; // scanner.nextInt();


        System.out.print("Digite o dividendo mensal por ação: R$ ");
        double dividendoPorCota = 10; //scanner.nextDouble();


        System.out.print("Digite o número de meses para a simulação: ");
        int meses = 5; // scanner.nextInt();


        System.out.print("digite o valor do aporte: R$ ");
        double valorAporte = 100; // scanner.nextDouble();


        System.out.print("Deseja reinvestir os dividendos? (s/n): ");
        char reinvestir = scanner.next().toLowerCase().charAt(0);




        System.out.println("\nSimulação do rendimento dos dividendos:\n");
        System.out.println("Mês\tCotas\tDividendos\t\tSaldo");


        for (int i = 1; i <= meses; i++) {
            double dividendosRecebidos = quantidadeCotas * dividendoPorCota;
            saldoDividendos += dividendosRecebidos + valorAporte;


            if (reinvestir == 's') {
                int novasCotas = (int) (saldoDividendos / precoCota);
                quantidadeCotas += novasCotas;
                saldoDividendos -= novasCotas * precoCota;
            } else {

                int novasCotasAporte = (int) (valorAporte / precoCota);
                quantidadeCotas += novasCotasAporte;
                saldoDividendos -= novasCotasAporte * precoCota;
            }


            System.out.println(i + "\t" + quantidadeCotas + "\t\tR$ " + df.format(dividendosRecebidos) + "\t\tR$ " + df.format(saldoDividendos));
        }


        System.out.println("\nTotal de cotas ao final da simulação: " + quantidadeCotas);
        double saldoCotas = quantidadeCotas*precoCota;
        double desvioCota = saldoCotas * 0.04 ;
        System.out.println("Saldo em cotas: entre R$ " + df.format((saldoCotas - desvioCota)) + " e " + df.format((saldoCotas + desvioCota)));
        double desvioDiv = saldoDividendos * 0.04;
        System.out.println("Saldo em dividendos com desvio: R$ " + df.format(saldoDividendos - desvioDiv) + " até " + df.format(saldoDividendos + desvioDiv) );
        System.out.println();


    }
    public static void SimualarAcao(Scanner scanner) {
        DecimalFormat df = new DecimalFormat("#,##0.00");


        System.out.print("Digite o preço de compra da ação: R$ ");
        double precoCompra = 10;// scanner.nextDouble();


        System.out.print("Digite o preço de venda da ação: R$ ");
        double precoVenda = 20;// scanner.nextDouble();


        System.out.print("Digite a quantidade de ações compradas: ");
        int quantidade = 10;//scanner.nextInt();


        double custoTotal = precoCompra * quantidade;
        double valorVenda = precoVenda * quantidade;
        double saldo = valorVenda - custoTotal;




        System.out.println("\nResumo da operação:");
        System.out.println("Custo total: R$ " + df.format(custoTotal));
        System.out.println("Valor da venda: R$ " + df.format(valorVenda));


        if (saldo > 0) {
            System.out.println("Lucro: R$ " + df.format(saldo));
        } else if (saldo < 0) {
            System.out.println("Prejuízo: R$ " + df.format(Math.abs(saldo)));
        } else {
            System.out.println("Você não teve lucro nem prejuízo.");
        }
        scanner.close();
    }
}
