public class Node{
    public int data;
    public Node right;
    public Node left;
    public Node parent;
    public int height;

    // Construtor
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        height = 0;
    }

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
        return getHeightAux(this);
    }

    // Atualiza a altura de um determinado nó.
    void updateHeight(){
        height = getHeightAux(this);
    }

    private int getHeightAux(Node currentNode){
        if (currentNode == null) return -1; // Caso seja um nó vazio
        int leftHeight = getHeightAux(currentNode.left);
        int rightHeight = getHeightAux(currentNode.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Calcula o fator de balanceamento. Necessário para árvores AVL
    int balancingFactor(){
        int balLeft = -1, balRight = -1;
        if(this.hasLeftChild()) balLeft = this.left.getHeight();
        if(this.hasRightChild()) balRight = this.right.getHeight();
        return balLeft - balRight;
    }
}