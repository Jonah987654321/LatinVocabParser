import CSVParser.CSVParser;

public class VocabParser {
   public static void main(String[] args) {

      System.out.println("Hello, World");

      CSVParser Parser = new CSVParser("voc_list.csv");
      List<String[]> data = Parser.parse();
      System.out.print(data);
   }
}
