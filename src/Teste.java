import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Banco mabson = new Banco();
        mabson.nomeCliente = "Mabson Freire";
        mabson.tipoDeConta = "Corrente";
        mabson.saldoInicial = 1000.0;

        mabson.informacoes();
        mabson.operacao();
    }
}
