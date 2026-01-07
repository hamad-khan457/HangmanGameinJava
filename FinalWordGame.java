import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"java", "python", "programming", "computer", "algorithm", "developer", "keyboard", "language"};
    private static final String SCORE_FILE = "hangman_scores.txt";
    private static final String RANDOM_WORD_API = "https://random-word-api.herokuapp.com/word?number=1";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter your first name: ");
                String firstName = scanner.nextLine();
                firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);

                while (true) {
                    
                
                String chosenWord;
                if (isInternetAvailable()) {
                    chosenWord = getRandomWordFromApi();
                } else {
                    chosenWord = chooseRandomWordFromArray();
                }

                int chances = chosenWord.length() - 2;
                StringBuilder guessedWord = new StringBuilder(chosenWord);
                for (int i = 1; i < guessedWord.length() - 1; i++) {
                    guessedWord.setCharAt(i, '_');
                }
                int scoreTotal = chosenWord.length() - 2;

                while (chances > 0) {
                    System.out.println("Word: " + guessedWord);
                    System.out.println("Chances left: " + chances);

                    System.out.print("Guess a letter: ");
                    char guess = scanner.next().charAt(0);

                    if (isCorrectGuess(chosenWord, guessedWord, guess)) {
                        System.out.println("Correct guess!");
                    } else {
                        chances--;
                        scoreTotal--;
                        System.out.println("Incorrect guess. Chances left: " + chances);
                    }
                    if (chances == 0){
                        System.out.println("You did not guessed the word. The correct word is : " + chosenWord);
                          savePlayerInfo(firstName, chosenWord, scoreTotal);
                    }

                    if (chosenWord.equals(guessedWord.toString())) {
                        System.out.println(firstName + "  " + "Congratulations! You guessed the word: " + chosenWord);
                        System.out.println("Your score: " + (scoreTotal / (float) (chosenWord.length() - 2)) * 10);

                        savePlayerInfo(firstName, chosenWord, scoreTotal);
                        break;
                    }
                }

                System.out.print("Do you want to play again? (1 for yes, 0 for no): ");
                int playAgain = scanner.nextInt();

                if (playAgain != 1) {
                    System.out.println(firstName + "  " + "Goodbye!");
                    break;
                }
                else{
                    continue;
                }
            }
            break;
        }
             catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid input.");
                scanner.nextLine(); // Consume the invalid input
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static boolean isCorrectGuess(String word, StringBuilder guessedWord, char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guessedWord.setCharAt(i, guess);
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    private static String getRandomWordFromApi() throws IOException {
        URL url = new URL(RANDOM_WORD_API);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString().replaceAll("[\\[\\]\"]", "");
        } finally {
            connection.disconnect();
        }
    }

    private static String chooseRandomWordFromArray() {
        Random random = new Random();
        return WORDS[random.nextInt(WORDS.length)];
    }

    private static void savePlayerInfo(String playerName, String chosenWord, int score) {
        try (FileWriter fileWriter = new FileWriter(SCORE_FILE, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            printWriter.println(playerName + "     :       " + chosenWord +  "      :     "  + (score / (float) (chosenWord.length() - 2)) * 10);
            System.out.println("Player information saved.");

        } catch (IOException e) {
            System.out.println("Error saving player information: " + e.getMessage());
        }
    }

    private static boolean isInternetAvailable() {
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }
}

