import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
