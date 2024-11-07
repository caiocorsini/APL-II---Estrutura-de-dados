import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager database = new DatabaseManager();
        List<BST> databaseBST = null;
        List<AVL> databaseAVL = null;

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

            int choice = scanner.nextInt(); // Lê a escolha do usuário
            switch (choice) {
                case 1:
                    // Carregar dataset e criar árvores
                    database.setDirectory("datasets");
                    database.readDirectory();
                    database.loadCSVs();
                    database.createTrees();
                    databaseAVL = database.getAVLdatabase();
                    databaseBST = database.getBSTdatabase();
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
                        System.out.print("Digite o número de código de escola para buscar (entre 1 e 100): ");
                        int codigo = scanner.nextInt();
                        if (codigo >= 1 && codigo <= 100) {
                            CSVreader leitorDadosSinteticos = new CSVreader();
                            leitorDadosSinteticos.openFile("datasets/sinteticos", "dados_sinteticos.csv");
                            leitorDadosSinteticos.readFile();
                            leitorDadosSinteticos.tokenizeFile();
                            List<Escola> dadosSinteticos = leitorDadosSinteticos.getCSVescolas().subList(0, 1);

                            Resultado.exibirMediaBusca(dadosSinteticos, databaseBST, databaseAVL);
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                    }
                    break;

                case 4:
                    // Remover item da árvore
                    if (databaseBST == null || databaseAVL == null) {
                        System.out.println("Erro: Carregue o dataset e crie as árvores primeiro.");
                    } else {
                        System.out.print("Digite o número de código de escola para remover (entre 1 e 100): ");
                        int codigo = scanner.nextInt();
                        if (codigo >= 1 && codigo <= 100) {
                            CSVreader leitorDadosSinteticos = new CSVreader();
                            leitorDadosSinteticos.openFile("datasets/sinteticos", "dados_sinteticos.csv");
                            leitorDadosSinteticos.readFile();
                            leitorDadosSinteticos.tokenizeFile();
                            List<Escola> dadosSinteticos = leitorDadosSinteticos.getCSVescolas().subList(0, 1);

                            Resultado.exibirResultadoRemocao(dadosSinteticos, databaseBST, databaseAVL);
                        } else {
                            System.out.println("Número inválido. Tente novamente.");
                        }
                    }
                    break;

                case 5:
                  
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
