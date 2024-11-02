import java.util.List;

public class Resultado {

    // Método estático para testar e exibir o resultado da inserção
    public static void exibirResultadoInsercao(Escola data, BST bst, AVL avl) {
        TestePerformance teste = new TestePerformance(bst, avl);
        List<ResultadoOperacao> resultados = teste.testeInsercao(data);

        // Exibe os resultados de inserção
        resultados.forEach(System.out::println);
    }

    // Método estático para testar e exibir o resultado da busca
    public static void exibirResultadoBusca(int codigoEscola, BST bst, AVL avl) {
        TestePerformance teste = new TestePerformance(bst, avl);
        List<ResultadoOperacao> resultados = teste.testeBusca(codigoEscola);

        // Exibe os resultados de busca
        resultados.forEach(System.out::println);
    }

    // Método estático para testar e exibir o resultado da remoção
    public static void exibirResultadoRemocao(int codigoEscola, BST bst, AVL avl) {
        TestePerformance teste = new TestePerformance(bst, avl);
        List<ResultadoOperacao> resultados = teste.testeRemocao(codigoEscola);

        // Exibe os resultados de remoção
        resultados.forEach(System.out::println);
    }
}
