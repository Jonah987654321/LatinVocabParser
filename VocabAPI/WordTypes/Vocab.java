package VocabAPI.WordTypes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Vocab {
    private String basicForm;
    private List<String> translations;
    private String lesson;

    public Vocab(String basicForm, List<String> translations, String lesson) {
        this.basicForm = basicForm;
        this.translations = translations;
        this.lesson = lesson;
    }

    protected void setBasicForm(String form) {
        this.basicForm = form;
    }

    public String getBasicForm() {
        return basicForm;
    }
    
    public List<String> getGerman() {
        return translations;
    }
    
    public String getLesson() {
        return lesson;
    }

    public String getGender() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public HashMap<String, ArrayList<String>> getMaskulinum() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public HashMap<String, ArrayList<String>> getFemininum() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public HashMap<String, ArrayList<String>> getNeutrum() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public HashMap<String, ArrayList<String>> getDeklination() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public HashMap<String, HashMap<String, ArrayList<String>>> getDeklinationen() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public ArrayList<String> getImperfekt() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public ArrayList<String> getPerfekt() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public ArrayList<String> getPlusquamperfekt() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public ArrayList<String> getPraesens() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public ArrayList<String> getFuturI() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public ArrayList<String> getFuturII() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public HashMap<String, ArrayList<String>> getTimeForms() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }

    public String getWordType() {
        throw new NoSuchMethodError("This method seems to not be implemented for this word");
    }
}
