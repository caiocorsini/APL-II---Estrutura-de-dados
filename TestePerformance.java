import java.util.ArrayList;
import java.util.List;

public class TestePerformance {

    private BST bst;
    private AVL avl;

    public TestePerformance(BST bst, AVL avl) {
        this.bst = bst;
        this.avl = avl;
    }

    public List<ResultadoOperacao> testeInsercao(Escola data) {
        List<ResultadoOperacao> resultados = new ArrayList<>();
        long startTime, endTime;

        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.insertContagem(data);
        endTime = System.nanoTime();
        resultados.add(new ResultadoOperacao("insercao", "BST", endTime - startTime, comparacoesBST));

        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.insertContagem(data);
        avl.insertAVL(data);
        endTime = System.nanoTime();
        resultados.add(new ResultadoOperacao("insercao", "AVL", endTime - startTime, comparacoesAVL));

        return resultados;
    }

    public List<ResultadoOperacao> testeBusca(int codigoEscola) {
        List<ResultadoOperacao> resultados = new ArrayList<>();
        long startTime, endTime;

        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.searchContagem(codigoEscola);
        endTime = System.nanoTime();
        resultados.add(new ResultadoOperacao("busca", "BST", endTime - startTime, comparacoesBST));

        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.searchContagem(codigoEscola);
        endTime = System.nanoTime();
        resultados.add(new ResultadoOperacao("busca", "AVL", endTime - startTime, comparacoesAVL));

        return resultados;
    }

    public List<ResultadoOperacao> testeRemocao(int codigoEscola) {
        List<ResultadoOperacao> resultados = new ArrayList<>();
        long startTime, endTime;

        int comparacoesBST = 0;
        startTime = System.nanoTime();
        comparacoesBST = bst.removeContagem(codigoEscola);
        endTime = System.nanoTime();
        resultados.add(new ResultadoOperacao("remocao", "BST", endTime - startTime, comparacoesBST));

        int comparacoesAVL = 0;
        startTime = System.nanoTime();
        comparacoesAVL = avl.removeContagem(codigoEscola);
        endTime = System.nanoTime();
        resultados.add(new ResultadoOperacao("remocao", "AVL", endTime - startTime, comparacoesAVL));

        return resultados;
    }
}
