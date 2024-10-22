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
        arvore.insert(-1);
        arvore.insert(-2);
    }

    public static void gerarAVL(AVL arvore){
        arvore.insertAVL(0);
        arvore.insertAVL(2);
        arvore.insertAVL(3);
        arvore.insertAVL(1);
        arvore.insertAVL(4);
        arvore.insertAVL(5);
        arvore.insertAVL(6);
        arvore.insertAVL(-1);
        arvore.insertAVL(-2);
    }



    public static void main(String[] args) {
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
        arvore2.preOrderTraversal();
        System.out.printf("\nroot: %d", arvore2.root.data);
    }
}
