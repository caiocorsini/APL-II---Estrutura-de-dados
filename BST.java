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
        if(currentNode.hasLeftChild()) inOrderTraversalAux(currentNode.left);
        System.out.printf("%d ", currentNode.data);
        if(currentNode.hasRightChild()) inOrderTraversalAux(currentNode.right);
    }

    // Travessia pre-ordem
    void preOrderTraversal(){
        if(root==null) return;
        preOrderTraversalAux(root);
    }

    private void preOrderTraversalAux(Node currentNode){
        if(currentNode == null) return;
        System.out.printf("%d ", currentNode.data);
        if(currentNode.hasLeftChild()) preOrderTraversalAux(currentNode.left);
        if(currentNode.hasRightChild()) preOrderTraversalAux(currentNode.right);
    }

    // Travessia pos-ordem
    void postOrderTraversal(){
        if(root==null) return;
        postOrderTraversalAux(root);
    }

    private void postOrderTraversalAux(Node currentNode){
        if(currentNode == null) return;
        if(currentNode.hasLeftChild()) postOrderTraversalAux(currentNode.left);
        if(currentNode.hasRightChild()) postOrderTraversalAux(currentNode.right);
        System.out.printf("%d ", currentNode.data);
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
            System.out.printf("%d ", queue.peek().data);
            currentNode = queue.remove();
            if(currentNode.hasLeftChild()) queue.add(currentNode.left);
            if(currentNode.hasRightChild()) queue.add(currentNode.right);
        }
    }

    // Para inserir novos nós (sem respeitar AVL)
    void insert(int value){
        root = insertAux(root, null, value);
    }

    private Node insertAux(Node currentNode, Node parentNode, int value){
        Node newNode = new Node(value);
        newNode.parent = parentNode;
        if(currentNode==null) return newNode;
        if(value<currentNode.data) currentNode.left = insertAux(currentNode.left, currentNode, value);
        else currentNode.right = insertAux(currentNode.right, currentNode, value);
        return currentNode;
    }


    // Busca por elementos na arvore
    Node search(int value){
        if(root==null) return null;
        return searchAux(root, value);
    }

    private Node searchAux(Node currentNode, int value){
        if(currentNode.data == value) return currentNode;
        if(value>currentNode.data) return searchAux(currentNode.right, value);
        if(value<currentNode.data) return searchAux(currentNode.left, value);
        return null;
    }

    // Retorna o maior elemento da arvore.
    Node getMax(){
        return getMaxAux(root);
    }

    private Node getMaxAux(Node currentNode){
        if(currentNode == null) return null;
        if(currentNode.hasRightChild()) return getMaxAux(currentNode.right);
        else return currentNode;
    }

    // Retorna o menor elemento da arvore.
    Node getMin(){
        return getMinAux(root);
    }

    private Node getMinAux(Node currentNode){
        if(currentNode == null) return null;
        if(currentNode.hasLeftChild()) return getMinAux(currentNode.left);
        else return currentNode;
    }


    // Acha o sucessor de um nó
    Node getSuccessor(Node currentNode){
        if(currentNode.hasRightChild()) return getMinAux(currentNode.right); // Vai para a subarvore se tiver
        Node parentNode = currentNode.parent;
        while(parentNode!=null && parentNode.right == currentNode){ // Sobe se não tiver subarvore
            currentNode = parentNode;
            parentNode = currentNode.parent;
        }
        return parentNode;
    }

    // Acha o antecessor de um nó
    Node getAntecessor(Node currentNode){
        if(currentNode.hasLeftChild()) return getMaxAux(currentNode.left); // Vai para a subarvore se tiver
        Node parentNode = currentNode.parent;
        while(parentNode!=null && parentNode.left == currentNode){ // Sobe se não tiver subarvore
            currentNode = parentNode;
            parentNode = currentNode.parent;
        }
        return parentNode;
    }


    // Remove um nó com determinado valor
    void removeNode(int value){
        Node nodeToRemove = search(value);
        if(nodeToRemove == null) return;
        Node parentNode = nodeToRemove.parent;
        if(nodeToRemove.isLeaf()){
            if(parentNode != null){
                if(parentNode.right == nodeToRemove) parentNode.right = null;
                else if(parentNode.left == nodeToRemove) parentNode.left = null;
            } else root = null;
            return;
        }

        if(nodeToRemove.getDegree() == 1){
            nodeToRemove.parent = null;
            Node aux;
            if(nodeToRemove.hasLeftChild()) {
                aux = nodeToRemove.left;
                nodeToRemove.left = null;
            }
            else {
                aux = nodeToRemove.right;
                nodeToRemove.right = null;
            }
            if(parentNode.right == nodeToRemove) parentNode.right = aux;
            if(parentNode.left == nodeToRemove) parentNode.left = aux;
            return;
        }

        if(nodeToRemove.getDegree() == 2){
            int successorData = getSuccessor(nodeToRemove).data;
            removeNode(successorData);
            nodeToRemove.data = successorData;
        }
    }
}