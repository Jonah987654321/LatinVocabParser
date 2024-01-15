import java.util.List;

public class VocabParser {
   public static void main(String[] args) {

      System.out.println("Hello, World");

      CSVParser parser = new CSVParser("voc_list.csv");
      List<String[]> data = parser.parse();
      System.out.print(data.get(0));
   }
}
