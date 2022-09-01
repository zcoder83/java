/**********************************************
 Workshop 04
 Course:Java for C++ Programmers
 Last Name: Jeong
 First Name: Yeonkwan
 ID: 104069208
 Section: JAC444ZCC
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 2022-02-28
 **********************************************/


package workshop04;

import java.util.*;
import java.io.*;

public class HangmanGame {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        //keep playing or not 'y' or 'n'
        String keepPlaying;
        do {
            //get a word from the file
            char[] word = getWord();

            //display '*' in the word
            char[] asterisks = new char[word.length];
            //fill '*'
            fillAsterisks(asterisks);

            int missed = 0;
            do {
                //get letter from user for guessing
                char guessLetter = getGuess(asterisks);

                // Check the guessLetter is correct or not
                if (!isCorrectGuess(word, asterisks, guessLetter))
                    missed++;

            } while (!isFinished(asterisks));

            // Print results
            print(word, missed);
            addWord();
            // Ask the user whether to continue to play with another word
            System.out.println("Do you want to guess another word? Enter y or n>");
            keepPlaying = input.next();

        } while (keepPlaying.charAt(0) == 'y');
    }

    /* getWord randomly generates a word from a file */
    public static char[] getWord() throws FileNotFoundException {
        // Create File object
        File file = new File("hangman.txt");

        // Check if file exists
        if (!file.exists()) {
            System.out.print("File " + file.getName() + " does not exist");
            System.exit(1);
        }

        // Create an ArrayList
        ArrayList<String> words = new ArrayList<>();
        try (
                // Create input file
                Scanner input = new Scanner(file);
        ) {
            while (input.hasNext()) {
                words.add(input.next());
            }
        }

        // Pick a random string
        String pick = words.get((int) (Math.random() * words.size()));

        // Convert string to character array
        char[] word = pick.toCharArray();

        return word;
    }


    /**
     * fillAsterisks initializes a list with asterisks
     */
    public static void fillAsterisks(char[] asterisks) {
        for (int i = 0; i < asterisks.length; i++) {
            asterisks[i] = '*';
        }
    }

    /**
     * getGuess prompts the user to guess one letter at a time
     */
    public static char getGuess(char[] asterisks) {
        Scanner input = new Scanner(System.in);
        System.out.print("(Guess) Enter a letter in word ");
        System.out.print(asterisks);
        System.out.print(" > ");
        String g = input.next();

        return g.charAt(0);
    }

    /**
     * checkGuess tests if the users guess was correct
     */
    public static boolean isCorrectGuess(char[] word, char[] asterisks, char guess) {
        boolean correct = false;
        int message = 2;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                correct = true;
                if (asterisks[i] == guess)
                    message = 1;
                else {
                    asterisks[i] = guess;
                    message = 0;
                }
            }
        }
        if (message > 0)
            print(message, guess);
        return correct;
    }


    public static boolean isFinished(char[] blanks) {
        // there is no asterisk, then it's finished.
        for (char e : blanks) {
            if (e == '*')
                return false;
        }
        return true;
    }


    public static void print(char[] word, int missed) {
        System.out.println("The word is " + new String(word)); // convert char array to String
        System.out.println(" You missed " + missed + (missed > 1 ? " times" : " time"));
    }


    public static void print(int m, char guess) {
        System.out.print("\t" + guess);
        switch (m) {
            case 1:
                System.out.println(" is already in the word");
                break;
            case 2:
                System.out.println(" is not in the word");
        }
    }


    public static void addWord() throws IOException {

        Scanner input = new Scanner(System.in);
        boolean isSame = false;
        do {
            isSame = false;
            System.out.print("Enter a new word to be added in the memory>");
            String newWord = input.next();


            try (BufferedReader br = new BufferedReader(new FileReader("hangman.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split(" ");

                    for (int i = 0; i < words.length; i++) {
                        if (newWord.equals(words[i])) {
                            isSame = true;
                        }
                    }
                }
            }
            // append word using print()
            try (FileWriter fw = new FileWriter("hangman.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                if (!isSame) {
                    out.print(" " + newWord);
                } else {
                    System.out.println(newWord + " exists already. Please enter another word.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (isSame);
    }
}