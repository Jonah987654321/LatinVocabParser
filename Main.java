import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*VocabParser vocabParser = new VocabParser();
        List<Vocab> vocabulary = vocabParser.parseToVocab();

        Vocab test = vocabulary.get(26);
        System.out.println(test.getBasicForm());
        System.out.println(test.getGerman());
        System.out.println(test.getLesson());
        System.out.println(test.getWordType());*/

        VocabTestParser parser = new VocabTestParser();
        List<Vocab> vocabulary = parser.getAllVocabs();
        Vocab test = vocabulary.get(3);
        System.out.println(test.getGerman());
    }
}
