import java.util.List;


public class Main {
    // Ctrl + k + c   para comentar varias linhas de uma vez só
    public static void main(String[] args) {

        // NOVOS TESTES ALAN
        DatabaseManager database = new DatabaseManager();
        database.setDirectory("datasets");
        database.readDirectory();
        database.loadCSVs();
        database.createTrees();

        List<AVL> databaseAVL = database.getAVLdatabase();
        List<BST> databaseBST = database.getBSTdatabase();

        int countAVL = 0;
        for (AVL avlTree : databaseAVL) {
            //avlTree.inOrderTraversal();
            countAVL++;
        }

        int countBST = 0;
        for (BST bstTree : databaseBST) {
            //bstTree.inOrderTraversal();
            countBST++;
        }
       //System.out.println(countAVL);
       // System.out.println(countBST);

       
        /* TESTES GILBERTO */ 

        // Pega a primeira BST e a primeira AVL das respectivas listas
        AVL primeiraAVL = databaseAVL.get(0);
        BST primeiraBST = databaseBST.get(0);
       //TestePerformance teste = new TestePerformance(primeiraBST, primeiraAVL);

        // Cria um objeto Escola com dados de exemplo
        Escola escolaExemplo = new Escola();
        escolaExemplo.setCdRede("SP");
        escolaExemplo.setDe("Diretoria de Ensino Sul 1");
        escolaExemplo.setCodMun("3550308");
        escolaExemplo.setMun("São Paulo");
        escolaExemplo.setCateg("Regular");
        escolaExemplo.setTipoEsc("Estadual");
        escolaExemplo.setCodEsc(1234512345); // Este será o identificador chave
        escolaExemplo.setNomEsc("Centro de Estudo de Línguas");
        
        // Preenche alguns dados de alunos e classes
        escolaExemplo.setAlAlemaoDu(10);
        escolaExemplo.setAlEspanholDu(20);
        escolaExemplo.setTotalAlDu(30);
        escolaExemplo.setClAlemaoDu(2);
        escolaExemplo.setClEspanholDu(3);
        escolaExemplo.setTotalClDu(5);
        escolaExemplo.setTotalTotalAl(30);
        escolaExemplo.setTotalTotalCl(5);

    //    teste.testeInsercao(escolaExemplo);
    //     teste.testeBusca(985004);
    //     teste.testeRemocao(1234512345);
        Resultado.exibirResultadoInsercao(escolaExemplo, primeiraBST, primeiraAVL);
        Resultado.exibirResultadoBusca(1234512345, primeiraBST, primeiraAVL);
        Resultado.exibirResultadoRemocao(1234512345, primeiraBST, primeiraAVL);
        


        


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
