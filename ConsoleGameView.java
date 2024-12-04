import java.util.*;

public class ConsoleGameView implements GameView {

    public void displayWord(String word) {
        System.out.println("\nСлово: " + word);
    }

    public void  displayGuessedLetters(Set<Character> guessedLetters) {
        System.out.print("Угаданные буквы: ");
        for (Character letter : guessedLetters) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

    public void displayMisses(int misses) {
        System.out.println("Промахи: " + misses);
    }
}
