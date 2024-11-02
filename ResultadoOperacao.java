/**
 * A classe ResultadoOperacao é uma classe auxiliar que encapsula as informações do resultado de cada operação 
 * (inserção, busca, remoção). Ela armazena o tipo de operação, o tipo de árvore (BST ou AVL), o tempo gasto 
 * na operação e o número de comparações realizadas (quando aplicável).
 */

 public class ResultadoOperacao {
    
    // atributos
    private String tipoOperacao;
    private String tipoArvore;
    private long tempoOperacao;
    private int comparacoes;

    // construtor
    public ResultadoOperacao(String tipoOperacao, String tipoArvore, long tempoOperacao, int comparacoes) {
        this.tipoOperacao = tipoOperacao;
        this.tipoArvore = tipoArvore;
        this.tempoOperacao = tempoOperacao;
        this.comparacoes = comparacoes;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public String getTipoArvore() {
        return tipoArvore;
    }

    public long getTempoOperacao() {
        return tempoOperacao;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    @Override
    public String toString() {
        return "Operação: " + tipoOperacao + ", Árvore: " + tipoArvore + ", Tempo: " + tempoOperacao + " ns, Comparações: " + comparacoes;
    }


 } // ResultadoOperacao