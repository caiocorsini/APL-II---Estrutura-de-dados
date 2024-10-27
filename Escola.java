import java.lang.reflect.Field; // para percorrer/iterar os MUITO atributos na impressão

public class Escola {
    // para o dataset em: https://dados.educacao.sp.gov.br/dataset/quantidade-de-alunos-matriculados-em-centros-de-estudo-de-l%C3%ADnguas-cel
    // dicionario do dataset: https://dados.educacao.sp.gov.br/dicion%C3%A1rio-de-dados-de-quantidade-de-alunos-matriculados-em-centros-de-estudo-de-l%C3%ADnguas-cel

    // atributos (para cada coluna)
    private String cdRede; // Código da Rede 
    private String de; // Diretoria de Ensino
    private String codMun; // Código do muncípio
    private String mun; // Município
    private String categ; // Categoria da Classe
    private String tipoEsc; // Tipo da Escola
    private String codEsc; // Código da Escola
    private String nomEsc; // Nome da Unidade Escolar

    private int alAlemaoDu; // Nº de Alunos de Alemão DURANTE A SEMANA
    private int alEspanholDu;
    private int alFrancesDu;
    private int alInglesDu;
    private int alItalianoDu;
    private int alJaponesDu;
    private int alMandarimDu;
    private int totalAlDu;

    private int alAlemaoSabSemana; // Nº de Alunos de Alemão de Sábado e Semana
    private int alEspanholSabSemana;
    private int alFrancesSabSemana;
    private int alInglesSabSemana;
    private int alItalianoSabSemana;
    private int alJaponesSabSemana;
    private int alMandarimSabSemana;

    private int alAlemaoSab; // Nº de Alunos de Alemão apenas aos sábados 
    private int alEspanholSab;
    private int alFrancesSab;
    private int alInglesSab;
    private int alItalianoSab;
    private int alJaponesSab;
    private int alMandarimSab;
    private int totalAlSab;

    private int clAlemaoDu; // Nº de Classes de Alemão durante a semana
    private int clEspanholDu;
    private int clFrancesDu;
    private int clInglesDu;
    private int clItalianoDu;
    private int clJaponesDu;
    private int clMandarimDu;
    private int totalClDu;

    private int clAlemaoSabSemana; // Nº de Classes de Alemão de Sábado e Semana
    private int clEspanholSabSemana;
    private int clFrancesSabSemana;
    private int clInglesSabSemana;
    private int clItalianoSabSemana;
    private int clJaponesSabSemana;
    private int clMandarimSabSemana;

    private int clAlemaoSab; // Nº de Classes de Alemão apenas ao sábados
    private int clEspanholSab;
    private int clFrancesSab;
    private int clInglesSab;
    private int clItalianoSab;
    private int clJaponesSab;
    private int clMandarimSab;

    private int totalClSab; // Total de Classes apenas aos sábados
    private int totalTotalAl; // Total geral de alunos de CEL 
    private int totalTotalCl; // Total geral de Classes de CEL

    // construtor
    public Escola() {
        this.cdRede = null;
        this.de = null;
        this.codMun = null;
        this.mun = null;
        this.categ = null;
        this.tipoEsc = null;
        this.codEsc = null;
        this.nomEsc = null;
        this.alAlemaoDu = 0;
        this.alEspanholDu = 0;
        this.alFrancesDu = 0;
        this.alInglesDu = 0;
        this.alItalianoDu = 0;
        this.alJaponesDu = 0;
        this.alMandarimDu = 0;
        this.totalAlDu = 0;
        this.alAlemaoSabSemana = 0;
        this.alEspanholSabSemana = 0;
        this.alFrancesSabSemana = 0;
        this.alInglesSabSemana = 0;
        this.alItalianoSabSemana = 0;
        this.alJaponesSabSemana = 0;
        this.alMandarimSabSemana = 0;
        this.alAlemaoSab = 0;
        this.alEspanholSab = 0;
        this.alFrancesSab = 0;
        this.alInglesSab = 0;
        this.alItalianoSab = 0;
        this.alJaponesSab = 0;
        this.alMandarimSab = 0;
        this.totalAlSab = 0;
        this.clAlemaoDu = 0;
        this.clEspanholDu = 0;
        this.clFrancesDu = 0;
        this.clInglesDu = 0;
        this.clItalianoDu = 0;
        this.clJaponesDu = 0;
        this.clMandarimDu = 0;
        this.totalClDu = 0;
        this.clAlemaoSabSemana = 0;
        this.clEspanholSabSemana = 0;
        this.clFrancesSabSemana = 0;
        this.clInglesSabSemana = 0;
        this.clItalianoSabSemana = 0;
        this.clJaponesSabSemana = 0;
        this.clMandarimSabSemana = 0;
        this.clAlemaoSab = 0;
        this.clEspanholSab = 0;
        this.clFrancesSab = 0;
        this.clInglesSab = 0;
        this.clItalianoSab = 0;
        this.clJaponesSab = 0;
        this.clMandarimSab = 0;
        this.totalClSab = 0;
        this.totalTotalAl = 0;
        this.totalTotalCl = 0;
    }

    // getters e setters
    public String getCdRede() { return cdRede; }
    public void setCdRede(String cdRede) { this.cdRede = cdRede; }

    public String getDe() { return de; }
    public void setDe(String de) { this.de = de; }

    public String getCodMun() { return codMun; }
    public void setCodMun(String codMun) { this.codMun = codMun; }

    public String getMun() { return mun; }
    public void setMun(String mun) { this.mun = mun; }

    public String getCateg() { return categ; }
    public void setCateg(String categ) { this.categ = categ; }

    public String getTipoEsc() { return tipoEsc; }
    public void setTipoEsc(String tipoEsc) { this.tipoEsc = tipoEsc; }

    public String getCodEsc() { return codEsc; }
    public void setCodEsc(String codEsc) { this.codEsc = codEsc; }

    public String getNomEsc() { return nomEsc; }
    public void setNomEsc(String nomEsc) { this.nomEsc = nomEsc; }

    public int getAlAlemaoDu() { return alAlemaoDu; }
    public void setAlAlemaoDu(int alAlemaoDu) { this.alAlemaoDu = alAlemaoDu; }

    public int getAlEspanholDu() { return alEspanholDu; }
    public void setAlEspanholDu(int alEspanholDu) { this.alEspanholDu = alEspanholDu; }

    public int getAlFrancesDu() { return alFrancesDu; }
    public void setAlFrancesDu(int alFrancesDu) { this.alFrancesDu = alFrancesDu; }

    public int getAlInglesDu() { return alInglesDu; }
    public void setAlInglesDu(int alInglesDu) { this.alInglesDu = alInglesDu; }

    public int getAlItalianoDu() { return alItalianoDu; }
    public void setAlItalianoDu(int alItalianoDu) { this.alItalianoDu = alItalianoDu; }

    public int getAlJaponesDu() { return alJaponesDu; }
    public void setAlJaponesDu(int alJaponesDu) { this.alJaponesDu = alJaponesDu; }

    public int getAlMandarimDu() { return alMandarimDu; }
    public void setAlMandarimDu(int alMandarimDu) { this.alMandarimDu = alMandarimDu; }

    public int getTotalAlDu() { return totalAlDu; }
    public void setTotalAlDu(int totalAlDu) { this.totalAlDu = totalAlDu; }

    public int getAlAlemaoSabSemana() { return alAlemaoSabSemana; }
    public void setAlAlemaoSabSemana(int alAlemaoSabSemana) { this.alAlemaoSabSemana = alAlemaoSabSemana; }

    public int getAlEspanholSabSemana() { return alEspanholSabSemana; }
    public void setAlEspanholSabSemana(int alEspanholSabSemana) { this.alEspanholSabSemana = alEspanholSabSemana; }

    public int getAlFrancesSabSemana() { return alFrancesSabSemana; }
    public void setAlFrancesSabSemana(int alFrancesSabSemana) { this.alFrancesSabSemana = alFrancesSabSemana; }

    public int getAlInglesSabSemana() { return alInglesSabSemana; }
    public void setAlInglesSabSemana(int alInglesSabSemana) { this.alInglesSabSemana = alInglesSabSemana; }

    public int getAlItalianoSabSemana() { return alItalianoSabSemana; }
    public void setAlItalianoSabSemana(int alItalianoSabSemana) { this.alItalianoSabSemana = alItalianoSabSemana; }

    public int getAlJaponesSabSemana() { return alJaponesSabSemana; }
    public void setAlJaponesSabSemana(int alJaponesSabSemana) { this.alJaponesSabSemana = alJaponesSabSemana; }

    public int getAlMandarimSabSemana() { return alMandarimSabSemana; }
    public void setAlMandarimSabSemana(int alMandarimSabSemana) { this.alMandarimSabSemana = alMandarimSabSemana; }

    public int getAlAlemaoSab() { return alAlemaoSab; }
    public void setAlAlemaoSab(int alAlemaoSab) { this.alAlemaoSab = alAlemaoSab; }

    public int getAlEspanholSab() { return alEspanholSab; }
    public void setAlEspanholSab(int alEspanholSab) { this.alEspanholSab = alEspanholSab; }

    public int getAlFrancesSab() { return alFrancesSab; }
    public void setAlFrancesSab(int alFrancesSab) { this.alFrancesSab = alFrancesSab; }

    public int getAlInglesSab() { return alInglesSab; }
    public void setAlInglesSab(int alInglesSab) { this.alInglesSab = alInglesSab; }

    public int getAlItalianoSab() { return alItalianoSab; }
    public void setAlItalianoSab(int alItalianoSab) { this.alItalianoSab = alItalianoSab; }

    public int getAlJaponesSab() { return alJaponesSab; }
    public void setAlJaponesSab(int alJaponesSab) { this.alJaponesSab = alJaponesSab; }

    public int getAlMandarimSab() { return alMandarimSab; }
    public void setAlMandarimSab(int alMandarimSab) { this.alMandarimSab = alMandarimSab; }

    public int getTotalAlSab() { return totalAlSab; }
    public void setTotalAlSab(int totalAlSab) { this.totalAlSab = totalAlSab; }

    public int getClAlemaoDu() { return clAlemaoDu; }
    public void setClAlemaoDu(int clAlemaoDu) { this.clAlemaoDu = clAlemaoDu; }

    public int getClEspanholDu() { return clEspanholDu; }
    public void setClEspanholDu(int clEspanholDu) { this.clEspanholDu = clEspanholDu; }

    public int getClFrancesDu() { return clFrancesDu; }
    public void setClFrancesDu(int clFrancesDu) { this.clFrancesDu = clFrancesDu; }

    public int getClInglesDu() { return clInglesDu; }
    public void setClInglesDu(int clInglesDu) { this.clInglesDu = clInglesDu; }

    public int getClItalianoDu() { return clItalianoDu; }
    public void setClItalianoDu(int clItalianoDu) { this.clItalianoDu = clItalianoDu; }

    public int getClJaponesDu() { return clJaponesDu; }
    public void setClJaponesDu(int clJaponesDu) { this.clJaponesDu = clJaponesDu; }

    public int getClMandarimDu() { return clMandarimDu; }
    public void setClMandarimDu(int clMandarimDu) { this.clMandarimDu = clMandarimDu; }

    public int getTotalClDu() { return totalClDu; }
    public void setTotalClDu(int totalClDu) { this.totalClDu = totalClDu; }

    public int getClAlemaoSabSemana() { return clAlemaoSabSemana; }
    public void setClAlemaoSabSemana(int clAlemaoSabSemana) { this.clAlemaoSabSemana = clAlemaoSabSemana; }

    public int getClEspanholSabSemana() { return clEspanholSabSemana; }
    public void setClEspanholSabSemana(int clEspanholSabSemana) { this.clEspanholSabSemana = clEspanholSabSemana; }

    public int getClFrancesSabSemana() { return clFrancesSabSemana; }
    public void setClFrancesSabSemana(int clFrancesSabSemana) { this.clFrancesSabSemana = clFrancesSabSemana; }

    public int getClInglesSabSemana() { return clInglesSabSemana; }
    public void setClInglesSabSemana(int clInglesSabSemana) { this.clInglesSabSemana = clInglesSabSemana; }

    public int getClItalianoSabSemana() { return clItalianoSabSemana; }
    public void setClItalianoSabSemana(int clItalianoSabSemana) { this.clItalianoSabSemana = clItalianoSabSemana; }

    public int getClJaponesSabSemana() { return clJaponesSabSemana; }
    public void setClJaponesSabSemana(int clJaponesSabSemana) { this.clJaponesSabSemana = clJaponesSabSemana; }

    public int getClMandarimSabSemana() { return clMandarimSabSemana; }
    public void setClMandarimSabSemana(int clMandarimSabSemana) { this.clMandarimSabSemana = clMandarimSabSemana; }

    public int getClAlemaoSab() { return clAlemaoSab; }
    public void setClAlemaoSab(int clAlemaoSab) { this.clAlemaoSab = clAlemaoSab; }

    public int getClEspanholSab() { return clEspanholSab; }
    public void setClEspanholSab(int clEspanholSab) { this.clEspanholSab = clEspanholSab; }

    public int getClFrancesSab() { return clFrancesSab; }
    public void setClFrancesSab(int clFrancesSab) { this.clFrancesSab = clFrancesSab; }

    public int getClInglesSab() { return clInglesSab; }
    public void setClInglesSab(int clInglesSab) { this.clInglesSab = clInglesSab; }

    public int getClItalianoSab() { return clItalianoSab; }
    public void setClItalianoSab(int clItalianoSab) { this.clItalianoSab = clItalianoSab; }

    public int getClJaponesSab() { return clJaponesSab; }
    public void setClJaponesSab(int clJaponesSab) { this.clJaponesSab = clJaponesSab; }

    public int getClMandarimSab() { return clMandarimSab; }
    public void setClMandarimSab(int clMandarimSab) { this.clMandarimSab = clMandarimSab; }

    public int getTotalClSab() { return totalClSab; }
    public void setTotalClSab(int totalClSab) { this.totalClSab = totalClSab; }

    public int getTotalTotalAl() { return totalTotalAl; }
    public void setTotalTotalAl(int totalTotalAl) { this.totalTotalAl = totalTotalAl; }

    public int getTotalTotalCl() { return totalTotalCl; }
    public void setTotalTotalCl(int totalTotalCl) { this.totalTotalCl = totalTotalCl; }

    // metodos

    // imprimir todos os atributos de uma escola
    // opcao 0 imprime todos os atributos
    // opcao 1 OMITE os inteiros == 0
    public void printEscolas(int option) {
        // Reflexão (import java.lang.reflect.Field;) permite iterar pelos atributos de uma classe em tempo de execução!
    
        Field[] fields = this.getClass().getDeclaredFields(); // Pegar todos os atributos da classe

        for (Field field : fields) {
            try {
                Object value = field.get(this); // pega o valor atual da lista. uso da superclasse Object
    
                if (option == 0) {
                    System.out.println(field.getName() + ": " + value);
                } else if (option == 1) {
                    // Verifica se o valor não é zero para inteiros antes de imprimir
                    if (value instanceof Integer && (int) value != 0) {
                        System.out.println(field.getName() + ": " + value);
                    } else if (value instanceof String) {
                        System.out.println(field.getName() + ": " + value);
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Erro ao acessar o campo " + field.getName(), e);
            }
        }
        System.out.print("\n");
    }

}