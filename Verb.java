import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Verb extends Vocab {

    public Verb(String basicForm, List<String> translations, String wordType, String lesson) {
        super(basicForm, translations, wordType, lesson);
    }

    public ArrayList<String> getImperfekt() {
        return new ArrayList<String>();
    }

    public ArrayList<String> getPerfekt() {
        return new ArrayList<String>();
    }

    public ArrayList<String> getPlusquamperfekt() {
        return new ArrayList<String>();
    }

    public ArrayList<String> getPraesens() {
        return new ArrayList<String>();
    }

    public ArrayList<String> getFuturI() {
        return new ArrayList<String>();
    }

    public ArrayList<String> getFuturII() {
        return new ArrayList<String>();
    }

    public HashMap<String, ArrayList<String>> getTimeForms() {
        HashMap<String, ArrayList<String>> allForms = new HashMap<String, ArrayList<String>>();
        allForms.put("Imperfekt", getImperfekt());
        allForms.put("Perfekt", getPerfekt());
        allForms.put("Plusquamperfekt", getPlusquamperfekt());
        allForms.put("Praesens", getPraesens());
        allForms.put("FutureI", getFuturI());
        allForms.put("FutureII", getFuturII());

        return allForms;
    }
}