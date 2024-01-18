import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class VocabParser {
   public List<List<String>> getData() {
      CSVParser parser = new CSVParser("voc_list.csv", ";");
      List<List<String>> data = parser.parse();

      return data;
   }


   public List<Vocab> parseToVocab() {
      List<List<String>> rawData = getData();
      List<Vocab> vocabulary = new ArrayList<Vocab>();

      Iterator<List<String>> it = rawData.iterator();
      it.next(); //Skip head
      while(it.hasNext()) {
         List<String> vocab = it.next();

         Vocab tmpVocab;
         switch (Arrays.asList(vocab.get(2).split(", ")).get(0)) {
            case "Verb":
               tmpVocab = new Vocab(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(2), vocab.get(3));
               break;

            case "Substantiv":
               tmpVocab = new Vocab(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(2), vocab.get(3));
               break;

            case "Adjektiv":
               tmpVocab = new Vocab(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(2), vocab.get(3));
               break;
         
            default:
               tmpVocab = new Vocab(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(2), vocab.get(3));
               break;
         }

         vocabulary.add(tmpVocab); 
      }

      return vocabulary;
   }

   void getStemForms()
   {};
}
