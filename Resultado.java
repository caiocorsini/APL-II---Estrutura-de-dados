import java.util.List;

public class Resultado {

    // calcular e exibir a média de tempo e comparações para cada uma das 10 BSTs e AVLs
    public static void exibirResultadoInsercao(List<Escola> dadosSinteticos, List<BST> bstList, List<AVL> avlList) {
        
        System.out.printf("%-10s | %-15s | %-15s | %-15s | %-15s%n", 
                          "Árvore #", "Tipo de Árvore", "Operação", "Média Tempo (ns)", "Média Comparações");
        System.out.println("--------------------------------------------------------------------------------");

  
        for (int i = 0; i < bstList.size(); i++) {
            BST bst = bstList.get(i);
            AVL avl = avlList.get(i);
            TestePerformance teste = new TestePerformance(bst, avl);

            long totalTempoBST = 0;
            long totalComparacoesBST = 0;
            long totalTempoAVL = 0;
            long totalComparacoesAVL = 0;

            
            for (Escola data : dadosSinteticos) {
                // Resultados de inserção na BST
                List<ResultadoOperacao> resultadosBST = teste.testeInsercao(data);
                for (ResultadoOperacao resultado : resultadosBST) {
                    if (resultado.getTipoArvore().equals("BST")) {
                        totalTempoBST += resultado.getTempoOperacao();
                        totalComparacoesBST += resultado.getComparacoes();
                    }
                }

                // Resultados de inserção na AVL
                List<ResultadoOperacao> resultadosAVL = teste.testeInsercao(data);
                for (ResultadoOperacao resultado : resultadosAVL) {
                    if (resultado.getTipoArvore().equals("AVL")) {
                        totalTempoAVL += resultado.getTempoOperacao();
                        totalComparacoesAVL += resultado.getComparacoes();
                    }
                }
            }

            // Calcula as médias
            int totalInsercoes = dadosSinteticos.size();
            double mediaTempoBST = (double) totalTempoBST / totalInsercoes;
            double mediaComparacoesBST = (double) totalComparacoesBST / totalInsercoes;
            double mediaTempoAVL = (double) totalTempoAVL / totalInsercoes;
            double mediaComparacoesAVL = (double) totalComparacoesAVL / totalInsercoes;

            
            System.out.printf("%-10d | %-15s | %-15s | %-15.2f | %-15.2f%n", 
                              (i + 1), "BST", "Inserção", mediaTempoBST, mediaComparacoesBST);

            
            System.out.printf("%-10d | %-15s | %-15s | %-15.2f | %-15.2f%n", 
                              (i + 1), "AVL", "Inserção", mediaTempoAVL, mediaComparacoesAVL);

            System.out.println("--------------------------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
    }
    
    

    

    // // Método estático para testar e exibir o resultado da busca em múltiplas árvores
    // public static void exibirResultadoBusca(int codigoEscola, List<BST> bstList, List<AVL> avlList) {
    //     for (int i = 0; i < bstList.size(); i++) {
    //         BST bst = bstList.get(i);
    //         AVL avl = avlList.get(i);
    //         TestePerformance teste = new TestePerformance(bst, avl);
    //         List<ResultadoOperacao> resultados = teste.testeBusca(codigoEscola);

    //         System.out.println("Resultados de Busca para árvore #" + (i + 1) + ":");
    //         resultados.forEach(System.out::println);
    //         System.out.println(); // Adiciona uma linha em branco entre os resultados de cada árvore
    //     }
    // }

    // Método estático para calcular e exibir a média de tempo e comparações para buscas em cada uma das 10 BSTs e AVLs
    public static void exibirMediaBusca(List<Escola> dadosSinteticos, List<BST> bstList, List<AVL> avlList) {
        // Cabeçalho da tabela
        System.out.printf("%-10s | %-15s | %-15s | %-15s | %-15s%n", 
                          "Árvore #", "Tipo de Árvore", "Operação", "Média Tempo (ns)", "Média Comparações");
        System.out.println("--------------------------------------------------------------------------------");

        // Itera sobre cada árvore e calcula as médias individualmente para a operação de busca
        for (int i = 0; i < bstList.size(); i++) {
            BST bst = bstList.get(i);
            AVL avl = avlList.get(i);
            TestePerformance teste = new TestePerformance(bst, avl);

            long totalTempoBST = 0;
            long totalComparacoesBST = 0;
            long totalTempoAVL = 0;
            long totalComparacoesAVL = 0;

            // Para cada código de escola nos dados sintéticos, realizamos a busca na árvore e acumulamos o tempo e as comparações
            for (Escola escola : dadosSinteticos) {
                int codigoEscola = escola.getCodEsc();

                // Resultados de busca na BST
                List<ResultadoOperacao> resultadosBST = teste.testeBusca(codigoEscola);
                for (ResultadoOperacao resultado : resultadosBST) {
                    if (resultado.getTipoArvore().equals("BST")) {
                        totalTempoBST += resultado.getTempoOperacao();
                        totalComparacoesBST += resultado.getComparacoes();
                    }
                }

                // Resultados de busca na AVL
                List<ResultadoOperacao> resultadosAVL = teste.testeBusca(codigoEscola);
                for (ResultadoOperacao resultado : resultadosAVL) {
                    if (resultado.getTipoArvore().equals("AVL")) {
                        totalTempoAVL += resultado.getTempoOperacao();
                        totalComparacoesAVL += resultado.getComparacoes();
                    }
                }
            }

            // Calcula as médias para a árvore BST e AVL atual
            int totalBuscas = dadosSinteticos.size();
            double mediaTempoBST = (double) totalTempoBST / totalBuscas;
            double mediaComparacoesBST = (double) totalComparacoesBST / totalBuscas;
            double mediaTempoAVL = (double) totalTempoAVL / totalBuscas;
            double mediaComparacoesAVL = (double) totalComparacoesAVL / totalBuscas;

            // Exibe os resultados médios para a BST atual
            System.out.printf("%-10d | %-15s | %-15s | %-15.2f | %-15.2f%n", 
                              (i + 1), "BST", "Busca", mediaTempoBST, mediaComparacoesBST);

            // Exibe os resultados médios para a AVL atual
            System.out.printf("%-10d | %-15s | %-15s | %-15.2f | %-15.2f%n", 
                              (i + 1), "AVL", "Busca", mediaTempoAVL, mediaComparacoesAVL);

            System.out.println("--------------------------------------------------------------------------------");
        }

        System.out.println();
        System.out.println();
    }

   


    // Método estático para calcular e exibir a média de tempo e comparações para remoções em cada uma das 10 BSTs e AVLs
    public static void exibirResultadoRemocao(List<Escola> dadosSinteticos, List<BST> bstList, List<AVL> avlList) {
        // Cabeçalho da tabela
        System.out.printf("%-10s | %-15s | %-15s | %-15s | %-15s%n", 
                          "Árvore #", "Tipo de Árvore", "Operação", "Média Tempo (ns)", "Média Comparações");
        System.out.println("--------------------------------------------------------------------------------");

        // Itera sobre cada árvore e calcula as médias individualmente para a operação de remoção
        for (int i = 0; i < bstList.size(); i++) {
            BST bst = bstList.get(i);
            AVL avl = avlList.get(i);
            TestePerformance teste = new TestePerformance(bst, avl);

            long totalTempoBST = 0;
            long totalComparacoesBST = 0;
            long totalTempoAVL = 0;
            long totalComparacoesAVL = 0;

            // Para cada código de escola nos dados sintéticos, removemos da árvore e acumulamos o tempo e as comparações
            for (Escola escola : dadosSinteticos) {
                int codigoEscola = escola.getCodEsc();

                // Resultados de remoção na BST
                List<ResultadoOperacao> resultadosBST = teste.testeRemocao(codigoEscola);
                for (ResultadoOperacao resultado : resultadosBST) {
                    if (resultado.getTipoArvore().equals("BST")) {
                        totalTempoBST += resultado.getTempoOperacao();
                        totalComparacoesBST += resultado.getComparacoes();
                    }
                }

                // Resultados de remoção na AVL
                List<ResultadoOperacao> resultadosAVL = teste.testeRemocao(codigoEscola);
                for (ResultadoOperacao resultado : resultadosAVL) {
                    if (resultado.getTipoArvore().equals("AVL")) {
                        totalTempoAVL += resultado.getTempoOperacao();
                        totalComparacoesAVL += resultado.getComparacoes();
                    }
                }
            }

            // Calcula as médias para a árvore BST e AVL atual
            int totalRemocoes = dadosSinteticos.size();
            double mediaTempoBST = (double) totalTempoBST / totalRemocoes;
            double mediaComparacoesBST = (double) totalComparacoesBST / totalRemocoes;
            double mediaTempoAVL = (double) totalTempoAVL / totalRemocoes;
            double mediaComparacoesAVL = (double) totalComparacoesAVL / totalRemocoes;

            // Exibe os resultados médios para a BST atual
            System.out.printf("%-10d | %-15s | %-15s | %-15.2f | %-15.2f%n", 
                              (i + 1), "BST", "Remoção", mediaTempoBST, mediaComparacoesBST);

            // Exibe os resultados médios para a AVL atual
            System.out.printf("%-10d | %-15s | %-15s | %-15.2f | %-15.2f%n", 
                              (i + 1), "AVL", "Remoção", mediaTempoAVL, mediaComparacoesAVL);

            System.out.println("--------------------------------------------------------------------------------");
        }

        System.out.println();
        System.out.println();
    }



}// Resultado
