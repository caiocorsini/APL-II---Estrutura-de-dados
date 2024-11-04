import java.util.List;

public class AnaliseEscola {

    // Atributo para armazenar a árvore BST com os dados de Escola
    private BST arvoreEscolas;

    // Construtor que recebe uma instância de BST<Escola>
    public AnaliseEscola(BST arvoreEscolas) {
        this.arvoreEscolas = arvoreEscolas;
    }

    // Método para buscar e retornar o número de alunos em inglês durante a semana para uma Diretoria de Ensino específica
    public int getAlunosInglesPorDiretoria(String diretoria) {
        // Variável para acumular o total de alunos em inglês durante a semana
        int totalAlunosIngles = 0;

        // Realiza a travessia in-order e obtém todos os objetos Escola
        List<Escola> listaEscolas = arvoreEscolas.inOrderTraversal();

        // Itera sobre cada escola na lista para somar o número de alunos em inglês para a diretoria especificada
        for (Escola escola : listaEscolas) {
            // Verifica se a escola pertence à diretoria desejada
            if (escola.getDe().equals(diretoria)) {
                totalAlunosIngles += escola.getAlInglesDu(); // Soma os alunos de inglês durante a semana
            }
        }

        // Retorna o total de alunos em inglês para a diretoria especificada
        return totalAlunosIngles;
    }
}
