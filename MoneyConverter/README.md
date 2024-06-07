# Conversor de Moedas

Este projeto foi desenvolvido no âmbito do Programa ONE - Oracle Next Education em conjunto com a Alura.

## Objetivo

O objetivo deste projeto é desenvolver um Conversor de Moedas que ofereça interação textual (via console) com os usuários. O programa proporciona no mínimo 6 opções distintas de conversões de moedas em um menu. A taxa de conversão não é estática, mas sim dinamicamente obtida por meio de uma API, garantindo dados precisos e em tempo real para uma experiência mais atualizada e eficaz.

## Funcionalidades

- Conversão de BRL (Real) para USD (Dólar Americano), EUR (Euro), GBP (Libra Esterlina), JPY (Iene Japonês), AUD (Dólar Australiano) e CAD (Dólar Canadense).
- As taxas de conversão são obtidas dinamicamente utilizando a API Exchange Rate.

## Estrutura do Projeto

O projeto está dividido nas seguintes classes:

1. **ConversorMoedas**: Classe principal que contém o método `main` e gerencia o loop do menu.
2. **ApiService**: Classe responsável por fazer as requisições à API e obter as taxas de câmbio.
3. **Conversor**: Classe responsável por realizar a conversão de moedas.
4. **Menu**: Classe responsável por exibir o menu e obter a escolha do usuário.

## Como Executar

1. Certifique-se de ter o [JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado.
2. Clone este repositório.
3. Navegue até o diretório do projeto e compile os arquivos `.java`:   javac *.java
4. Execute o programa: 
java ConversorMoedas

## Dependências
Gson: Biblioteca para trabalhar com JSON.
HttpClient: Cliente HTTP para enviar solicitações à API.

## API Utilizada
Exchange Rate API: API utilizada para obter as taxas de câmbio em tempo real.

## Exemplo de Uso
1. Ao executar o programa, o menu será exibido:

Bem-vindo ao Conversor de Moedas!
1 BRL (Real) para USD (Dólar Americano)
2 BRL (Real) para EUR (Euro)
3 BRL (Real) para GBP (Libra Esterlina)
4 BRL (Real) para JPY (Iene Japonês)
5 BRL (Real) para AUD (Dólar Australiano)
6 BRL (Real) para CAD (Dólar Canadense)
7 Sair
Escolha uma opção:

2. Escolha a moeda para a qual deseja converter e insira o valor em BRL.

3. O programa exibirá o valor convertido com duas casas decimais.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a MIT License.