/**
 * Esta classe lê um arquivo csv e coloca os dados em um
 * ArrayList.
 * Ainda em teste
 */

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class ReadFile {

    public static void main(String[] args) throws IOException {

        try (Scanner keyboard = new Scanner(System.in)) {

            // obter nome do arquivo
            System.out.print("Enter the name of a file: ");
            String filename = keyboard.nextLine();

            // abrir o arquivo
            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File not found: " + filename);
                return;
            }

            // declarar a 2D-ArrayList
            List<List<String>> records = new ArrayList<>();

            // Usar classe Scanner para ler o arquivo
            try (Scanner inputFile = new Scanner(file)) {
                while (inputFile.hasNextLine()) {
                    String line = inputFile.nextLine().trim();
                    if (!line.isEmpty()) {
                        records.add(getLine(line));
                    }
                }
            }

            // Print the records
            System.out.println(records.toString());
        }
    }

    // private function para ler as linhas do arquivo csv
    private static List<String> getLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowReader = new Scanner(line)) {
            rowReader.useDelimiter(",");
            while (rowReader.hasNext()) {
                values.add(rowReader.next().trim());
            }
        }
        return values;
    }

}
