import java.util.Scanner;

public class ConversorMoedas {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            Menu.exibirMenu();
            int escolha = scanner.nextInt();

            if (escolha == 7) {
                System.out.println("Saindo...");
                break;
            }

            String moedaDestino = Menu.obterMoedaDestino(escolha);
            if (moedaDestino != null) {
                realizarConversao(moedaDestino);
            } else {
                System.out.println("Opção inválida!");
            }

            if (!desejaContinuar()) {
                System.out.println("Saindo...");
                break;
            }
        }

        scanner.close();
    }

    private static void realizarConversao(String moedaDestino) {
        try {
            String respostaJson = ApiService.obterTaxasDeCambio();
            double taxaDeCambio = ApiService.parseTaxaDeCambio(respostaJson, moedaDestino);

            System.out.print("Insira o valor em BRL: ");
            double valor = scanner.nextDouble();

            double valorConvertido = Conversor.converter(valor, taxaDeCambio);
            System.out.printf("Valor convertido: %.2f %s%n", valorConvertido, moedaDestino);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean desejaContinuar() {
        while (true) {
            System.out.print("Deseja fazer uma nova conversão? (s/n): ");
            String resposta = scanner.next();
            if (resposta.equalsIgnoreCase("s")) {
                return true;
            } else if (resposta.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Opção inválida! Por favor, digite 's' para sim ou 'n' para não.");
            }
        }
    }
}
