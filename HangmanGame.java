import java.util.*;

public class HangmanGame implements Runnable {

    private final String secretWord;
    private Set<Character> guessedLetters = new HashSet<>();
    private int misses = 0;
    private boolean isRunning = true;
    private GameView view;

    public HangmanGame(String secretWord, GameView view) {
        this.secretWord = secretWord;
        this.view = view;
    }

    public void run() {
        while (isRunning && misses < 6) {
            view.displayWord(getMaskedWord());
            view.displayGuessedLetters(guessedLetters);
            view.displayMisses(misses);

            System.out.println("Введите букву:");
            Scanner scanner = new Scanner(System.in);
            String guess1 = scanner.nextLine();
            if (("0").equals(guess1)){
                return;
            }
            char guess = guess1.charAt(0);
            if (!guessedLetters.contains(guess)) {
                guessedLetters.add(guess);
                if (!secretWord.contains(String.valueOf(guess))) {
                    misses++;
                }
            }

            if (getMaskedWord().equals(secretWord)) {
                System.out.println("Вы выиграли! Секретное слово было: " + secretWord);
                isRunning = false;
            }
        }

        if (misses == 6) {
            System.out.println("Вы проиграли! Секретное слово было: " + secretWord);
        }
    }

    private String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            char c = secretWord.charAt(i);
            if (guessedLetters.contains(c)) {
                maskedWord.append(c);
            } else {
                maskedWord.append('_');
            }
        }
        return maskedWord.toString();
    }
}
