import java.util.List;

public class Adjective extends Vocab {
    private String genitive;
    private String gender;

    public Adjective(String basicForm, List<String> translations, String wordType, String lesson, String genitive, String gender) {
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