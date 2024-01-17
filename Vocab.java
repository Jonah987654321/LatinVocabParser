import java.util.List;

public class Vocab {
    private String basicForm;
    private List<String> translations;
    private String wordType;
    private String lesson;

    public Vocab(String basicForm, List<String> translations, String wordType, String lesson) {
        this.basicForm = basicForm;
        this.translations = translations;
        this.wordType = wordType;
        this.lesson = lesson;
    }

    public String getBasicForm() {
        return basicForm;
    }
    
    public List<String> getGerman() {
        return translations;
    }

    public String getWordType() {
        return wordType;
    }
    
    public String getLesson() {
        return lesson;
    }
}
