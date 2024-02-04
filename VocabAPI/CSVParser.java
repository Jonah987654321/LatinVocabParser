package VocabAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.InputStreamReader;

public class CSVParser {
    private InputStreamReader inputStreamReader;
    private String splitChar;
    private Integer estimatedSize;

    public CSVParser(InputStreamReader inputStreamReader, String splitChar) {
        this.inputStreamReader = inputStreamReader;
        this.splitChar = splitChar;
        this.estimatedSize = 1150;
    }

    public CSVParser(InputStreamReader inputStreamReader, String splitChar, Integer estimatedSize) {
        this.inputStreamReader = inputStreamReader;
        this.splitChar = splitChar;
        this.estimatedSize = estimatedSize;
    }

    public List<List<String>> parse() {
        List<List<String>> data = new ArrayList<>(this.estimatedSize);

        try (BufferedReader br = new BufferedReader(this.inputStreamReader)) {
            String line;

            while ((line = br.readLine()) != null) {
                data.add(Arrays.asList(line.split(this.splitChar)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
