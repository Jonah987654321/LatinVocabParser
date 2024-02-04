package VocabAPI.WordTypes;

import java.util.List;

public class GenericWord extends Vocab {
    private String wordType;

    public GenericWord(String latin, List<String> translations, String lesson, String wordType) {
        super(latin, translations, lesson);
        this.wordType = wordType;
    }

    @Override
    public String getWordType() {
        return wordType;
    }
}
