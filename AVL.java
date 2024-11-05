/**
 * ESTRUTURA DE DADOS II
 * TURMA 04P11
 * APL 2
 * ALAN MENIUK GLEIZER - 10416804
 * CAIO VINICIUS CORSINI FILHO - 10342005
 * GILBERTO DE MELO JÚNIOR - 10419275
 * *
 */

public class AVL extends BST{  // Heranca: AVL herda as funcoes e atributos da classe BST
    AVL(){
        super.root = null;
    }

    // Rotacao para a direita
    Node rightRotate(Node currentRoot){
        Node aux = currentRoot.getLeft();
        currentRoot.setLeft(aux.getRight());
        aux.setRight(currentRoot);
        aux.setParent(currentRoot.getParent());
        currentRoot.setParent(aux);
        currentRoot.updateHeight();
        aux.updateHeight();
        return aux;  // Retorna a raiz da subarvore
    }

    // Rotacao para a esquerda
    Node leftRotate(Node currentRoot){
        Node aux = currentRoot.getRight();
        currentRoot.setRight(aux.getLeft());
        aux.setLeft(currentRoot);
        aux.setParent(currentRoot.getParent());
        currentRoot.setParent(aux);
        currentRoot.updateHeight();
        aux.updateHeight();
        return aux;  // Retorna a raiz da subarvore
    }

    // Rotacao direita esquerda
    Node rightLeftRotate(Node currentRoot){
        currentRoot.setRight(rightRotate(currentRoot.getRight()));  // Primeiro rotaciona o filho para direita
        return leftRotate(currentRoot);  // Depois o pai para a esquerda
    }

    // Rotacao esquerdda direita
    Node leftRightRotate(Node currentRoot){
        currentRoot.setLeft(leftRotate(currentRoot.getLeft()));;  // Primeiro rotaciona o filho para esquerda
        return rightRotate(currentRoot);  // Depois o pai para a direita
    }

    // Funcao para inserir novo Node na arvore, porem de forma que respeita o balanceamento
    void insertAVL(Escola value){
        root = insertAVLAux(root,null,value);
    }

    // Auxiliar de insertAVL
    private Node insertAVLAux(Node currentNode, Node parentNode, Escola value){

        // Encontrou o local de insercao
        if(currentNode == null){
            Node newNode = new Node(value);  // Instancia o novo Node e insere ele
            newNode.setParent(parentNode);
            return newNode;
        }

        if(value.getCodEsc()<currentNode.getData().getCodEsc()) {
            currentNode.setLeft(insertAVLAux(currentNode.getLeft(), currentNode, value));  // Insere na esquerda caso o valor seja menor
            currentNode.updateHeight();  // Atualiza altura e verifica balanceamento do no
            if(currentNode.balancingFactor() == 2){  // Mais pesado na esquerda
                if(value.getCodEsc()<currentNode.getLeft().getData().getCodEsc()) currentNode = rightRotate(currentNode);  // Filho do desbalanceado na esquerda. Necessita rotacao simples direita
                else if(value.getCodEsc()>currentNode.getLeft().getData().getCodEsc()) currentNode = leftRightRotate(currentNode);  // Filho do desbalanceado na direita. necessita rotacao esquerda direita
            }
        }

        else if(value.getCodEsc()>currentNode.getData().getCodEsc()){
            currentNode.setRight(insertAVLAux(currentNode.getRight(), currentNode, value));;  // Insere na direita caso o valor seja maior
            currentNode.updateHeight();  // Atualiza altura e verifica balanceamento do no
            if(currentNode.balancingFactor() == -2){  // Mais pesado na direita
                if(value.getCodEsc()>currentNode.getRight().getData().getCodEsc()) currentNode = leftRotate(currentNode);  // Filho do desbalanceado na direita. Necessita rotacao simples esquerda
                else if(value.getCodEsc()<currentNode.getRight().getData().getCodEsc()) currentNode = rightLeftRotate(currentNode);  // Filho do desbalanceado na esquerda. necessita rotacao direita esquerda
            }
        }
        currentNode.updateHeight();  // Atualiza a altura do no atual
        return currentNode;  // Retorna raiz da subarvore
    }


    // Funcao para remover um Node da AVL. Override
    void removeNode(int value){
        root = removeNodeAVLAux(root, value);
    }

    // Remocao mantendo o balanceamento da AVL. Auxiliar de removeNode
    private Node removeNodeAVLAux(Node currentNode, int value) {
        if (currentNode == null) return currentNode; // Caso nao tenha nada para ser removido
        
        if (value < currentNode.getData().getCodEsc()) {  // Procurando pelo Node a ser removido
            currentNode.setLeft(removeNodeAVLAux(currentNode.getLeft(), value));  // Menor, entao vai para esquerda
        } else if (value > currentNode.getData().getCodEsc()) {
            currentNode.setRight(removeNodeAVLAux(currentNode.getRight(), value));  // Maior, entao vai para direita
        } else { 
    
            // No com nenhum ou apenas um filho
            if (currentNode.getLeft() == null || currentNode.getRight() == null) {
                Node temp = currentNode.getLeft() != null ? currentNode.getLeft() : currentNode.getRight();
    
                // Caso 1:  Sem filhos
                if (temp == null) {
                    temp = currentNode;
                    currentNode = null;
                } else { 
                    currentNode = temp; // Caso 2: Apenas um filho
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
    
        if (balance == 2) {  // Desbalanceado para a esquerda
            // Vendo de que lado esta desbalanceado
            if (currentNode.getLeft().balancingFactor() >= 0) {  // Inserido a esquerda do desbalanceado
                currentNode = rightRotate(currentNode);  // Rotacao simples a direita
            } else {
                currentNode = leftRightRotate(currentNode);  // Rotacao esquerda direita
            }
        } else if (balance == -2) {  // Desbalanceado para a direita
            if (currentNode.getRight().balancingFactor() <= 0) {  // Inserido a direita do desbalanceado
                currentNode = leftRotate(currentNode);  // Rotacao simples a esquerda
            } else {
                currentNode = rightLeftRotate(currentNode);  // Rotacao direita esquerda
            }
        }
        return currentNode;
    }
}