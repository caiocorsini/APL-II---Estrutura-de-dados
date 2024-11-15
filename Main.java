import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager database = new DatabaseManager();
        List<BST> databaseBST = null;
        List<AVL> databaseAVL = null;
        int totalInsertedItems = 0;

        boolean running = true;
        while (running) {
            System.out.println("---- Menu ----");
            System.out.println("1. Carregar dataset e criar árvores");
            System.out.println("2. Inserir dados na árvore (entre 1 e 100)");
            System.out.println("3. Fazer busca na árvore (entre 1 e 100)");
            System.out.println("4. Remover item da árvore (entre 1 e 100)");
            System.out.println("5. Sair");
            System.out.println("6. Imprimir tabela de análise por idioma (inglês ou espanhol)");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    databaseBST = null;
                    databaseAVL = null;

                    database.setDirectory("datasets");
                    database.readDirectory();
                    database.loadCSVs();
                    database.createTrees();
                    databaseAVL = database.getAVLdatabase();
                    databaseBST = database.getBSTdatabase();
                    totalInsertedItems = 0;
                    System.out.println("Dataset carregado e árvores recriadas.");
                    break;

                case 2:
                    if (databaseBST == null || databaseAVL == null) {
                        System.out.println("Erro: Carregue o dataset e crie as árvores primeiro.");
                    } else {
                        System.out.print("Digite o número de dados sintéticos a inserir (entre 1 e 100): ");
                        int numDados = scanner.nextInt();
                        if (numDados >= 1 && numDados <= 100) {
                            CSVreader leitorDadosSinteticos = new CSVreader();
                            leitorDadosSinteticos.openFile("datasets/sinteticos", "dados_sinteticos.csv");
                            leitorDadosSinteticos.readFile();
                            leitorDadosSinteticos.tokenizeFile();
                            List<Escola> dadosSinteticos = leitorDadosSinteticos.getCSVescolas().subList(0, numDados);

                            Resultado.exibirResultadoInsercao(dadosSinteticos, databaseBST, databaseAVL);
                            totalInsertedItems += numDados;
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    if (databaseBST == null || databaseAVL == null) {
                        System.out.println("Erro: Carregue o dataset e crie as árvores primeiro.");
                    } else {
                        System.out.print("Digite o número de dados sintéticos a buscar (entre 1 e 100): ");
                        int numDados = scanner.nextInt();
                        if (numDados >= 1 && numDados <= totalInsertedItems) {
                            CSVreader leitorDadosSinteticos = new CSVreader();
                            leitorDadosSinteticos.openFile("datasets/sinteticos", "dados_sinteticos.csv");
                            leitorDadosSinteticos.readFile();
                            leitorDadosSinteticos.tokenizeFile();
                            List<Escola> dadosSinteticos = leitorDadosSinteticos.getCSVescolas().subList(0, numDados);

                            Resultado.exibirMediaBusca(dadosSinteticos, databaseBST, databaseAVL);
                        } else {
                            System.out.println("Erro: O número de itens a buscar é maior do que o total inserido. Tente novamente.");
                        }
                    }
                    break;

                case 4:
                    if (databaseBST == null || databaseAVL == null) {
                        System.out.println("Erro: Carregue o dataset e crie as árvores primeiro.");
                    } else {
                        System.out.print("Digite o número de dados sintéticos a remover (entre 1 e 100): ");
                        int numDados = scanner.nextInt();
                        if (numDados >= 1 && numDados <= totalInsertedItems) {
                            CSVreader leitorDadosSinteticos = new CSVreader();
                            leitorDadosSinteticos.openFile("datasets/sinteticos", "dados_sinteticos.csv");
                            leitorDadosSinteticos.readFile();
                            leitorDadosSinteticos.tokenizeFile();
                            List<Escola> dadosSinteticos = leitorDadosSinteticos.getCSVescolas().subList(0, numDados);

                            Resultado.exibirResultadoRemocao(dadosSinteticos, databaseBST, databaseAVL);
                            totalInsertedItems -= numDados;
                        } else {
                            System.out.println("Erro: O número de itens a remover é maior do que o total inserido. Tente novamente.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    running = false;
                    break;

                case 6:
                    if (databaseBST == null) {
                        System.out.println("Erro: Carregue o dataset e crie as árvores primeiro.");
                    } else {
                        System.out.print("Digite o idioma (ingles ou espanhol): ");
                        scanner.nextLine(); // Consumir o newline
                        String idioma = scanner.nextLine();

                        if (!idioma.equalsIgnoreCase("ingles") && !idioma.equalsIgnoreCase("espanhol")) {
                            System.out.println("Idioma inválido. Tente novamente.");
                        } else {
                            System.out.println("Tabela de Alunos por Diretoria:");
                            AnaliseEscola.imprimirTabelaAlunosPorIdioma(idioma, databaseBST);
                        }
                    }
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
