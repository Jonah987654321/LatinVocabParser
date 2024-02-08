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
      CSVParser parser = new CSVParser(new InputStreamReader(VocabParser.class.getResourceAsStream("voc_list.csv")),
            ";");
      List<List<String>> data = parser.parse();

      return data;
   }

   private static void parseToVocab() {
      List<List<String>> rawData = getData();
      vocabulary = new ArrayList<Vocab>();
      vocabsByLesson = new HashMap<String, ArrayList<Vocab>>();
      vocabsByBaseForm = new HashMap<String, Vocab>();

      ArrayList<String> noDekl = new ArrayList<String>(Arrays.asList("tot (indekl.)", "alii... alii..."));

      Iterator<List<String>> it = rawData.iterator();
      it.next(); // Skip head
      while (it.hasNext()) {
         List<String> vocab = it.next();

         Vocab tmpVocab;
         if (!noDekl.contains(vocab.get(0))) {
            switch (vocab.get(2)) {
               case "Verb":
                  tmpVocab = new Verb(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3),
                        Integer.parseInt(vocab.get(4)));
                  break;

               case "Substantiv":
                  tmpVocab = new Noun(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3),
                        Integer.parseInt(vocab.get(4)));
                  break;

               case "Adjektiv":
                  tmpVocab = new Adjective(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3),
                        Integer.parseInt(vocab.get(4)));
                  break;

               default:
                  tmpVocab = new GenericWord(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3),
                        vocab.get(2), Integer.parseInt(vocab.get(4)));
                  break;
            }
         } else {
            tmpVocab = new GenericWord(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(3),
                  vocab.get(2), Integer.parseInt(vocab.get(4)));
         }

         // Weiterhin zu beachten sind alle möglichen andere Worttypen (Adverben,
         // Konjuktionen, etc.) und erweiterte (sowas wie Verb, unpersönlich)

         vocabulary.add(tmpVocab);
         vocabsByBaseForm.put(tmpVocab.getBasicForm(), tmpVocab);
         if (!vocabsByLesson.containsKey(vocab.get(3))) {
            vocabsByLesson.put(vocab.get(3), new ArrayList<Vocab>());
         }

         vocabsByLesson.get(vocab.get(3)).add(tmpVocab);
      }
   }

   public static ArrayList<Vocab> getAllVocabs() {
      if (vocabulary == null) {
         parseToVocab();
      }
      return vocabulary;
   }

   public static ArrayList<Vocab> getVocabsFromLesson(String lesson) {
      if (vocabulary == null) {
         parseToVocab();
      }
      return vocabsByLesson.get(lesson);
   }

   public static Vocab getVocabByBaseForm(String baseForm) {
      if (vocabulary == null) {
         parseToVocab();
      }
      return vocabsByBaseForm.get(baseForm);
   }

   private static ArrayList<Vocab> getVocabsStartingWith(String vocabPart) {
      ArrayList<Vocab> fittingVocabs = new ArrayList<>();
      for (Vocab v : vocabulary) {
         if (v.getBasicForm().startsWith(vocabPart)) {
            fittingVocabs.add(v);
         }
      }
      return fittingVocabs;
   }

   public static String detectForm(String searchedForm) {
      ArrayList<Vocab> possibleVocabs = new ArrayList<>();
      Vocab foundVocab;
      searchedForm = searchedForm.replace(" ", "");

      // find all possible vocabs
      for (int i = 1; i < searchedForm.length(); i++) {
         if (possibleVocabs.size() < 1) {
            possibleVocabs = getVocabsStartingWith(searchedForm.substring(0, searchedForm.length() - i));
         } else
            break;
      }


      // find the fitting vocab and correct form
      for (int i = 0; i < possibleVocabs.size(); i++) {
        foundVocab = possibleVocabs.get(i);
        System.out.println(foundVocab.getBasicForm());

         if (foundVocab.getClass().toString().equals("class VocabAPI.WordTypes.Verb"))
         {
            System.out.println("true");
            for (int j = 0; j < foundVocab.getPraesens().size(); j++) {
               if (foundVocab.getPraesens().get(j).equals(searchedForm)) {
                  return j + 1 + ". Person Präsens von " + foundVocab.getBasicForm();
               }
            }            for (int j = 0; j < foundVocab.getFuturI().size(); j++) {
               if (foundVocab.getFuturI().get(j).equals(searchedForm)) {
                  return j + 1 + ". Person Futur I von " + foundVocab.getBasicForm();
               }
            }

            for (int j = 0; j < foundVocab.getFuturII().size(); j++) {
               if (foundVocab.getFuturII().get(j).equals(searchedForm)) {
                  return j + 1 + ". Person Futur II von " + foundVocab.getBasicForm();
               }
            }

            for (int j = 0; j < foundVocab.getImperfekt().size(); j++) {
               if (foundVocab.getImperfekt().get(j).equals(searchedForm)) {
                  return j + 1 + ". Person Imperfekt von " + foundVocab.getBasicForm();
               }
            }

            for (int j = 0; j < foundVocab.getPerfekt().size(); j++) {
               if (foundVocab.getPerfekt().get(j).equals(searchedForm)) {
                  return j + 1 + ". Person Perfekt von " + foundVocab.getBasicForm();
               }
            }

            for (int j = 0; j < foundVocab.getPlusquamperfekt().size(); j++) {
               if (foundVocab.getPlusquamperfekt().get(j).equals(searchedForm)) {
                  return j + 1 + ". Person Plusquamperfekt von " + foundVocab.getBasicForm();
               }
            }
         }
      }
      return "Vocab not found";
   }
}