import java.util.Scanner;
import java.text.DecimalFormat;


public class CalculadoraVariavel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double saldoDividendos = 0;


        System.out.print("Digite o preço do ativo: R$ ");
        double precoAtivo = scanner.nextDouble();


        System.out.print("Digite a quantidade de cotas compradas: ");
        int quantidadeCotas = scanner.nextInt();


        System.out.print("Digite o dividendo mensal por ação: R$ ");
        double dividendoPorAcao = scanner.nextDouble();


        System.out.print("Digite o número de meses para a simulação: ");
        int meses = scanner.nextInt();


        System.out.print("Deseja reinvestir os dividendos? (s/n): ");
        char reinvestir = scanner.next().toLowerCase().charAt(0);


        System.out.println("\nSimulação do rendimento dos dividendos:\n");
        System.out.println("Mês\tCotas\tDividendos\t\tSaldo");


        for (int i = 1; i <= meses; i++) {
            double dividendosRecebidos = quantidadeCotas * dividendoPorAcao;
            saldoDividendos += dividendosRecebidos;


            if (reinvestir == 's') {
                int novasCotas = (int) (saldoDividendos / precoAtivo);
                quantidadeCotas += novasCotas;
                saldoDividendos -= novasCotas * precoAtivo;
            }


            System.out.println(i + "\t" + quantidadeCotas + "\t\tR$ " + df.format(dividendosRecebidos) + "\t\tR$ " + df.format(saldoDividendos));
        }


        System.out.println("\nTotal de cotas ao final da simulação: " + quantidadeCotas);
        System.out.println("Saldo em cotas: R$ " + quantidadeCotas*precoAtivo);
        System.out.println("Saldo em dividendos: R$ " + df.format(saldoDividendos));


        scanner.close();
    }
}

