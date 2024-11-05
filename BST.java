/**
 * ESTRUTURA DE DADOS II
 * TURMA 04P11
 * APL 2
 * ALAN MENIUK GLEIZER - 10416804
 * CAIO VINICIUS CORSINI FILHO - 10342005
 * GILBERTO DE MELO JÚNIOR - 10419275
 * *
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
public class BST{
    Node root;

    // Construtor
    BST(){
        root = null;
    }

    // Travessia em ordem
    // Retorna uma ArrayList com todos os dados da arvore ao inves de imprimir. Para as analises de dados.
    ArrayList<Node> inOrderTraversal() {
        ArrayList<Node> resultList = new ArrayList<>();
        if (root == null) return resultList;
        inOrderTraversalAux(root, resultList);
        return resultList;
    }
    
    private void inOrderTraversalAux(Node currentNode, ArrayList<Node> resultList) {
        if (currentNode == null) return;
        if (currentNode.hasLeftChild()) inOrderTraversalAux(currentNode.getLeft(), resultList);
        resultList.add(currentNode);
        if (currentNode.hasRightChild()) inOrderTraversalAux(currentNode.getRight(), resultList);
    }

    // Travessia pre-ordem
    // Retorna uma ArrayList com todos os dados da arvore ao inves de imprimir. Para as analises de dados.
    ArrayList<Node> preOrderTraversal(){
        ArrayList<Node> resultList = new ArrayList<>();
        if(root==null) return resultList;
        preOrderTraversalAux(root, resultList);
        return resultList;
    }

    private void preOrderTraversalAux(Node currentNode, ArrayList<Node> resultList){
        if(currentNode == null) return;
        resultList.add(currentNode);
        if(currentNode.hasLeftChild()) preOrderTraversalAux(currentNode.getLeft(), resultList);
        if(currentNode.hasRightChild()) preOrderTraversalAux(currentNode.getRight(), resultList);
    }

    // Travessia pos-ordem
    // Retorna uma ArrayList com todos os dados da arvore ao inves de imprimir. Para as analises de dados.
    ArrayList<Node> postOrderTraversal(){
        ArrayList<Node> resultList = new ArrayList<>();
        if(root==null) return resultList;
        postOrderTraversalAux(root, resultList);
        return resultList;
    }

    private void postOrderTraversalAux(Node currentNode, ArrayList<Node> resultList){
        if(currentNode == null) return;
        if(currentNode.hasLeftChild()) postOrderTraversalAux(currentNode.getLeft(), resultList);
        if(currentNode.hasRightChild()) postOrderTraversalAux(currentNode.getRight(), resultList);
        resultList.add(currentNode);
    }

    // Travessia em nível
    // Retorna uma ArrayList com todos os dados da arvore ao inves de imprimir. Para as analises de dados.
    ArrayList<Node> levelOrderTraversal(){
        ArrayList<Node> resultList = new ArrayList<>();
        if(root==null) return resultList;;
        levelOrderTraversalAux(root, resultList);
        return resultList;
    }

    private void levelOrderTraversalAux(Node currentNode, ArrayList<Node> resultList){
        if(currentNode == null) return;
        // Usa-se uma fila para auxiliar no processo do percurso por nivel
        Queue<Node> queue = new LinkedList<>();  // Fila implementada com linked list.
        queue.add(currentNode);
        while(!queue.isEmpty()){ // Enquanto a fila nao fica vazia, continua
            resultList.add(currentNode);
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
        // Verifica qual lado eh menor e qual eh maior para determinar onde inserir
        if(value.getCodEsc()<currentNode.getData().getCodEsc()) currentNode.setLeft(insertAux(currentNode.getLeft(), currentNode, value));
        else currentNode.setRight(insertAux(currentNode.getRight(), currentNode, value));
        return currentNode;
    }


    // Busca por elementos na arvore
    Node search(int value){
        if(root==null) return null;
        return searchAux(root, value);
    }

    // Auxiliar de search()
    private Node searchAux(Node currentNode, int value){
        if(currentNode.getData().getCodEsc() == value) return currentNode;  // Caso tenha encontrado o valor
        // Verifica qual lado eh menor e qual eh maior para determinar onde inserir
        if(value>currentNode.getData().getCodEsc()) return searchAux(currentNode.getRight(), value);
        if(value<currentNode.getData().getCodEsc()) return searchAux(currentNode.getLeft(), value);
        return null;
    }

    // Busca por elementos na arvore
    // Tambem busca por Node, mas ao inves de retornar o Node, retorna a quantidade de passos para chegar nele
    // Usado para as analises de performance
    int searchContagem(int value){
        if(root==null) return 0;
        Contagem n = new Contagem();
        searchContagemAux(root, value, n);
        return n.getN();
    }

    // Auxiliar de searchContagem
    private void searchContagemAux(Node currentNode, int value, Contagem n){
        if(currentNode.getData().getCodEsc() == value) return;
        n.adicionar();
        if(value>currentNode.getData().getCodEsc()) searchContagemAux(currentNode.getRight(), value, n);
        if(value<currentNode.getData().getCodEsc()) searchContagemAux(currentNode.getLeft(), value, n);
        return;
    }

    // Retorna o maior elemento da arvore
    Node getMax(){
        return getMaxAux(root);
    }

    // Auxiliar de getMax
    // Tambem pode ser usado para pegar o maior elemento de uma subarvore especificamente
    private Node getMaxAux(Node currentNode){
        if(currentNode == null) return null;
        if(currentNode.hasRightChild()) return getMaxAux(currentNode.getRight());  // Percorre continuamente para a direita
        else return currentNode;
    }

    // Retorna o menor elemento da arvore
    Node getMin(){
        return getMinAux(root);
    }

    // Auxiliar de getMin
    // Tambem pode ser usado para pegar o menor elemento de uma subarvore especificamente
    private Node getMinAux(Node currentNode){
        if(currentNode == null) return null;
        if(currentNode.hasLeftChild()) return getMinAux(currentNode.getLeft());  // Percorre continuamente para a esquerda
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
        Node nodeToRemove = search(value.getCodEsc());  // Primeiro procura o Node em si, reutiliizando a funcao search
        if(nodeToRemove == null) return;  // Caso nao ache o Node para remover
        Node parentNode = nodeToRemove.getParent();  // Pega o pai de quem vai ser removido. Necessario para a atualizacao das referencias.
        if(nodeToRemove.isLeaf()){  // Caso 1:  Se o removido for uma folha
            if(parentNode != null){
                // Atualiza referencias do Node pai do removido
                if(parentNode.getRight() == nodeToRemove) parentNode.setRight(null);
                else if(parentNode.getLeft() == nodeToRemove) parentNode.setLeft(null);
            } else root = null;
            return;
        }

        // Caso 2:  Se o Node removido tem apenas um filho
        if(nodeToRemove.getDegree() == 1){
            nodeToRemove.setParent(null);  // Remove referencia ao pai do removido
            Node aux;
            if(nodeToRemove.hasLeftChild()) {  // Se o unico filho esta a esquerda do removido
                aux = nodeToRemove.getLeft();
                nodeToRemove.setLeft(null);  // Remove referencia a esquerda do removido
            }
            else {  // Se o unico filho esta a direita do removido
                aux = nodeToRemove.getRight();
                nodeToRemove.setRight(null);  // Remove referencia a direita do removido
            }
            // Atualizacao das referencias dos Nodes
            if(parentNode.getRight() == nodeToRemove) parentNode.setRight(aux);
            if(parentNode.getLeft() == nodeToRemove) parentNode.setLeft(aux);
            return;
        }

        if(nodeToRemove.getDegree() == 2){  //Caso 3: Se o removido tem 2 filhos
            Escola successorData = getSuccessor(nodeToRemove).getData();  // Removido troca de dado com o sucessor (antecessor tambem funcionaria)
            removeNode(successorData);
            nodeToRemove.setData(successorData);  // Apos a troca, remove o sucessor (o qual agora esta com o dado do removido)
        }
    }

    // Funcao de remocao usada para contar numero de comparacoes
    public int removeContagem(int val) {
        int[] comparacoes = {0}; // Usamos um array para o contador
        root = removeRec(root, val, comparacoes);
        return comparacoes[0]; // Retorna o número de comparações
    }
    
    private Node removeRec(Node curr, int val, int[] comparacoes) {
        if (curr == null) {
            return null;
        }
    
        comparacoes[0]++; // Conta uma comparação
    
        if (val < curr.getData().getCodEsc()) {
            curr.setLeft(removeRec(curr.getLeft(), val, comparacoes));
        } else if (val > curr.getData().getCodEsc()) {
            curr.setRight(removeRec(curr.getRight(), val, comparacoes));
        } else {
            // Nó encontrado, realizar a remoção
    
            // Caso 1: Nó é uma folha
            if (curr.getLeft() == null && curr.getRight() == null) {
                return null;
            }
            // Caso 2: Nó tem apenas um filho
            else if (curr.getLeft() == null) {
                return curr.getRight();
            } else if (curr.getRight() == null) {
                return curr.getLeft();
            }
            // Caso 3: Nó tem dois filhos
            else {
                Node successor = getSuccessor(curr);
                curr.setData(successor.getData());
                curr.setRight(removeRec(curr.getRight(), successor.getData().getCodEsc(), comparacoes));
            }
        }
        return curr;
    }

    // Funcao de insercao usada para contar numero de comparacoes
    public int insertContagem(Escola val) {
        int[] contador = {0}; // Usamos um array para passar o contador por referência
        root = insertContagemAux(root, null, val, contador);
        return contador[0]; // Retorna o número de comparações
    }
    
    private Node insertContagemAux(Node currentNode, Node parentNode, Escola value, int[] contador) {
        Node newNode = new Node(value);
        newNode.setParent(parentNode);
    
        if (currentNode == null) {
            return newNode;
        }
    
        // Incrementa o contador para cada comparação
        contador[0]++;
        if (value.getCodEsc() < currentNode.getData().getCodEsc()) {
            currentNode.setLeft(insertContagemAux(currentNode.getLeft(), currentNode, value, contador));
        } else {
            currentNode.setRight(insertContagemAux(currentNode.getRight(), currentNode, value, contador));
        }
        return currentNode;
    }
    
} // BST