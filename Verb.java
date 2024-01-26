import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class Verb extends Vocab {

    private ArrayList<String> imperfekt;
    private ArrayList<String> perfekt;
    private ArrayList<String> plusquamperfekt;
    private ArrayList<String> praesens;
    private ArrayList<String> futurI;
    private ArrayList<String> futurII;

    public Verb(String latinInfo, List<String> translations, String lesson) {
        super("", translations, lesson);
        generateTimeForms(latinInfo);
    }

    private void generateTimeForms(String latinInfo) {
        List<String> givenForms = Arrays.asList(latinInfo.split(", "));
        String basicForm = givenForms.get(0);
        this.setBasicForm(basicForm);

        praesens = new ArrayList<String>();
        imperfekt = new ArrayList<String>();
        perfekt = new ArrayList<String>();
        plusquamperfekt = new ArrayList<String>();
        futurI = new ArrayList<String>();
        futurII = new ArrayList<String>();

        if (basicForm.endsWith("re")) {

            if (givenForms.size() == 1) {

                if (basicForm.endsWith("are")) {

                    // A KONJUGATION

                    String praesensBaseform = basicForm.substring(0, basicForm.length()-3);
                    
                    praesens.add(praesensBaseform + "o");
                    praesens.add(praesensBaseform + "as");
                    praesens.add(praesensBaseform + "at");
                    praesens.add(praesensBaseform + "amus");
                    praesens.add(praesensBaseform + "atis");
                    praesens.add(praesensBaseform + "ant");

                    imperfekt.add(praesensBaseform + "bam");
                    imperfekt.add(praesensBaseform + "bas");
                    imperfekt.add(praesensBaseform + "bat");
                    imperfekt.add(praesensBaseform + "bamus");
                    imperfekt.add(praesensBaseform + "batis");
                    imperfekt.add(praesensBaseform + "bant");

                    futurI.add(praesensBaseform + "bo");
                    futurI.add(praesensBaseform + "bis");
                    futurI.add(praesensBaseform + "bit");
                    futurI.add(praesensBaseform + "bimus");
                    futurI.add(praesensBaseform + "bitis");
                    futurI.add(praesensBaseform + "bunt");

                    String perfektBaseform = basicForm.substring(0, basicForm.length()-2) + "v";
                    
                    perfekt.add(perfektBaseform + "i");
                    perfekt.add(perfektBaseform + "isti");
                    perfekt.add(perfektBaseform + "it");
                    perfekt.add(perfektBaseform + "imus");
                    perfekt.add(perfektBaseform + "istis");
                    perfekt.add(perfektBaseform + "erunt");

                    plusquamperfekt.add(perfektBaseform + "eram");
                    plusquamperfekt.add(perfektBaseform + "eras");
                    plusquamperfekt.add(perfektBaseform + "erat");
                    plusquamperfekt.add(perfektBaseform + "eramus");
                    plusquamperfekt.add(perfektBaseform + "eratis");
                    plusquamperfekt.add(perfektBaseform + "erant");

                    futurII.add(perfektBaseform + "ero");
                    futurII.add(perfektBaseform + "eris");
                    futurII.add(perfektBaseform + "erit");
                    futurII.add(perfektBaseform + "erimus");
                    futurII.add(perfektBaseform + "eritis");
                    futurII.add(perfektBaseform + "erint");
                } else {

                    // E-KONJUGATION (?)

                    String praesensBaseform = basicForm.substring(0, basicForm.length()-2);

                    praesens.add(praesensBaseform + "o");
                    praesens.add(praesensBaseform + "s");
                    praesens.add(praesensBaseform + "t");
                    praesens.add(praesensBaseform + "mus");
                    praesens.add(praesensBaseform + "tis");
                    praesens.add(praesensBaseform + "nt");

                    imperfekt.add(praesensBaseform + "bam");
                    imperfekt.add(praesensBaseform + "bas");
                    imperfekt.add(praesensBaseform + "bat");
                    imperfekt.add(praesensBaseform + "bamus");
                    imperfekt.add(praesensBaseform + "batis");
                    imperfekt.add(praesensBaseform + "bant");

                    futurI.add(praesensBaseform + "bo");
                    futurI.add(praesensBaseform + "bis");
                    futurI.add(praesensBaseform + "bit");
                    futurI.add(praesensBaseform + "bimus");
                    futurI.add(praesensBaseform + "bitis");
                    futurI.add(praesensBaseform + "bunt");

                    String perfektBaseform = basicForm.substring(0, basicForm.length()-3) + "u";
                    
                    perfekt.add(perfektBaseform + "i");
                    perfekt.add(perfektBaseform + "isti");
                    perfekt.add(perfektBaseform + "it");
                    perfekt.add(perfektBaseform + "imus");
                    perfekt.add(perfektBaseform + "istis");
                    perfekt.add(perfektBaseform + "erunt");

                    plusquamperfekt.add(perfektBaseform + "eram");
                    plusquamperfekt.add(perfektBaseform + "eras");
                    plusquamperfekt.add(perfektBaseform + "erat");
                    plusquamperfekt.add(perfektBaseform + "eramus");
                    plusquamperfekt.add(perfektBaseform + "eratis");
                    plusquamperfekt.add(perfektBaseform + "erant");

                    futurII.add(perfektBaseform + "ero");
                    futurII.add(perfektBaseform + "eris");
                    futurII.add(perfektBaseform + "erit");
                    futurII.add(perfektBaseform + "erimus");
                    futurII.add(perfektBaseform + "eritis");
                    futurII.add(perfektBaseform + "erint");
                }

            } else {

                //KONSONANTISCHE KONJUGATION

                String firstPersPraes = givenForms.get(1);
                String praesensBaseform = firstPersPraes.substring(0, firstPersPraes.length()-1);

                praesens.add(praesensBaseform + "o");
                praesens.add(praesensBaseform + "is");
                praesens.add(praesensBaseform + "it");
                praesens.add(praesensBaseform + "imus");
                praesens.add(praesensBaseform + "itis");
                praesens.add(praesensBaseform + "unt");

                imperfekt.add(praesensBaseform + "ebam");
                imperfekt.add(praesensBaseform + "ebas");
                imperfekt.add(praesensBaseform + "ebat");
                imperfekt.add(praesensBaseform + "ebamus");
                imperfekt.add(praesensBaseform + "ebatis");
                imperfekt.add(praesensBaseform + "ebant");

                futurI.add(praesensBaseform + "am");
                futurI.add(praesensBaseform + "es");
                futurI.add(praesensBaseform + "et");
                futurI.add(praesensBaseform + "emus");
                futurI.add(praesensBaseform + "etis");
                futurI.add(praesensBaseform + "ent");

                String firstPersPerf = givenForms.get(2);
                String perfektBaseform = firstPersPerf.substring(0, firstPersPerf.length()-1);
                    
                perfekt.add(perfektBaseform + "i");
                perfekt.add(perfektBaseform + "isti");
                perfekt.add(perfektBaseform + "it");
                perfekt.add(perfektBaseform + "imus");
                perfekt.add(perfektBaseform + "istis");
                perfekt.add(perfektBaseform + "erunt");

                plusquamperfekt.add(perfektBaseform + "eram");
                plusquamperfekt.add(perfektBaseform + "eras");
                plusquamperfekt.add(perfektBaseform + "erat");
                plusquamperfekt.add(perfektBaseform + "eramus");
                plusquamperfekt.add(perfektBaseform + "eratis");
                plusquamperfekt.add(perfektBaseform + "erant");

                futurII.add(perfektBaseform + "ero");
                futurII.add(perfektBaseform + "eris");
                futurII.add(perfektBaseform + "erit");
                futurII.add(perfektBaseform + "erimus");
                futurII.add(perfektBaseform + "eritis");
                futurII.add(perfektBaseform + "erint");
            }
        }
    }

    public ArrayList<String> getImperfekt() {
        return imperfekt;
    }

    public ArrayList<String> getPerfekt() {
        return perfekt;
    }

    public ArrayList<String> getPlusquamperfekt() {
        return plusquamperfekt;
    }

    public ArrayList<String> getPraesens() {
        return praesens;
    }

    public ArrayList<String> getFuturI() {
        return futurI;
    }

    public ArrayList<String> getFuturII() {
        return futurII;
    }

    public HashMap<String, ArrayList<String>> getTimeForms() {
        HashMap<String, ArrayList<String>> allForms = new HashMap<String, ArrayList<String>>();
        allForms.put("Imperfekt", getImperfekt());
        allForms.put("Perfekt", getPerfekt());
        allForms.put("Plusquamperfekt", getPlusquamperfekt());
        allForms.put("Praesens", getPraesens());
        allForms.put("FuturI", getFuturI());
        allForms.put("FuturII", getFuturII());

        return allForms;
    }
}