public class Main {
    // Ctrl + k + c   para comentar varias linhas de uma vez só
    public static void main(String[] args) {

        // TESTES ALAN
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
    }



} // Main
