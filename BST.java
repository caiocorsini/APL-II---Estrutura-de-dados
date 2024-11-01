import java.util.LinkedList;
import java.util.Queue;
public class BST{
    Node root;

    // Construtor
    BST(){
        root = null;
    }

    // Travessia em ordem
    void inOrderTraversal(){
        if(root==null) return;
        inOrderTraversalAux(root);
    }

    private void inOrderTraversalAux(Node currentNode){
        if(currentNode == null) return;
        if(currentNode.hasLeftChild()) inOrderTraversalAux(currentNode.getLeft());
        System.out.printf("%d ", currentNode.getData().getCodEsc());
        if(currentNode.hasRightChild()) inOrderTraversalAux(currentNode.getRight());
    }

    // Travessia pre-ordem
    void preOrderTraversal(){
        if(root==null) return;
        preOrderTraversalAux(root);
    }

    private void preOrderTraversalAux(Node currentNode){
        if(currentNode == null) return;
        System.out.printf("%d ", currentNode.getData().getCodEsc());
        if(currentNode.hasLeftChild()) preOrderTraversalAux(currentNode.getLeft());
        if(currentNode.hasRightChild()) preOrderTraversalAux(currentNode.getRight());
    }

    // Travessia pos-ordem
    void postOrderTraversal(){
        if(root==null) return;
        postOrderTraversalAux(root);
    }

    private void postOrderTraversalAux(Node currentNode){
        if(currentNode == null) return;
        if(currentNode.hasLeftChild()) postOrderTraversalAux(currentNode.getLeft());
        if(currentNode.hasRightChild()) postOrderTraversalAux(currentNode.getRight());
        System.out.printf("%d ", currentNode.getData().getCodEsc());
    }

    // Travessia em nível
    void levelOrderTraversal(){
        if(root==null) return;
        levelOrderTraversalAux(root);
    }

    private void levelOrderTraversalAux(Node currentNode){
        if(currentNode == null) return;
        Queue<Node> queue = new LinkedList<>();  // Fila implementada com linked list
        queue.add(currentNode);
        while(!queue.isEmpty()){
            System.out.printf("%d ", queue.peek().getData().getCodEsc());
            currentNode = queue.remove();
            if(currentNode.hasLeftChild()) queue.add(currentNode.getLeft());
            if(currentNode.hasRightChild()) queue.add(currentNode.getRight());
        }
    }

    // Para inserir novos nós (sem respeitar AVL)
    void insert(Escola value){
        root = insertAux(root, null, value);
    }

    private Node insertAux(Node currentNode, Node parentNode, Escola value){
        Node newNode = new Node(value);
        newNode.setParent(parentNode);
        if(currentNode==null) return newNode;
        if(value.getCodEsc()<currentNode.getData().getCodEsc()) currentNode.setLeft(insertAux(currentNode.getLeft(), currentNode, value));
        else currentNode.setRight(insertAux(currentNode.getRight(), currentNode, value));
        return currentNode;
    }


    // Busca por elementos na arvore
    Node search(int value){
        if(root==null) return null;
        return searchAux(root, value);
    }

    private Node searchAux(Node currentNode, int value){
        if(currentNode.getData().getCodEsc() == value) return currentNode;
        if(value>currentNode.getData().getCodEsc()) return searchAux(currentNode.getRight(), value);
        if(value<currentNode.getData().getCodEsc()) return searchAux(currentNode.getLeft(), value);
        return null;
    }

    // Busca por elementos na arvore
    int searchContagem(int value){
        if(root==null) return 0;
        Contagem n = new Contagem();
        searchContagemAux(root, value, n);
        return n.getN();
    }

    private void searchContagemAux(Node currentNode, int value, Contagem n){
        if(currentNode.getData().getCodEsc() == value) return;
        n.adicionar();
        if(value>currentNode.getData().getCodEsc()) searchContagemAux(currentNode.getRight(), value, n);
        if(value<currentNode.getData().getCodEsc()) searchContagemAux(currentNode.getLeft(), value, n);
        return;
    }


    Node getMax(){
        return getMaxAux(root);
    }

    private Node getMaxAux(Node currentNode){
        if(currentNode == null) return null;
        if(currentNode.hasRightChild()) return getMaxAux(currentNode.getRight());
        else return currentNode;
    }

    // Retorna o node com o menor codigo de escola da arvore.
    Node getMin(){
        return getMinAux(root);
    }

    private Node getMinAux(Node currentNode){
        if(currentNode == null) return null;
        if(currentNode.hasLeftChild()) return getMinAux(currentNode.getLeft());
        else return currentNode;
    }


    // Acha o sucessor de um nó
    Node getSuccessor(Node currentNode){
        if(currentNode.hasRightChild()) return getMinAux(currentNode.getRight()); // Vai para a subarvore se tiver
        Node parentNode = currentNode.getParent();
        while(parentNode!=null && parentNode.getRight() == currentNode){ // Sobe se não tiver subarvore
            currentNode = parentNode;
            parentNode = currentNode.getParent();
        }
        return parentNode;
    }

    // Acha o antecessor de um nó
    Node getAntecessor(Node currentNode){
        if(currentNode.hasLeftChild()) return getMaxAux(currentNode.getLeft()); // Vai para a subarvore se tiver
        Node parentNode = currentNode.getParent();
        while(parentNode!=null && parentNode.getLeft() == currentNode){ // Sobe se não tiver subarvore
            currentNode = parentNode;
            parentNode = currentNode.getParent();
        }
        return parentNode;
    }


    // Remove um nó com determinado valor
    void removeNode(Escola value){
        Node nodeToRemove = search(value.getCodEsc());
        if(nodeToRemove == null) return;
        Node parentNode = nodeToRemove.getParent();
        if(nodeToRemove.isLeaf()){
            if(parentNode != null){
                if(parentNode.getRight() == nodeToRemove) parentNode.setRight(null);
                else if(parentNode.getLeft() == nodeToRemove) parentNode.setLeft(null);
            } else root = null;
            return;
        }

        if(nodeToRemove.getDegree() == 1){
            nodeToRemove.setParent(null);
            Node aux;
            if(nodeToRemove.hasLeftChild()) {
                aux = nodeToRemove.getLeft();
                nodeToRemove.setLeft(null);
            }
            else {
                aux = nodeToRemove.getRight();
                nodeToRemove.setRight(null);
            }
            if(parentNode.getRight() == nodeToRemove) parentNode.setRight(aux);
            if(parentNode.getLeft() == nodeToRemove) parentNode.setLeft(aux);
            return;
        }

        if(nodeToRemove.getDegree() == 2){
            Escola successorData = getSuccessor(nodeToRemove).getData();
            removeNode(successorData);
            nodeToRemove.setData(successorData);
        }
    }

    /*
    Realiza a remoção, e retorna o número de comparações realizadas
    * */
    public int removeContagem(int val) {
        int comparacoes = 0;
        root = removeRec(root, val, comparacoes);
        return comparacoes;
    }

    private Node removeRec(Node curr, int val, int comparacoes) {
        if (curr == null)
            return null;

        comparacoes += 1;
        if (val < curr.getData()) {
            curr.setLeft(removeRec(curr.getLeft(), val , comparacoes));
        } else if (val > curr.getData()) {
            curr.setRight(removeRec(curr.getRight(), val, comparacoes));
        } else {
            // se o nó é uma folha
            if (curr.getLeft() == null && curr.getRight() == null) {
                return null;
            } else if (curr.getLeft() == null) { // nó tem somente um filho
                return curr.getRight();
            } else if (curr.getRight() == null) {
                return curr.getLeft();
            } else { // nó tem dois filhos
                Node successor = getSuccessor(curr);
                curr.setData(successor.getData());
                curr.setRight(removeRec(curr.getRight(), successor.getData(), comparacoes));
            }

        }
        return curr;
    }

} // BST