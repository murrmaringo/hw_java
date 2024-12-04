import java.util.*;

public interface GameView {
    void displayWord(String word);
    void displayGuessedLetters(Set<Character> guessedLetters);
    void displayMisses(int misses);
}

