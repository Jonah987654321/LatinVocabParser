package VocabAPI;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Adjective extends Vocab {
    private HashMap<String, ArrayList<String>> maskulinum;
    private HashMap<String, ArrayList<String>> femininum;
    private HashMap<String, ArrayList<String>> neutrum;

    private HashMap<String, ArrayList<String>> generateForms(String infinitiv, String base, String[] formsSingular, String[] formsPlural) {
        HashMap<String, ArrayList<String>> returnMap = new HashMap<String, ArrayList<String>>();

        ArrayList<String> singularList = new ArrayList<String>();
        singularList.add(infinitiv);
        for (String end : formsSingular) {
            singularList.add(base + end);
        }
        returnMap.put("Singular", singularList);

        ArrayList<String> pluralList = new ArrayList<>();
        for (String end : formsPlural) {
            pluralList.add(base + end);
        }
        returnMap.put("Plural", pluralList);

        return returnMap;
    }

    private void generateDeklination(String data) {
        ArrayList<String> dataArr = new ArrayList<String>(Arrays.asList(data.split(", ")));

        String maskulinumInfinitive = dataArr.get(0);
        String femininumInfinitive = dataArr.get(1);
        String neutrumInfinitive = dataArr.get(2);

        if ( (maskulinumInfinitive.endsWith("us") || maskulinumInfinitive.endsWith("er")) && femininumInfinitive.endsWith("a") && neutrumInfinitive.endsWith("um")) {
            String base = maskulinumInfinitive.endsWith("us") ?  maskulinumInfinitive.substring(0, maskulinumInfinitive.length()-2) : maskulinumInfinitive;
            maskulinum = generateForms(maskulinumInfinitive, base, new String[]{"i", "o", "um", "o"}, new String[]{"i", "orum", "is", "os", "is"});

            base = femininumInfinitive.substring(0, femininumInfinitive.length()-1);
            femininum = generateForms(femininumInfinitive, base, new String[]{"ae", "ae", "am", "a"}, new String[]{"ae", "arum", "is", "as", "as"});

            base = neutrumInfinitive.substring(0, neutrumInfinitive.length()-2);
            neutrum = generateForms(neutrumInfinitive, base, new String[]{"i", "o", "um", "o"}, new String[]{"a", "orum", "is", "a", "a"});

        } else if (maskulinumInfinitive.endsWith("ior") && femininumInfinitive.endsWith("ior") && neutrumInfinitive.endsWith("ius")) {

        } else if (maskulinumInfinitive.endsWith("s") && femininumInfinitive.endsWith("s") && neutrumInfinitive.endsWith("s")) {

        } else if (maskulinumInfinitive.endsWith("is") && femininumInfinitive.endsWith("is") && neutrumInfinitive.endsWith("e")) {

        } else if (maskulinumInfinitive.endsWith("er") && femininumInfinitive.endsWith("is") && neutrumInfinitive.endsWith("e")) {

        } else {
            System.out.println(dataArr);
        }

        return;
    }

    public Adjective(String latinInfo, List<String> translations, String lesson) {
        super("", translations, lesson);
        generateDeklination(latinInfo);
    }

    public HashMap<String, ArrayList<String>> getMaskulinumDeklination() {
        return maskulinum;
    }

    public HashMap<String, ArrayList<String>> getFemininumDeklination() {
        return femininum;
    }

    public HashMap<String, ArrayList<String>> getNeutrumDeklination() {
        return neutrum;
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> getAllDeklination() {
        HashMap<String, HashMap<String, ArrayList<String>>> allDekl = new HashMap<String, HashMap<String, ArrayList<String>>>();
        allDekl.put("m", getMaskulinumDeklination());
        allDekl.put("f", getFemininumDeklination());
        allDekl.put("n", getNeutrumDeklination());

        return allDekl;
    }
}