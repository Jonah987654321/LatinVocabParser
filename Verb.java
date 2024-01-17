import java.util.List;

public class Verb extends Vocab {
    private String genitive;
    private String gender;

    public Verb(String basicForm, List<String> translations, String wordType, String lesson, String genitive, String gender) {
        super(basicForm, translations, wordType, lesson);
        this.genitive = genitive;
        this.gender = gender;
    }

    public String getGenitive() {
        return genitive;
    }

    public String getGender() {
        return gender;
    }
}