package VocabAPI;
import java.util.List;

import VocabAPI.WordTypes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import java.io.InputStreamReader;


public class VocabParser {
   private static ArrayList<Vocab> vocabulary;
   private static HashMap<String, ArrayList<Vocab>> vocabsByLesson;
   private static HashMap<String, Vocab> vocabsByBaseForm;

   private static List<List<String>> getData() {
      CSVParser parser = new CSVParser(new InputStreamReader(VocabParser.class.getResourceAsStream("/LatinVocabParser/VocabAPI/voc_list.csv")), ";");
      List<List<String>> data = parser.parse();

      return data;
   }

   private static void parseToVocab() {
      List<List<String>> rawData = getData();
      vocabulary = new ArrayList<Vocab>();
      vocabsByLesson = new HashMap<String, ArrayList<Vocab>>();
      vocabsByBaseForm = new HashMap<String, Vocab>();

      ArrayList<String> noDekl =  new ArrayList<String>(Arrays.asList("tot (indekl.)", "alii... alii..."));

      Iterator<List<String>> it = rawData.iterator();
      it.next(); //Skip head
      while(it.hasNext()) {
         List<String> vocab = it.next();

         Vocab tmpVocab;
         if(!noDekl.contains(vocab.get(0))) {
            switch (vocab.get(2)) {
               case "Verb":
                  tmpVocab = new Verb(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3));
                  break;

               case "Substantiv":
                  tmpVocab = new Noun(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3));
                  break;

               case "Adjektiv":
                  tmpVocab = new Adjective(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3));
                  break;
            
               default:
                  tmpVocab = new GenericWord(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3), vocab.get(2));
                  break;
            }
         } else {
            tmpVocab = new GenericWord(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3), vocab.get(2));
         }

         // Weiterhin zu beachten sind alle möglichen andere Worttypen (Adverben, Konjuktionen, etc.) und erweiterte (sowas wie Verb, unpersönlich)

         vocabulary.add(tmpVocab);
         vocabsByBaseForm.put(tmpVocab.getBasicForm(), tmpVocab);
         if (!vocabsByLesson.containsKey(vocab.get(3))) {
            vocabsByLesson.put(vocab.get(3), new ArrayList<Vocab>());
         }

         vocabsByLesson.get(vocab.get(3)).add(tmpVocab);
      }
   }

   public static ArrayList<Vocab> getAllVocabs(){
      if (vocabulary == null) {
         parseToVocab();
      }
      return vocabulary;
   }

   public static ArrayList<Vocab> getVocabsFromLesson(String lesson){
      if (vocabulary == null) {
         parseToVocab();
      }
      return vocabsByLesson.get(lesson);
   }

   public static Vocab getVocabByBaseForm(String baseForm){
      if (vocabulary == null) {
         parseToVocab();
      }
      return vocabsByBaseForm.get(baseForm);
   }
}
