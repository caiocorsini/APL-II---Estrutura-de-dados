public class Main {
    // Ctrl + k + c   para comentar varias linhas de uma vez só

    public static void gerarBST(BST arvore){
        arvore.insert(0);
        arvore.insert(2);
        arvore.insert(3);
        arvore.insert(1);
        arvore.insert(4);
        arvore.insert(5);
        arvore.insert(6);
        arvore.insert(10);
        arvore.insert(12);

        arvore.insert(101);
        arvore.insert(102);
        arvore.insert(103);
        arvore.insert(104);
        arvore.insert(105);
        arvore.insert(106);
        arvore.insert(107);
        arvore.insert(108);
        arvore.insert(109);
    }

    public static void gerarAVL(AVL arvore){
        arvore.insertAVL(0);
        arvore.insertAVL(2);
        arvore.insertAVL(3);
        arvore.insertAVL(1);
        arvore.insertAVL(4);
        arvore.insertAVL(5);
        arvore.insertAVL(6);
        arvore.insertAVL(10);
        arvore.insertAVL(12);

        arvore.insertAVL(101);
        arvore.insertAVL(102);
        arvore.insertAVL(103);
        arvore.insertAVL(104);
        arvore.insertAVL(105);
        arvore.insertAVL(106);
        arvore.insertAVL(107);
        arvore.insertAVL(108);
        arvore.insertAVL(109);
    }



    public static void main(String[] args) {

        // TESTES ALAN
        CSVreader CSVteste = new CSVreader();
        CSVteste.openFile("teste1.csv");
        CSVteste.readFile();
        CSVteste.tokenizeFile();

        System.out.println("Qtd escolas: "+CSVteste.getQtdLines());
        //System.out.println(CSVteste.getCSVlines());
        CSVteste.getCSVlines().forEach(System.out::println);
        System.out.println("Qtd escolas: "+CSVteste.getQtdEscolas());
        //System.out.println(CSVteste.getCSVescolas());
        CSVteste.getCSVescolas().forEach(escola -> escola.printEscolas(1));

        // como será a inserção nas árvores (assumindo que CSV foi aberto, lido e tokenizado)
        for (int i = 0; i < CSVteste.getQtdEscolas(); i++) {
            Escola currentEscola = CSVteste.getCSVescolas().get(i);
            Node currentNode = new Node(currentEscola);
            // aqui, ou fazemos com que o proprio construtor do Node leia o codEscola da Escola e atribua o valor à chave, ou fazemos "manualmente"
            arvoreAVL.insert(currentNode);
            arvoreBST.insert(currentNode);
        }
        
        // TESTES CAIO
        /*
        BST arvore = new BST();
        AVL arvore2 = new AVL();
        gerarBST(arvore);
        gerarAVL(arvore2);
        //arvore.levelOrderTraversal();
        //System.out.printf("%d", arvore.search(3).right.data);
        //System.out.printf("%d", arvore.getMin().data);
        //Node exemplo = arvore.search(0); System.out.printf("%d", arvore.getSuccessor(exemplo).data);
        // Node exemplo = arvore.search(0); System.out.printf("%d", arvore.getAntecessor(exemplo).data);
        // arvore.removeNode(0);
        // arvore.inOrderTraversal();
        arvore.preOrderTraversal();
        System.out.printf("\nroot BST: %d\n", arvore.root.getData());
        System.out.printf("altura BST: %d\n", arvore.root.getHeight());
        System.out.printf("n de nos para achar 109: %d\n\n", arvore.searchContagem(109));
        arvore2.preOrderTraversal();
        System.out.printf("\nroot AVL: %d\n", arvore2.root.getData());
        System.out.printf("altura BST: %d\n", arvore2.root.getHeight());
        System.out.printf("n de nos para achar 109: %d\n\n", arvore2.searchContagem(109));
         */
    }
}
