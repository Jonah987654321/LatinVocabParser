import java.util.ArrayList;
import java.util.List;

public class Noun extends Vocab {
    private String genitive;
    private String gender;
    private ArrayList<String> deklination;

    public Noun(String basicForm, List<String> translations, String wordType, String lesson, String genitive, String gender) {
        super(basicForm, translations, wordType, lesson);
        this.genitive = genitive;
        this.gender = gender;
        generateDeklination();
    }

    private void generateDeklination() {
        if (this.deklination == null) {
            this.deklination = new ArrayList<String>();
        }
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<String> getDeklination() {
        return this.deklination;
    }
}
