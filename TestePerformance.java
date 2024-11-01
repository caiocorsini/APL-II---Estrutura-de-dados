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

        // busca

    }


} // TestePerformance
