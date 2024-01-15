public class Vocab {
    private String latein;
    private String translation;
    private String wortart;
    private String lektion;

    public Vocab(String latein, String translation, String wortart, String lektion) {
        this.latein = latein;
        this.translation = translation;
        this.wortart = wortart;
        this.lektion = lektion;
    }

    public String getLatein() {
        return latein;
    }
    
    public String getTranslation() {
        return translation;
    }
    
    public String getWortart() {
        return wortart;
    }
    
    public String getLektion() {
        return lektion;
    }
}
