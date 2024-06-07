public class Menu {

    public static void exibirMenu() {
        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("1. BRL (Real) para USD (Dólar Americano)");
        System.out.println("2. BRL (Real) para EUR (Euro)");
        System.out.println("3. BRL (Real) para GBP (Libra Esterlina)");
        System.out.println("4. BRL (Real) para JPY (Iene Japonês)");
        System.out.println("5. BRL (Real) para AUD (Dólar Australiano)");
        System.out.println("6. BRL (Real) para CAD (Dólar Canadense)");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static String obterMoedaDestino(int escolha) {
        return switch (escolha) {
            case 1 -> "USD";
            case 2 -> "EUR";
            case 3 -> "GBP";
            case 4 -> "JPY";
            case 5 -> "AUD";
            case 6 -> "CAD";
            default -> null;
        };
    }
}
