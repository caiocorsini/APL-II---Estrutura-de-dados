import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVreader {
    // atributos
    private File CSVfile;
    private List<String> CSVlines;
    private int qtdLines;
    private List<Escola> CSVescolas;
    private int qtdEscolas;

    // construtores
    public CSVreader() {
        this.CSVfile = null;
        this.CSVlines = new ArrayList<>();
        // não é necessário especificar novamente o tipo de Lista por cause de type inference
        this.qtdLines = 0;
        this.CSVescolas = new ArrayList<>();
        this.qtdEscolas = 0;
    }

    
    // egtters e setters
    public File getCSVfile() {
        return CSVfile;
    }

    public void setCSVfile(File CSVfile) {
        this.CSVfile = CSVfile;
    }

    public List<String> getCSVlines() {
        return CSVlines;
    }

    public void setCSVlines(List<String> CSVlines) {
        this.CSVlines = CSVlines;
    }

    public int getQtdLines() {
        return qtdLines;
    }

    public void setQtdLines(int qtdLines) {
        this.qtdLines = qtdLines;
    }

    public List<Escola> getCSVescolas() {
        return CSVescolas;
    }

    public void setCSVescolas(List<Escola> CSVescolas) {
        this.CSVescolas = CSVescolas;
    }

    public int getQtdEscolas() {
        return qtdEscolas;
    }

    public void setQtdEscolas(int qtdEscolas) {
        this.qtdEscolas = qtdEscolas;
    }

    // abrir o arquivo
    // arquivo precisa estar no MESMO DIRETORIO, argumento é o nome.csv
    public void openFile(String fileName) {
        try {
            this.CSVfile = new File("./" + fileName);
            if (!CSVfile.exists()) {
                throw new FileNotFoundException("Arquivo " + fileName + " não encontrado no diretório atual.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    // ler o arquivo linha por linha e salvar cada linha em uma lista de Strings
    // lembrando que qtdLines vai ser = n, sendo que temos n-1 linhas de dados e 1 linha de header (logo, qtdEscola devera ser = qtdLines-1)
    public void readFile() {

        // checar se arquivo já foi aberto
        if (CSVfile == null) {
            System.err.println("ERRO: o arquivo ainda não foi aberto.");
            return;
        }
    
        try (Scanner scanner = new Scanner(CSVfile)) { // me parece uma checagem desnecessária, mas o compilador reclama se não tratar a possível exception do Scanner
            while (scanner.hasNextLine()) {
                // nome dessa função confunde, mas pela documentação hasNextLine NÃO vai pular a última linha
                String line = scanner.nextLine();
                this.CSVlines.add(line);
                this.qtdLines++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("ERRO: Falha ao abrir o arquivo." + e.getMessage());
        }
    }

    // transformar a lista de Strings em uma lista de Escolas, tokenizando cada linha
    public void tokenizeFile() {

        // checar se arquivo já foi aberto
        if (CSVfile == null) {
            System.err.println("ERRO: o arquivo ainda não foi aberto.");
            return;
        } else if (qtdLines < 1){
            System.err.println("ERRO: nenhuma linha foi lida.");
            return;
        }

        for (int i = 1; i < qtdLines; i++) { // loop começa em 1 para ignorar a linha header
            String currentLine = this.CSVlines.get(i);
            String[] columns = currentLine.split(";");

            Escola currentEscola = new Escola();

            currentEscola.setCdRede(columns[0]);
            currentEscola.setDe(columns[1]);
            currentEscola.setCodMun(columns[2]);
            currentEscola.setMun(columns[3]);
            currentEscola.setCateg(columns[4]);
            currentEscola.setTipoEsc(columns[5]);
            currentEscola.setCodEsc(columns[6]);
            currentEscola.setNomEsc(columns[7]);

            currentEscola.setAlAlemaoDu(Integer.parseInt(columns[8]));
            currentEscola.setAlEspanholDu(Integer.parseInt(columns[9]));
            currentEscola.setAlFrancesDu(Integer.parseInt(columns[10]));
            currentEscola.setAlInglesDu(Integer.parseInt(columns[11]));
            currentEscola.setAlItalianoDu(Integer.parseInt(columns[12]));
            currentEscola.setAlJaponesDu(Integer.parseInt(columns[13]));
            currentEscola.setAlMandarimDu(Integer.parseInt(columns[14]));
            currentEscola.setTotalAlDu(Integer.parseInt(columns[15]));

            currentEscola.setAlAlemaoSabSemana(Integer.parseInt(columns[16]));
            currentEscola.setAlEspanholSabSemana(Integer.parseInt(columns[17]));
            currentEscola.setAlFrancesSabSemana(Integer.parseInt(columns[18]));
            currentEscola.setAlInglesSabSemana(Integer.parseInt(columns[19]));
            currentEscola.setAlItalianoSabSemana(Integer.parseInt(columns[20]));
            currentEscola.setAlJaponesSabSemana(Integer.parseInt(columns[21]));
            currentEscola.setAlMandarimSabSemana(Integer.parseInt(columns[22]));

            currentEscola.setAlAlemaoSab(Integer.parseInt(columns[23]));
            currentEscola.setAlEspanholSab(Integer.parseInt(columns[24]));
            currentEscola.setAlFrancesSab(Integer.parseInt(columns[25]));
            currentEscola.setAlInglesSab(Integer.parseInt(columns[26]));
            currentEscola.setAlItalianoSab(Integer.parseInt(columns[27]));
            currentEscola.setAlJaponesSab(Integer.parseInt(columns[28]));
            currentEscola.setAlMandarimSab(Integer.parseInt(columns[29]));
            currentEscola.setTotalAlSab(Integer.parseInt(columns[30]));

            currentEscola.setClAlemaoDu(Integer.parseInt(columns[31]));
            currentEscola.setClEspanholDu(Integer.parseInt(columns[32]));
            currentEscola.setClFrancesDu(Integer.parseInt(columns[33]));
            currentEscola.setClInglesDu(Integer.parseInt(columns[34]));
            currentEscola.setClItalianoDu(Integer.parseInt(columns[35]));
            currentEscola.setClJaponesDu(Integer.parseInt(columns[36]));
            currentEscola.setClMandarimDu(Integer.parseInt(columns[37]));
            currentEscola.setTotalClDu(Integer.parseInt(columns[38]));

            currentEscola.setClAlemaoSabSemana(Integer.parseInt(columns[39]));
            currentEscola.setClEspanholSabSemana(Integer.parseInt(columns[40]));
            currentEscola.setClFrancesSabSemana(Integer.parseInt(columns[41]));
            currentEscola.setClInglesSabSemana(Integer.parseInt(columns[42]));
            currentEscola.setClItalianoSabSemana(Integer.parseInt(columns[43]));
            currentEscola.setClJaponesSabSemana(Integer.parseInt(columns[44]));
            currentEscola.setClMandarimSabSemana(Integer.parseInt(columns[45]));

            currentEscola.setClAlemaoSab(Integer.parseInt(columns[46]));
            currentEscola.setClEspanholSab(Integer.parseInt(columns[47]));
            currentEscola.setClFrancesSab(Integer.parseInt(columns[48]));
            currentEscola.setClInglesSab(Integer.parseInt(columns[49]));
            currentEscola.setClItalianoSab(Integer.parseInt(columns[50]));
            currentEscola.setClJaponesSab(Integer.parseInt(columns[51]));
            currentEscola.setClMandarimSab(Integer.parseInt(columns[52]));
            currentEscola.setTotalClSab(Integer.parseInt(columns[53]));

            currentEscola.setTotalTotalAl(Integer.parseInt(columns[54]));
            currentEscola.setTotalTotalCl(Integer.parseInt(columns[55]));

            this.CSVescolas.add(currentEscola);
            qtdEscolas++;

        }

        

    }
    

    
}
