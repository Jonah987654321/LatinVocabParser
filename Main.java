import VocabAPI.*;
import VocabAPI.WordTypes.Vocab;

public class Main {
    public static void main(String[] args) {
        Vocab bonus = VocabParser.getVocabByBaseForm("bonus");
        System.out.println(bonus.getDeklinationen());
    }
}
