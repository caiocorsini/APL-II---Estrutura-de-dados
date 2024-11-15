import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager database = new DatabaseManager();
        List<BST> databaseBST = null;
        List<AVL> databaseAVL = null;
        int totalInsertedItems = 0; // Variável para rastrear o número total de itens inseridos

        boolean running = true;
        while (running) {
            // Exibir menu
            System.out.println("---- Menu ----");
            System.out.println("1. Carregar dataset e criar árvores");
            System.out.println("2. Inserir dados na árvore (entre 1 e 100)");
            System.out.println("3. Fazer busca na árvore (entre 1 e 100)");
            System.out.println("4. Remover item da árvore (entre 1 e 100)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Carregar dataset e criar árvores
                    database.setDirectory("datasets");
                    database.readDirectory();
                    database.loadCSVs();
                    database.createTrees();
                    databaseAVL = database.getAVLdatabase();
                    databaseBST = database.getBSTdatabase();
                    totalInsertedItems = 0; // Reinicia o contador de inserções
                    System.out.println("Dataset carregado e árvores criadas.");
                    break;

                case 2:
                    // Inserir dados na árvore
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
                            totalInsertedItems += numDados; // Atualiza o contador de itens inseridos
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    // Fazer busca na árvore
                    if (databaseBST == null || databaseAVL == null) {
                        System.out.println("Erro: Carregue o dataset e crie as árvores primeiro.");
                    } else {
                        System.out.print("Digite o número de dados sintéticos a buscar (entre 1 e 100): ");
                        int numDados = scanner.nextInt();
                        
                        // Verifica se o número de buscas desejadas não excede o total de itens inseridos
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
                    // Remover item da árvore
                    if (databaseBST == null || databaseAVL == null) {
                        System.out.println("Erro: Carregue o dataset e crie as árvores primeiro.");
                    } else {
                        System.out.print("Digite o número de dados sintéticos a remover (entre 1 e 100): ");
                        int numDados = scanner.nextInt();
                        
                        // Verifica se o número de remoções desejadas não excede o total de itens inseridos
                        if (numDados >= 1 && numDados <= totalInsertedItems) {
                            CSVreader leitorDadosSinteticos = new CSVreader();
                            leitorDadosSinteticos.openFile("datasets/sinteticos", "dados_sinteticos.csv");
                            leitorDadosSinteticos.readFile();
                            leitorDadosSinteticos.tokenizeFile();
                            List<Escola> dadosSinteticos = leitorDadosSinteticos.getCSVescolas().subList(0, numDados);

                            Resultado.exibirResultadoRemocao(dadosSinteticos, databaseBST, databaseAVL);
                            totalInsertedItems -= numDados; // Atualiza o contador de itens após a remoção
                        } else {
                            System.out.println("Erro: O número de itens a remover é maior do que o total inserido. Tente novamente.");
                        }
                    }
                    break;

                case 5:
                    // Sair
                    System.out.println("Saindo do programa...");
                    running = false;
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
