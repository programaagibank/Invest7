import java.text.DecimalFormat;

public class IN40 {
    static  DecimalFormat decFmt = new DecimalFormat("#,##0.00");
    public static void main(String[] args) {
        String[] ativos = {"CRI", "Tesouro Selic 2025", "CDB", "LCI/LCA",
                "HGLG11", "XPML11", "KNRI11", "WEGE3", "TAEE11", "VALE3" };

        double capitalInicial = 1000, aporteMensal = 100, selic = 0.135;
        int meses = 12;

        System.out.println("=== Renda Fixa Pré-Fixado ===");
        imprIsento(ativos, capitalInicial,aporteMensal, 0.01, meses, 0);
        imprNIsento(ativos, capitalInicial,aporteMensal, (selic/12), meses, 1);
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.01, meses, 2);
        imprIsento(ativos, capitalInicial,aporteMensal, 0.0075, meses, 3);

        System.out.println("=== Renda Fixa Pós-Fixado ===");
        imprIsento(ativos, capitalInicial,aporteMensal, 0.008, meses, 0);
        imprNIsento(ativos, capitalInicial,aporteMensal, (selic/12), meses, 1);
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.091, meses, 2);
        imprIsento(ativos, capitalInicial,aporteMensal, 0.0079, meses, 3);

        System.out.println("=== Fundo Imobiliário ===");
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.007, meses, 4);
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.006, meses, 5);
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.0065, meses, 6);

        System.out.println("=== Ações ===");
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.012, meses, 7);
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.01, meses, 8);
        imprNIsento(ativos, capitalInicial,aporteMensal, 0.008, meses, 9);
    }

    public static double calculoImpRenda (int meses) {
        double aliqIR;
        if (meses <= 6) aliqIR = 0.225;
        else if (meses <= 12) aliqIR = 0.20;
        else if (meses <= 25) aliqIR = 0.175;
        else aliqIR = 0.15;
        return aliqIR;
    }

    public static double calculoRendBruto (double valorInicial, double aporteM, double tx, int meses) {
        return valorInicial * Math.pow(1+tx, meses) + aporteM *((Math.pow(1+tx, meses) - 1)/tx);
    }
    public static double calculoRendLiq (double rendBrutoRF, double valorInicial, double impRenda) {
        return rendBrutoRF - ((rendBrutoRF - valorInicial) * impRenda);
    }

    public static void imprIsento(String [] ativos, double valorInicial, double aporteM, double tx, int meses, int i){
        double rendimento = calculoRendBruto (valorInicial, aporteM, tx, meses);
        System.out.println(ativos[i] + "\nRendimento Líquido: R$" + decFmt.format(rendimento) +
                "\nImposto de Renda: Isento\n" );

    }

    public static void imprNIsento(String [] ativos, double valorInicial, double aporteM, double tx, int meses, int i){
        double rendBruto = calculoRendBruto (valorInicial, aporteM, tx, meses);
        double impRenda = calculoImpRenda (meses);
        double rendLiq = calculoRendLiq (rendBruto, valorInicial, impRenda);
        System.out.println(ativos[i] + "\nRendimento Bruto: R$" +
                decFmt.format(rendBruto) + "\nImposto de Renda: " + decFmt.format(impRenda*100) +"%\n" +
                "Rendimento Liquido: R$" + decFmt.format(rendLiq) +"\n" );
    }




}
