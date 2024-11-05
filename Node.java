/**
 * ESTRUTURA DE DADOS II
 * TURMA 04P11
 * APL 2
 * ALAN MENIUK GLEIZER - 10416804
 * CAIO VINICIUS CORSINI FILHO - 10342005
 * GILBERTO DE MELO JÚNIOR - 10419275
 * *
 */

public class Node{
    // Atributos do Node
    private Escola data;
    private Node right;
    private Node left;
    private Node parent;
    private int height;  // Optei por armazenar a altura ao inves do fator de balanceamento

    // Construtor
    Node(Escola data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        height = -1;
    }

    // Getters e setters do Node
    public Escola getData() {return data;}
    public void setData(Escola data) {this.data = data;}
    public Node getRight() {return right;}
    public void setRight(Node right) {this.right = right;}
    public Node getLeft() {return left;}
    public void setLeft(Node left) {this.left = left;}
    public Node getParent() {return parent;}
    public void setParent(Node parent) {this.parent = parent;}
    public void setHeight(int height) {this.height = height;}

    // Presenca de determinados ponteiros
    boolean hasRightChild(){return right != null;}
    boolean hasLeftChild(){return left != null;}
    boolean hasParent(){return parent != null;}

    // Se é raiz ou folha
    boolean isLeaf(){return !hasLeftChild() && !hasRightChild();}
    boolean isRoot(){return !hasParent();}

    // Grau do nó. Isso é, quantos filhos tem
    int getDegree(){
        int degree = 0;
        if(hasLeftChild()) degree++;
        if(hasRightChild()) degree++;
        return degree;
    }

    // Pega o nível do nó. Começa contando do zero de cima para baixo.
    int getLevel(){
        if(isRoot()) return 0;
        int cont = 0;
        Node currentNode = this;
        while(currentNode.parent != null){
            currentNode = currentNode.parent;
            cont++;
        }
        return cont;
    }

    // Calcula a altura da arvore. Usa funcao auxiliar.
    int getHeight(){
        if (height == -1) height = getHeightAux(this);
        return height;
    }

    // Atualiza a altura de um determinado nó. Atualiza o valor do atributo.
    void updateHeight(){
        height = getHeightAux(this);
    }

    // Funcao auxiliar para calcular a altura a partir de um determinado no.
    // Pode ser usado na raiz da arvore para obter a altura da arvore inteira.
    private int getHeightAux(Node currentNode){
        if (currentNode == null) return -1; // Caso seja um nó vazio
        int leftHeight = getHeightAux(currentNode.left);
        int rightHeight = getHeightAux(currentNode.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Calcula o fator de balanceamento. Necessário para árvores AVL
    // Neste caso, faz esquerda menos direita
    int balancingFactor() {
        int balanceLeft = hasLeftChild() ? this.left.getHeight() : -1;
        int balanceRight = hasRightChild() ? this.right.getHeight() : -1;
        return balanceLeft - balanceRight;
    }
}