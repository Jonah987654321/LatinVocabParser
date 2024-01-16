import java.util.List;

public class Vocab {
    private String latein;
    private List<String> translations;
    private String wortart;
    private String lektion;

    public Vocab(String latein, List<String> translations, String wortart, String lektion) {
        this.latein = latein;
        this.translations = translations;
        this.wortart = wortart;
        this.lektion = lektion;
    }

    public String getLatein() {
        return latein;
    }
    
    public List<String> getTranslations() {
        return translations;
    }
    
    public String getWortart() {
        return wortart;
    }
    
    public String getLektion() {
        return lektion;
    }
}
