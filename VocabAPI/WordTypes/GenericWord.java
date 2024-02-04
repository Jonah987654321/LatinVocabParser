package VocabAPI.WordTypes;

import java.util.List;

public class GenericWord extends Vocab {
    private String wordType;

    public GenericWord(String latin, List<String> translations, String lesson, String wordType, int id) {
        super(latin, translations, lesson, id);
        this.wordType = wordType;
    }

    @Override
    public String getWordType() {
        return wordType;
    }
}
