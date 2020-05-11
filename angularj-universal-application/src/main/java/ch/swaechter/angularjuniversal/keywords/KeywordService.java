package ch.swaechter.angularjuniversal.keywords;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This class is responsible for providing all keywords.
 *
 * @author Simon Wächter
 */
public class KeywordService {

    @NotNull
    private final List<Keyword> keywords;

    public KeywordService() {
        Keyword keyword1 = new Keyword(1, "Hallo Welt!");
        Keyword keyword2 = new Keyword(2, "Hello world!");
        Keyword keyword3 = new Keyword(3, "Здравствуй, мир!");
        this.keywords = Arrays.asList(keyword1, keyword2, keyword3);
    }

    /**
     * Get all keywords.
     *
     * @return All keywords as list
     */
    @NotNull
    public List<Keyword> getKeywords() {
        return keywords;
    }

    /**
     * get a specific keyword.
     *
     * @param id ID of the keyword
     * @return Optional keyword
     */
    @NotNull
    public Optional<Keyword> getKeyword(int id) {
        if (id >= 0 && id < keywords.size()) {
            return Optional.of(keywords.get(id));
        } else {
            return Optional.empty();
        }
    }
}
