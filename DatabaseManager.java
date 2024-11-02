import java.util.ArrayList;
import java.util.List;

// para ler um diretorio
import java.io.IOException;
import java.nio.file.*;

public class DatabaseManager {
    // atributos
    private String CSVdirectory;
    private Integer CSVqtd;
    private List<String> CSVfilenames;
    private List<CSVreader> CSVdatabase;
    private List<AVL> AVLdatabase;
    private List<BST> BSTdatabase;

    // construtor
    public DatabaseManager() {
        this.CSVdirectory = "";
        this.CSVqtd = 0;
        this.CSVfilenames = new ArrayList<>();
        this.CSVdatabase = new ArrayList<>();
        this.AVLdatabase = new ArrayList<>();
        this.BSTdatabase = new ArrayList<>();
    }

    // getters e setters (menos para as listas!)
    public String getCSVdirectory() {
        return CSVdirectory;
    }

    public boolean setDirectory(String subfolderName) {
        // como só passamos o nome da subpasta, precisamos reconstruir o diretório completo que a função espera
        Path currentDirectory = Paths.get(System.getProperty("user.dir"));
        Path fullPath = currentDirectory.resolve(subfolderName);

        // verificar se é valido
        if (Files.exists(fullPath) && Files.isDirectory(fullPath)) {
            this.CSVdirectory = fullPath.toString();
            return true;
        } else {
            System.err.println("ERRO: O diretório especificado não existe.");
            return false;
        }
    }

    public Integer getCSVqtd() {
        return CSVqtd;
    }

    public List<String> getCSVfilenames() {
        return new ArrayList<>(CSVfilenames); // Return a copy for safety
    }

    public List<CSVreader> getCSVdatabase() {
        return new ArrayList<>(CSVdatabase); // Return a copy for safety
    }

    public List<AVL> getAVLdatabase() {
        return new ArrayList<>(AVLdatabase); // Return a copy for safety
    }

    public List<BST> getBSTdatabase() {
        return new ArrayList<>(BSTdatabase); // Return a copy for safety
    }

    // metodos

    // le o conteúdo de um diretorio e popula a lista de CSVfilenames (e a qtd)
    public void readDirectory() {
        if (this.CSVdirectory == null) {
            System.err.println("ERRO: nenhum diretório foi informado.");
            return;
        }

        // lista temporaria para armazenar os filenames
        List<String> csvFiles = new ArrayList<>();

        // iterar pelos arquivos CSV do diretorio e pegar seus nomes
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(this.CSVdirectory), "*.csv")) {
            for (Path path : stream) {
                if (Files.isRegularFile(path)) {
                    csvFiles.add(path.getFileName().toString());
                }
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.err.println("ERRO: falha na leitura do diretório. " + e.getMessage());
        }

        // atualizar lista e qtd de arquivos do objeto
        this.CSVfilenames = csvFiles;
        this.CSVqtd = csvFiles.size();
    }

    // percorre os CSV no diretorio informado e inicializa CSVreaders para cada um
    public void loadCSVs() {
        if (CSVfilenames == null || CSVqtd < 1) {
            System.err.println("ERRO: nenhum CSV foi encontrado no diretorio.");
            return;
        }

        // lista temporaria para armazenar os varios CSVreaders com suas listas de Escola
        List<CSVreader> CSVReaderList = new ArrayList<>();

        for (int i = 0; i < CSVqtd; i++) {
            CSVreader CSVReaderTemp = new CSVreader();
            CSVReaderTemp.openFile(this.CSVdirectory, CSVfilenames.get(i));
            CSVReaderTemp.readFile();
            CSVReaderTemp.tokenizeFile();

            // salvar temp na lista
            CSVReaderList.add(CSVReaderTemp);
        }

        // atualizar lista de CSV do objeto
        this.CSVdatabase = CSVReaderList;
    }

    // percorre a lista de CSV readers, le as Escolas (linhas) de cada um, inicializa uma AVL e uma BST para cada CSVreader e insere as árvores nas listas do objeto
    public void createTrees() {
        if (this.CSVdatabase == null) {
            System.err.println("ERRO: nenhum CSV foi carregado.");
            return;
        }

        // percorrer todos os CSVreaders
        for (CSVreader CSVReaderTemp : this.CSVdatabase) {

            // criar AVL e BST temporarias, teremos uma para cada CSV
            AVL AVLtemp = new AVL();
            BST BSTtemp = new BST();

            // em cada CSVreader, percorrer a lista de Escolas (linhas do CSV)
            for (Escola escolaTemp : CSVReaderTemp.getCSVescolas()) {

                // e inserir cada Escola na AVL e na BST
                AVLtemp.insertAVL(escolaTemp);
                BSTtemp.insert(escolaTemp);
            }

            // inserir a AVL e a BST na lista de arvores do objeto
            this.AVLdatabase.add(AVLtemp);
            this.BSTdatabase.add(BSTtemp);
        }
    }
}
