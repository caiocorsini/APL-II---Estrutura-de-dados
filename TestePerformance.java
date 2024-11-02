public class TestePerformance {

    // atributos
    private BST bst;
    private AVL avl;

    // construtor
    public TestePerformance(BST bst, AVL avl) {
        this.bst = bst;
        this.avl = avl;
    }

    // métodos
    public void testeInsercao(Escola data) {

        long startTime, endTime;
    
        // Insertion in BST
        startTime = System.nanoTime();
        bst.insert(data);
        endTime = System.nanoTime();
        System.out.println("Tempo de inserção BST: " + (endTime - startTime) + " ns");
    
        // Insertion in AVL
        startTime = System.nanoTime();
        avl.insertAVL(data);
        endTime = System.nanoTime();
        System.out.println("Tempo de inserção AVL: " + (endTime - startTime) + " ns\n");
    }
    


    public void testeBusca(int codigoEscola) {

        long startTime, endTime;
    
        // BST search
        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.searchContagem(codigoEscola);
        endTime = System.nanoTime();
        System.out.println("Tempo de busca na BST: " + (endTime - startTime) + " ns");
        System.out.println("Número de comparações BST: " + comparacoesBST + "\n");
    
        // AVL search
        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.searchContagem(codigoEscola);
        endTime = System.nanoTime();
        System.out.println("Tempo de busca na AVL: " + (endTime - startTime) + " ns");
        System.out.println("Número de comparações (busca) AVL: " + comparacoesAVL + "\n");
    }
    

    public void testeRemocao(int codigoEscola) {
        long startTime, endTime;
    
        // Removal in BST
        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.removeContagem(codigoEscola);
        endTime = System.nanoTime();
        System.out.println("Tempo de remoção BST: " + (endTime - startTime) + " ns");
        System.out.println("Número de comparações (remoção) BST: " + comparacoesBST + "\n");
    
        // Removal in AVL
        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.removeContagem(codigoEscola);
        endTime = System.nanoTime();
        System.out.println("Tempo de remoção AVL: " + (endTime - startTime) + " ns");
        System.out.println("Número de comparações (remoção) AVL: " + comparacoesAVL + "\n");
    }
    


} // TestePerformance
