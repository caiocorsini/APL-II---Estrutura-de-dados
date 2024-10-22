public class AVL extends BST{
    AVL(){
        super.root = null;
    }

    Node rightRotate(Node currentRoot){
        Node aux = currentRoot.left;
        currentRoot.left = aux.right;
        aux.right = currentRoot;
        currentRoot.parent = aux;
        currentRoot.updateHeight();
        aux.updateHeight();
        return aux;
    }

    Node leftRotate(Node currentRoot){
        Node aux = currentRoot.right;
        currentRoot.right = aux.left;
        aux.left = currentRoot;
        currentRoot.parent = aux;
        currentRoot.updateHeight();
        aux.updateHeight();
        return aux;
    }

    Node rightLeftRotate(Node currentRoot){
        currentRoot.right = rightRotate(currentRoot.right);
        return leftRotate(currentRoot);
    }

    Node leftRightRotate(Node currentRoot){
        currentRoot.left = leftRotate(currentRoot);
        return rightRotate(currentRoot);
    }

    void insertAVL(int value){
        root = insertAVLAux(root,null,value);
    }

    private Node insertAVLAux(Node currentNode, Node parentNode, int value){
        Node newNode = new Node(value);
        newNode.parent = parentNode;
        if(currentNode == null) return newNode;
        if(value<currentNode.data) {
            currentNode.left = insertAVLAux(currentNode.left, parentNode, value);
            if(currentNode.balancingFactor() == 2){
                if(value<currentNode.left.data) currentNode = rightRotate(currentNode);
                else if(value>currentNode.left.data) currentNode = leftRightRotate(currentNode);
            }
        }
        else if(value>currentNode.data){
            currentNode.right = insertAVLAux(currentNode.right, parentNode, value);
            if(currentNode.balancingFactor() == -2){
                if(value>currentNode.right.data) currentNode = leftRotate(currentNode);
                else if(value<currentNode.right.data) currentNode = rightLeftRotate(currentNode);
            }
        }
        return currentNode;
    }


    void removeNode(int value){
        root = removeNodeAVLAux(root, value);
    }

    // Remocao mantendo o balanceamento da AVL
    private Node removeNodeAVLAux(Node currentNode, int value) {
        if (currentNode == null) return currentNode; // Caso nao tenha nada para ser removido
        
        if (value < currentNode.data) {  // Procurando pelo no a ser removido
            currentNode.left = removeNodeAVLAux(currentNode.left, value);
        } else if (value > currentNode.data) {
            currentNode.right = removeNodeAVLAux(currentNode.right, value);
        } else { 
    
            // No com nenhum ou apenas um filho
            if (currentNode.left == null || currentNode.right == null) {
                Node temp = currentNode.left != null ? currentNode.left : currentNode.right;
    
                // Sem filhos
                if (temp == null) {
                    temp = currentNode;
                    currentNode = null;
                } else { 
                    currentNode = temp; // Apenas um filho
                }
            } else {
                Node temp = currentNode.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
    
                // Copiando o dado do sucessor
                currentNode.data = temp.data;
    
                // Deletando o sucessor
                currentNode.right = removeNodeAVLAux(currentNode.right, temp.data);
            }
        }
    
        // Se a arvore soh contem um no retornar
        if (currentNode == null) return currentNode;
    
        // Checando o balanceamento
        int balance = currentNode.balancingFactor();
    
        if (balance == 2) {
            // Vendo de que lado esta desbalanceado
            if (currentNode.left.balancingFactor() >= 0) {
                currentNode = rightRotate(currentNode);
            } else {
                currentNode = leftRightRotate(currentNode);
            }
        } else if (balance == -2) {
            if (currentNode.right.balancingFactor() <= 0) {
                currentNode = leftRotate(currentNode);
            } else {
                currentNode = rightLeftRotate(currentNode);
            }
        }
    
        return currentNode;
    }

}