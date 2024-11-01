public class AVL extends BST{
    AVL(){
        super.root = null;
    }

    Node rightRotate(Node currentRoot){
        Node aux = currentRoot.getLeft();
        currentRoot.setLeft(aux.getRight());
        aux.setRight(currentRoot);
        aux.setParent(currentRoot.getParent());
        currentRoot.setParent(aux);
        currentRoot.updateHeight();
        aux.updateHeight();
        return aux;
    }

    Node leftRotate(Node currentRoot){
        Node aux = currentRoot.getRight();
        currentRoot.setRight(aux.getLeft());
        aux.setLeft(currentRoot);
        aux.setParent(currentRoot.getParent());
        currentRoot.setParent(aux);
        currentRoot.updateHeight();
        aux.updateHeight();
        return aux;
    }

    Node rightLeftRotate(Node currentRoot){
        currentRoot.setRight(rightRotate(currentRoot.getRight()));
        return leftRotate(currentRoot);
    }

    Node leftRightRotate(Node currentRoot){
        currentRoot.setLeft(leftRotate(currentRoot.getLeft()));;
        return rightRotate(currentRoot);
    }

    void insertAVL(Escola value){
        root = insertAVLAux(root,null,value);
    }

    private Node insertAVLAux(Node currentNode, Node parentNode, Escola value){

        if(currentNode == null){
            Node newNode = new Node(value);
            newNode.setParent(parentNode);
            return newNode;
        }

        if(value.getCodEsc()<currentNode.getData().getCodEsc()) {
            currentNode.setLeft(insertAVLAux(currentNode.getLeft(), currentNode, value));
            currentNode.updateHeight();
            if(currentNode.balancingFactor() == 2){
                if(value.getCodEsc()<currentNode.getLeft().getData().getCodEsc()) currentNode = rightRotate(currentNode);
                else if(value.getCodEsc()>currentNode.getLeft().getData().getCodEsc()) currentNode = leftRightRotate(currentNode);
            }
        }

        else if(value.getCodEsc()>currentNode.getData().getCodEsc()){
            currentNode.setRight(insertAVLAux(currentNode.getRight(), currentNode, value));;
            currentNode.updateHeight();
            if(currentNode.balancingFactor() == -2){
                if(value.getCodEsc()>currentNode.getRight().getData().getCodEsc()) currentNode = leftRotate(currentNode);
                else if(value.getCodEsc()<currentNode.getRight().getData().getCodEsc()) currentNode = rightLeftRotate(currentNode);
            }
        }
        currentNode.updateHeight();
        return currentNode;
    }


    void removeNode(int value){
        root = removeNodeAVLAux(root, value);
    }

    // Remocao mantendo o balanceamento da AVL
    private Node removeNodeAVLAux(Node currentNode, int value) {
        if (currentNode == null) return currentNode; // Caso nao tenha nada para ser removido
        
        if (value < currentNode.getData().getCodEsc()) {  // Procurando pelo no a ser removido
            currentNode.setLeft(removeNodeAVLAux(currentNode.getLeft(), value));
        } else if (value > currentNode.getData().getCodEsc()) {
            currentNode.setRight(removeNodeAVLAux(currentNode.getRight(), value));
        } else { 
    
            // No com nenhum ou apenas um filho
            if (currentNode.getLeft() == null || currentNode.getRight() == null) {
                Node temp = currentNode.getLeft() != null ? currentNode.getLeft() : currentNode.getRight();
    
                // Sem filhos
                if (temp == null) {
                    temp = currentNode;
                    currentNode = null;
                } else { 
                    currentNode = temp; // Apenas um filho
                }
            } else {
                Node temp = currentNode.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
    
                // Copiando o dado do sucessor
                currentNode.setData(temp.getData());
    
                // Deletando o sucessor
                currentNode.setRight(removeNodeAVLAux(currentNode.getRight(), temp.getData().getCodEsc()));
            }
        }
    
        // Se a arvore soh contem um no retornar
        if (currentNode == null) return currentNode;
    
        // Checando o balanceamento
        int balance = currentNode.balancingFactor();
    
        if (balance == 2) {
            // Vendo de que lado esta desbalanceado
            if (currentNode.getLeft().balancingFactor() >= 0) {
                currentNode = rightRotate(currentNode);
            } else {
                currentNode = leftRightRotate(currentNode);
            }
        } else if (balance == -2) {
            if (currentNode.getRight().balancingFactor() <= 0) {
                currentNode = leftRotate(currentNode);
            } else {
                currentNode = rightLeftRotate(currentNode);
            }
        }
        return currentNode;
    }
}