import java.util.List;

public class Main {
    public static void main(String[] args) {
        VocabParser vocabParser = new VocabParser();
        List<Vocab> vocabulary = vocabParser.parseToVocab();

        Vocab test = vocabulary.get(1);
        System.out.println(test.getGerman());
    }
}
