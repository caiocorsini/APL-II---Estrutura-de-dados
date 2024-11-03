import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {

    // Método para exportar todos os resultados de inserção, busca e remoção em uma única tabela no arquivo CSV
    public static void exportarResultados(String fileName, Escola data, int codigoEscola, List<BST> bstList, List<AVL> avlList) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Cabeçalho do arquivo CSV com letras maiúsculas, palavras separadas por _
            writer.write("OPERACAO,TIPO_DE_ARVORE,ARVORE,TEMPO_NS,COMPARACOES\n");

            // Exporta resultados de Inserção para BST e AVL
            for (int i = 0; i < bstList.size(); i++) {
                BST bst = bstList.get(i);
                AVL avl = avlList.get(i);
                TestePerformance teste = new TestePerformance(bst, avl);

                // Inserção na BST
                List<ResultadoOperacao> resultadosInsercaoBST = teste.testeInsercao(data);
                for (ResultadoOperacao resultado : resultadosInsercaoBST) {
                    writer.write(resultado.getTipoOperacao() + ",BST,BST #" + (i + 1) + ","
                            + resultado.getTempoOperacao() + "," + resultado.getComparacoes() + "\n");
                }

                // Inserção na AVL
                List<ResultadoOperacao> resultadosInsercaoAVL = teste.testeInsercao(data);
                for (ResultadoOperacao resultado : resultadosInsercaoAVL) {
                    writer.write(resultado.getTipoOperacao() + ",AVL,AVL #" + (i + 1) + ","
                            + resultado.getTempoOperacao() + "," + resultado.getComparacoes() + "\n");
                }
            }

            // Exporta resultados de Busca para BST e AVL
            for (int i = 0; i < bstList.size(); i++) {
                BST bst = bstList.get(i);
                AVL avl = avlList.get(i);
                TestePerformance teste = new TestePerformance(bst, avl);

                // Busca na BST
                List<ResultadoOperacao> resultadosBuscaBST = teste.testeBusca(codigoEscola);
                for (ResultadoOperacao resultado : resultadosBuscaBST) {
                    writer.write(resultado.getTipoOperacao() + ",BST,BST #" + (i + 1) + ","
                            + resultado.getTempoOperacao() + "," + resultado.getComparacoes() + "\n");
                }

                // Busca na AVL
                List<ResultadoOperacao> resultadosBuscaAVL = teste.testeBusca(codigoEscola);
                for (ResultadoOperacao resultado : resultadosBuscaAVL) {
                    writer.write(resultado.getTipoOperacao() + ",AVL,AVL #" + (i + 1) + ","
                            + resultado.getTempoOperacao() + "," + resultado.getComparacoes() + "\n");
                }
            }

            // Exporta resultados de Remoção para BST e AVL
            for (int i = 0; i < bstList.size(); i++) {
                BST bst = bstList.get(i);
                AVL avl = avlList.get(i);
                TestePerformance teste = new TestePerformance(bst, avl);

                // Remoção na BST
                List<ResultadoOperacao> resultadosRemocaoBST = teste.testeRemocao(codigoEscola);
                for (ResultadoOperacao resultado : resultadosRemocaoBST) {
                    writer.write(resultado.getTipoOperacao() + ",BST,BST #" + (i + 1) + ","
                            + resultado.getTempoOperacao() + "," + resultado.getComparacoes() + "\n");
                }

                // Remoção na AVL
                List<ResultadoOperacao> resultadosRemocaoAVL = teste.testeRemocao(codigoEscola);
                for (ResultadoOperacao resultado : resultadosRemocaoAVL) {
                    writer.write(resultado.getTipoOperacao() + ",AVL,AVL #" + (i + 1) + ","
                            + resultado.getTempoOperacao() + "," + resultado.getComparacoes() + "\n");
                }
            }
        }
    }
}
