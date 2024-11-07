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

   

        
       Resultado.exibirResultadoInsercao(dadosSinteticos, databaseBST, databaseAVL);
       Resultado.exibirMediaBusca(dadosSinteticos, databaseBST, databaseAVL);
       Resultado.exibirResultadoRemocao(dadosSinteticos, databaseBST, databaseAVL);
       


    

    
        
        // try {
        //     CsvExporter.exportarResultados("resultados.csv", escolaExemplo, 1234512345, databaseBST, databaseAVL);
        //     System.out.println("Exportação concluída com sucesso!");
        // } catch (IOException e) {
        //     System.err.println("Erro ao exportar os resultados para o arquivo CSV: " + e.getMessage());
        // }


        // for (BST bstTree : databaseBST ) {
        //     AnaliseEscola analise = new AnaliseEscola(bstTree);
        //     System.out.println(analise.getAlunosPorDiretoria("LESTE 1", "espanhol"));
        // }
    

        // for (BST bstTree : databaseBST) {
        //     AnaliseEscola analise = new AnaliseEscola(bstTree);
        //     String idioma = "espanhol";
        //     Map<String, Integer> alunosPorDiretoria = analise.getAlunosParaTodasDiretorias(idioma);
        //     // Imprime o total de alunos por diretoria
        //     System.out.println("Total de alunos no idioma " + idioma + " por diretoria:");
        //     for (Map.Entry<String, Integer> entry : alunosPorDiretoria.entrySet()) {
        //         System.out.println("Diretoria: " + entry.getKey() + " - Total de Alunos: " + entry.getValue());
        //     }   
        // }

        /*
        String idioma = "ingles";

        for (int i = 0; i < databaseBST.size(); i++) {
            BST bstTree = databaseBST.get(i);
            AnaliseEscola analise = new AnaliseEscola(bstTree);

            // Calcula o ano e o semestre
            int year = 2019 + (i / 2);
            int semester = (i % 2) + 1;

            // Obtém o total de alunos para todas as diretorias no idioma especificado
            Map<String, Integer> alunosPorDiretoria = analise.getAlunosParaTodasDiretorias(idioma);

            // Imprime o resultado com a informação de ano e semestre
            System.out.println("Ano: " + year + " - Semestre: " + semester);
            System.out.println("Total de alunos no idioma " + idioma + " por diretoria:");
            for (Map.Entry<String, Integer> entry : alunosPorDiretoria.entrySet()) {
                System.out.println("Diretoria: " + entry.getKey() + " - Total de Alunos: " + entry.getValue());
            }
            System.out.println(); // Linha em branco para separar cada semestre
        }


        String filePath = "resultados_escolas.csv";

        AnaliseEscola.exportarDadosParaCSV(filePath, databaseBST);

        */
        
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
