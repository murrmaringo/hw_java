import java.util.*;

public class Main {

    public static void main(String[] args) {
        String secretWord = "программирование";
        System.out.println("Для завершения игры введите 0");
        GameView view = new ConsoleGameView();
        HangmanGame game = new HangmanGame(secretWord, view);
        Thread gameThread = new Thread(game);
        gameThread.start();
    }
}
