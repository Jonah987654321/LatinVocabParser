import java.util.List;

public class Verb extends Vocab {
    private String[] stemForm;

    public Verb(String basicForm, List<String> translations, String wordType, String lesson, String[] stemForms) {
        super(basicForm, translations, wordType, lesson);

    }

    public String getStemForms() {
            return stemForms;
        }
}