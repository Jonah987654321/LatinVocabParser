import VocabAPI.*;
import VocabAPI.WordTypes.Vocab;

public class Main {
    public static void main(String[] args) {
        Vocab bonus = VocabParser.getVocabByBaseForm("bonus");
        //System.out.println(bonus.getDeklinationen());
        System.out.println("\n\nsol: " + VocabParser.detectForm("sol"));
        System.out.println("\n\nsoli: " + VocabParser.detectForm("soli"));
        System.out.println("\n\nsolibus: " + VocabParser.detectForm("solibus"));
        System.out.println("\n\nvocas: " + VocabParser.detectForm("vocas"));
        System.out.println("\n\nvocabambus: " + VocabParser.detectForm("vocabamus"));
        System.out.println("\n\nvoco: " + VocabParser.detectForm("voco"));
    }
}

// sol
// soli
// solibus
// vocas
// vocabamus