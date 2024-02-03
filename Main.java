
import java.util.Arrays;
import VocabAPI.Verb;

public class Main {
    public static void main(String[] args) {
        //System.out.println(VocabParser.getVocabsFromLesson("10"));
 
        Verb vtest = new Verb("merere", Arrays.asList("hinzufügen"), "10");
        System.out.println(vtest.getTimeForms());
    }
}
