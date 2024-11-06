import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class AnaliseEscola {

    // Atributo para armazenar a árvore BST com os dados de Escola
    private BST arvoreEscolas;

    // Construtor que recebe uma instância de BST<Escola>
    public AnaliseEscola(BST arvoreEscolas) {
        this.arvoreEscolas = arvoreEscolas;
    }

    // Método para buscar e retornar o número de alunos em inglês durante a semana para uma Diretoria de Ensino específica
    public int getAlunosPorDiretoria(String diretoria, String idioma) {
        // Variável para acumular o total de alunos em inglês durante a semana
        int totalAlunos = 0;

        // Realiza a travessia in-order e obtém todos os objetos Node
        List<Node> listaEscolas = arvoreEscolas.inOrderTraversal();

        // Itera sobre cada nó na lista para somar o número de alunos em inglês para a diretoria especificada
        for (Node node : listaEscolas) {
            Escola escola = node.getData(); // Extrai o objeto Escola do nó
            // Verifica se a escola pertence à diretoria desejada
            if (escola.getDe().equals(diretoria)) {

                if (idioma.equalsIgnoreCase("ingles")) {
                    totalAlunos += escola.getAlInglesDu();
                } else if (idioma.equalsIgnoreCase("espanhol")) {
                    totalAlunos += escola.getAlEspanholDu();
                } else if (idioma.equalsIgnoreCase("frances")) {
                    totalAlunos += escola.getAlFrancesDu();
                } else if (idioma.equalsIgnoreCase("chines")) {
                    totalAlunos += escola.getAlMandarimDu();
                }          
            }
        }

        // Retorna o total de alunos
        return totalAlunos;
    }


    public Map<String, Integer> getAlunosParaTodasDiretorias(String idioma) {
        Map<String, Integer> totalPorDiretoria = new HashMap<>();
        List<Node> listaEscolas = arvoreEscolas.inOrderTraversal();

        for (Node node : listaEscolas) {
            Escola escola = node.getData();
            String diretoria = escola.getDe();

            int alunos = 0;
            if (idioma.equalsIgnoreCase("ingles")) {
                alunos = escola.getAlInglesDu();
            } else if (idioma.equalsIgnoreCase("espanhol")) {
                alunos = escola.getAlEspanholDu();
            } else if (idioma.equalsIgnoreCase("frances")) {
                alunos = escola.getAlFrancesDu();
            } else if (idioma.equalsIgnoreCase("chines")) {
                alunos = escola.getAlMandarimDu();
            }

            // Atualiza o total para a diretoria no mapa
            totalPorDiretoria.put(diretoria, totalPorDiretoria.getOrDefault(diretoria, 0) + alunos);
        }

        return totalPorDiretoria;
    }

    // Método para exportar dados de todas as árvores BST para um CSV
    public static void exportarDadosParaCSV(String filePath, List<BST> databaseBST) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Escreve o cabeçalho
            writer.println("DIRETORIA_ENSINO,SEMESTRE,ALUNOS_INGLES,ALUNOS_ESPANHOL,ALUNOS_FRANCES,ALUNOS_MANDARIM");

            for (int i = 0; i < databaseBST.size(); i++) {
                BST bstTree = databaseBST.get(i);
                AnaliseEscola analise = new AnaliseEscola(bstTree);

                // Calcula o ano e o semestre
                int year = 2019 + (i / 2);
                int semester = (i % 2) + 1;
                String semestre = year + "-" + semester;

                // Obtém os totais de alunos por diretoria e idioma
                Map<String, Integer> alunosIngles = analise.getAlunosParaTodasDiretorias("ingles");
                Map<String, Integer> alunosEspanhol = analise.getAlunosParaTodasDiretorias("espanhol");
                Map<String, Integer> alunosFrances = analise.getAlunosParaTodasDiretorias("frances");
                Map<String, Integer> alunosMandarim = analise.getAlunosParaTodasDiretorias("chines");

                // Itera pelas diretorias e escreve os dados no CSV
                for (String diretoria : alunosIngles.keySet()) {
                    int totalIngles = alunosIngles.getOrDefault(diretoria, 0);
                    int totalEspanhol = alunosEspanhol.getOrDefault(diretoria, 0);
                    int totalFrances = alunosFrances.getOrDefault(diretoria, 0);
                    int totalMandarim = alunosMandarim.getOrDefault(diretoria, 0);

                    writer.println(diretoria + "," + semestre + "," + totalIngles + "," + totalEspanhol + "," + totalFrances + "," + totalMandarim);
                }
            }
            System.out.println("Arquivo CSV gerado com sucesso em: " + filePath);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
   

} // AnaliseEscola
