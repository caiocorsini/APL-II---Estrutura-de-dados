import java.util.ArrayList;
import java.util.List;

public class TestePerformance {

    // atributos
    private BST bst;
    private AVL avl;

    // construtor
    public TestePerformance(BST bst, AVL avl) {
        this.bst = bst;
        this.avl = avl;
    }

    // métodos
    public List<ResultadoOperacao> testeInsercao(Escola data) {
        
        List<ResultadoOperacao> resultados = new ArrayList<>();
        long startTime, endTime;
    
        // Insertion in BST
        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.insertContagem(data);
        endTime = System.nanoTime();
        //System.out.println("Tempo de inserção BST: " + (endTime - startTime) + " ns");
        resultados.add(new ResultadoOperacao("insercao", "BST", endTime - startTime, comparacoesBST));
    
        // Insertion in AVL
        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.insertContagem(data);
        avl.insertAVL(data);
        endTime = System.nanoTime();
        //System.out.println("Tempo de inserção AVL: " + (endTime - startTime) + " ns\n");
        resultados.add(new ResultadoOperacao("insercao", "AVL", endTime - startTime, comparacoesAVL));

        return resultados;
    }
    


    public List<ResultadoOperacao> testeBusca(int codigoEscola) {
        
        List<ResultadoOperacao> resultados = new ArrayList<>();
        long startTime, endTime;
    
        // BST search
        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.searchContagem(codigoEscola);
        endTime = System.nanoTime();
        // System.out.println("Tempo de busca na BST: " + (endTime - startTime) + " ns");
        // System.out.println("Número de comparações BST: " + comparacoesBST + "\n");
        resultados.add(new ResultadoOperacao("busca", "BST", endTime - startTime, comparacoesBST));
    
        // AVL search
        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.searchContagem(codigoEscola);
        endTime = System.nanoTime();
        // System.out.println("Tempo de busca na AVL: " + (endTime - startTime) + " ns");
        // System.out.println("Número de comparações (busca) AVL: " + comparacoesAVL + "\n");
        resultados.add(new ResultadoOperacao("busca", "AVL", endTime - startTime, comparacoesAVL));

        return resultados;
    }
    

    public List<ResultadoOperacao> testeRemocao(int codigoEscola) {
        List<ResultadoOperacao> resultados = new ArrayList<>();
        long startTime, endTime;
    
        // Removal in BST
        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.removeContagem(codigoEscola);
        endTime = System.nanoTime();
        // System.out.println("Tempo de remoção BST: " + (endTime - startTime) + " ns");
        // System.out.println("Número de comparações (remoção) BST: " + comparacoesBST + "\n");
        resultados.add(new ResultadoOperacao("remocao", "BST", endTime - startTime, comparacoesBST));
    
        // Removal in AVL
        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.removeContagem(codigoEscola);
        endTime = System.nanoTime();
        // System.out.println("Tempo de remoção AVL: " + (endTime - startTime) + " ns");
        // System.out.println("Número de comparações (remoção) AVL: " + comparacoesAVL + "\n");
        resultados.add(new ResultadoOperacao("remocao", "AVL", endTime - startTime, comparacoesAVL));

        return resultados;
    }
    


} // TestePerformance
