import java.util.HashSet;
import java.util.Set;

public class HangmanGame {

    private String secretWord;
    private int remainingAttempts;
    private Set<Character> guessedLetters;

    public HangmanGame(String word, Integer maxAttempts) {
        secretWord = word.toUpperCase();
        remainingAttempts = maxAttempts;
        guessedLetters = new HashSet<>();
    }

    public boolean guess(char letter) {
        boolean correctGuess = secretWord.indexOf(letter) != -1;
        if (!guessedLetters.contains(letter)) {
            guessedLetters.add(letter);
            if (!correctGuess) {
                remainingAttempts--;
            }
        }
        return correctGuess;
    }

    public boolean isSolved() {
        for (int i = 0; i < secretWord.length(); i++) {
            if (!guessedLetters.contains(secretWord.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return remainingAttempts == 0 || isSolved();
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }
}
