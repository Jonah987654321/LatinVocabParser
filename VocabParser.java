import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class VocabParser {
   public List<List<String>> getData() {
      CSVParser parser = new CSVParser("voc_list.csv", ";");
      List<List<String>> data = parser.parse();

      return data;
   }

   public List<Vocab> parseToVocab() {
      List<Vocab> vocabulary = new ArrayList<Vocab>();

      getData().forEach(vocab -> vocabulary.add(new Vocab(vocab.get(0), Arrays.asList(vocab.get(1).split(", ")), vocab.get(2), vocab.get(3))));

      return vocabulary;
   }
}
