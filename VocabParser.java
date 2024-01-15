import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class VocabParser {
   public static void main(String[] args) {
      List<Vocab> allVocabs = new ArrayList<Vocab>();

      CSVParser parser = new CSVParser("voc_list.csv", ";");
      List<List<String>> data = parser.parse();

      Iterator<List<String>> it = data.iterator();
      it.next(); //Skipping head
      while (it.hasNext()) {
         List<String> vocab = it.next();
         Vocab tmpVocab = new Vocab(vocab.get(0), vocab.get(1), vocab.get(2), vocab.get(3));
         allVocabs.add(tmpVocab);
      }

      Vocab test = allVocabs.get(34);
      System.out.println(test.getLatein());
   }
}
