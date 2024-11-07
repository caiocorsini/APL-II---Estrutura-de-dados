import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Main {
    // Ctrl + k + c   para comentar varias linhas de uma vez só
    public static void main(String[] args) {

        // carregar dataset e criar as 2 listas contendo as
        // respectivas BSTs e AVLs
        DatabaseManager database = new DatabaseManager();
        database.setDirectory("datasets");
        database.readDirectory();
        database.loadCSVs();
        database.createTrees();

        List<AVL> databaseAVL = database.getAVLdatabase();
        List<BST> databaseBST = database.getBSTdatabase();

        // carregar dados sintéticos
        CSVreader leitorDadosSinteticos = new CSVreader();
        leitorDadosSinteticos.openFile("datasets/sinteticos", "dados_sinteticos.csv");
        leitorDadosSinteticos.readFile();
        leitorDadosSinteticos.tokenizeFile();

        List<Escola> dadosSinteticos = leitorDadosSinteticos.getCSVescolas(); // Obtém todas as escolas
   
       // exibir resultados das performances das arvores         
    //    Resultado.exibirResultadoInsercao(dadosSinteticos, databaseBST, databaseAVL);
    //    Resultado.exibirMediaBusca(dadosSinteticos, databaseBST, databaseAVL);
    //    Resultado.exibirResultadoRemocao(dadosSinteticos, databaseBST, databaseAVL);

    

        AnaliseEscola.imprimirTabelaAlunosPorIdioma("espanhol", databaseBST);


        // String filePath = "resultados_escolas.csv";

        // AnaliseEscola.exportarDadosParaCSV(filePath, databaseBST);

        
        
        // TESTES ALAN
        /*
        CSVreader CSVteste = new CSVreader();
        CSVteste.openFile("/datasets/Alunos_Cel_2019_2.csv");
        CSVteste.readFile();
        CSVteste.tokenizeFile();

        //System.out.println("Qtd escolas: "+CSVteste.getQtdLines());
        //System.out.println(CSVteste.getCSVlines());
        CSVteste.getCSVlines().forEach(System.out::println);
        //System.out.println("Qtd escolas: "+CSVteste.getQtdEscolas());
        //System.out.println(CSVteste.getCSVescolas());
        CSVteste.getCSVescolas().forEach(escola -> escola.printEscolas(1));

        AVL arvoreAVL = new AVL();
        BST arvoreBST = new BST();
        
        // como será a inserção nas árvores (assumindo que CSV foi aberto, lido e tokenizado)
        for (int i = 0; i < CSVteste.getQtdEscolas(); i++) {
            Escola currentEscola = CSVteste.getCSVescolas().get(i);
            arvoreAVL.insertAVL(currentEscola);
            arvoreBST.insert(currentEscola);
        }
        
        
        System.out.printf("%d\n", arvoreAVL.root.getHeight());
        System.out.printf("%d\n", arvoreBST.root.getHeight());
         */
    }



} // Main
