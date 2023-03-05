import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Player 1. Introduce word to guess:");
        String word = input.nextLine().toUpperCase();
        System.out.println("Player 1. Introduce max attempts:");
        Integer attempts = Integer.valueOf(input.nextLine());
        HangmanGame game = new HangmanGame(word, attempts);
        System.out.println("Player 2. Your turn");
        while (!game.isGameOver()) {
            System.out.println("Remaining attempts: " + game.getRemainingAttempts());
            System.out.println("Guessed letters: " + game.getGuessedLetters());
            System.out.println("Word: " + getDisplayWord(game));
            System.out.print("Guess a letter: ");
            char letter = input.nextLine().toUpperCase().charAt(0);
            if (!game.guess(letter)) {
                System.out.println("Wrong!");
            }
        }
        if (game.isSolved()) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Game over, the word was " + game.getSecretWord());
        }
    }

    private static String getDisplayWord(HangmanGame game) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < game.getSecretWord().length(); i++) {
            char letter = game.getSecretWord().charAt(i);
            if (game.getGuessedLetters().contains(letter)) {
                sb.append(letter);
            } else {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
