import java.util.List;

public class Resultado {

    // Método estático para testar e exibir o resultado da inserção em múltiplas árvores
    public static void exibirResultadoInsercao(Escola data, List<BST> bstList, List<AVL> avlList) {
        for (int i = 0; i < bstList.size(); i++) {
            BST bst = bstList.get(i);
            AVL avl = avlList.get(i);
            TestePerformance teste = new TestePerformance(bst, avl);
            List<ResultadoOperacao> resultados = teste.testeInsercao(data);

            System.out.println("Resultados de Inserção para árvore #" + (i + 1) + ":");
            resultados.forEach(System.out::println);
            System.out.println(); // Adiciona uma linha em branco entre os resultados de cada árvore
        }
    }

    // Método estático para testar e exibir o resultado da busca em múltiplas árvores
    public static void exibirResultadoBusca(int codigoEscola, List<BST> bstList, List<AVL> avlList) {
        for (int i = 0; i < bstList.size(); i++) {
            BST bst = bstList.get(i);
            AVL avl = avlList.get(i);
            TestePerformance teste = new TestePerformance(bst, avl);
            List<ResultadoOperacao> resultados = teste.testeBusca(codigoEscola);

            System.out.println("Resultados de Busca para árvore #" + (i + 1) + ":");
            resultados.forEach(System.out::println);
            System.out.println(); // Adiciona uma linha em branco entre os resultados de cada árvore
        }
    }

    // Método estático para testar e exibir o resultado da remoção em múltiplas árvores
    public static void exibirResultadoRemocao(int codigoEscola, List<BST> bstList, List<AVL> avlList) {
        for (int i = 0; i < bstList.size(); i++) {
            BST bst = bstList.get(i);
            AVL avl = avlList.get(i);
            TestePerformance teste = new TestePerformance(bst, avl);
            List<ResultadoOperacao> resultados = teste.testeRemocao(codigoEscola);

            System.out.println("Resultados de Remoção para árvore #" + (i + 1) + ":");
            resultados.forEach(System.out::println);
            System.out.println(); // Adiciona uma linha em branco entre os resultados de cada árvore
        }
    }
}
