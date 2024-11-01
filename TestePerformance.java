public class TestePerformance {

    // atributos
    private BST bst;
    private AVL avl;

    // construtor
    public TestePerformance() {
        bst = new BST();
        avl = new AVL();
    }

    // métodos
    public void testeInsercao(int[] data) {

        long startTime, endTime;

        // inserção na BST
        startTime = System.nanoTime();
        for (int value : data) {
            bst.insert(value);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de inserção BST: " + (endTime - startTime) + " ns");


        // inserção AVL
        startTime = System.nanoTime();
        for(int value : data) {
            avl.insertAVL(value);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de inserção AVL: " + (endTime - startTime) + " ns");

    }

    public void testeBusca(int[] data) {

        long startTime, endTime;

        // busca na BST
        int comparacoesBST = 0;
        startTime = System.nanoTime();
        for (int value :  data) {
            comparacoesBST += bst.searchContagem(value);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de busca na BST: " + (endTime - startTime));
        System.out.println("Número de comparações BST: " + comparacoesBST);


        // busca na AVL
        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        for (int value : data) {
            comparacoesAVL += avl.searchContagem(value);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de busca na AVL: " + (endTime - startTime));
        System.out.println("Número de comparações AVL: " + comparacoesAVL);

    }


} // TestePerformance
