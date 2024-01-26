import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class VocabTestParser {


   public List<Vocab> getAllVocabs() {
      List<Vocab> vocabulary = new ArrayList<Vocab>();

      ArrayList<String> translations = new ArrayList<String>();

      translations = new ArrayList();
      translations.add("bauen");
      vocabulary.add(new Vocab("aedificare", translations, "21"));

      translations = new ArrayList();
      translations.add("lieben");
      translations.add("verliebt sein");
      vocabulary.add(new Vocab("amare", translations, "7"));

      translations = new ArrayList();
      translations.add("öffnen");
      translations.add("aufdecken");
      vocabulary.add(new Vocab("aperire", translations, "14"));

      translations = new ArrayList();
      translations.add("vergrößern");
      translations.add("vermehren");
      vocabulary.add(new Vocab("augere", translations, "40"));

      translations = new ArrayList();
      translations.add("der Hals");
      vocabulary.add(new Vocab("collum", translations, "I8"));

      translations = new ArrayList();
      translations.add("der Rat(schlag)");
      translations.add("der Plan");
      translations.add("die Absicht");
      vocabulary.add(new Vocab("consilium", translations, "19"));

      return vocabulary;
   }
}