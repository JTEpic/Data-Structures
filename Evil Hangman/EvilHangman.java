/**
 * This class represents a game of Evil Hangman,
 * where the computer keeps changing the word 
 * depending on what letters you have guessed
 * 
 * @author (your name) 
 * @version (the date)
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EvilHangman
{
    private boolean debug;
    private Scanner scanner;
    private List<String> words;
    private int wordLength;
    private int remainingGuesses;
    private String solution;
    private String guessedLetters;

    /**
     * Construct an EvilHangman object and initiailize all instance variables.
     * @param fineName the name of the file that contains the word list.
     * @param debug indicates if the size of the remaining word list
     *        should be included in the toString result.
     * @throws FileNotFoundException when the fileName file does not exist.
     */
    public EvilHangman(String fileName, boolean debug)
        throws FileNotFoundException
    {
        this.debug = debug;
        scanner = new Scanner(System.in);
        inputWords(fileName);
        System.out.print("Number of guesses? ");
        remainingGuesses = scanner.nextInt();
        solution = "";
        for (int i = 0; i < wordLength; i++)
            solution += "-";
        guessedLetters = "";
    }

    /**
     * Plays one the game.  The user guesses letters until either
     * they guess the word, or they run out of guesses.
     * Game status is printed each turn and winning / losing
     * information is printed at the conclusion of the game.
     */
    public void playGame()
    {
        // insert while loop here
        boolean dash=true;
        while(dash&&remainingGuesses>0){
            System.out.println(this);
            String next=inputLetter();
            guessedLetters+=next;
            words=getLargestRemaining(getPartitions(getPatterns(next),next));
            String sol=solution;
            substitute(words.get(0),next);
            if(sol.equals(solution))
                remainingGuesses--;
            dash=false;
            for(int x=0;x<solution.length();x++){
                if(solution.substring(x,x+1).equals("-")){
                    dash=true;
                }
            }
        }
        
        if(remainingGuesses > 0)
            System.out.println("You win, congratulations!");
        else
            System.out.println("You lose, sorry!");
            
        int index = (int)Math.random()*words.size();  // create a random index here   
        System.out.println("The word was \"" + words.get(index) + "\"");
    }

    /**
     * Creates and returns a status string that indicates the
     * state of the game.
     * @return the game status string.
     */
    public String toString()
    {
        String result = "\n";
        result += "Remaining guesses: " + remainingGuesses + "\n";
        result += "Guessed letters: " + guessedLetters + "\n";
        result += "Solution: " + solution + "\n";
        if (debug)
            result += "Remaining words: " + words.size() + "\n";
        return result;
    }


    ////////// PRIVATE HELPER METHODS //////////

    /**
     * Helper method for the constructor:
     * Inputs the word length from the user, reads in the words from
     * the fileName file, and initializes the words instance variable
     * with the words of the correct length.  This method loops until
     * a valid word length is entered.
     * @param fineName the name of the file that contains the word list.
     * @throws FileNotFoundException when the fileName file does not exist.
     */
    private void inputWords(String fileName) throws FileNotFoundException
    {
        words = new ArrayList<String>();

        while (words.size() == 0)
        {
            System.out.print("Word length? ");
            wordLength = scanner.nextInt();

            Scanner file = new Scanner(new File(fileName));
            while (file.hasNext())
            {
                String word = file.next();
                if (word.length() == wordLength)
                    words.add(word);
            }

            if (words.size() == 0)
                System.out.println("There are no words with " +
                    wordLength + " letters.");
        }
    }

    /**
     * Helper method for playGame:
     * Inputs a one-letter string from the user.
     * Loops until the string is a one-character character in the range
     * a-z or A-Z.
     * @return the single-letter string converted to upper-case.
     */
    private String inputLetter()
    {
        String letter = null;
        while (letter == null)
        {
            System.out.print("Next letter? ");
            letter = scanner.next().toUpperCase();

            if (letter.length() != 1 ||
                "A".compareTo(letter) > 0 ||
                "Z".compareTo(letter) < 0)
            {
                letter = null;
                System.out.println("Invalid input!");
            }
        }
        return letter;
    }

    /**
     * Helper method for getPatterns:
     * Uses word and letter to create a pattern.  The pattern string
     * has the same number of letters as word.  If a character in
     * word is the same as letter, the pattern is letter; Otherwise
     * it's "-".
     * @param word the word used to create the pattern
     * @param letter the letter used to create the pattern
     * @return the pattern
     */
    private String getPattern(String word, String letter)
    {
        String p="";
        for(int x=0;x<word.length();x++){
            if(word.substring(x,x+1).equals(letter)){
                p+=letter;
            } else
            p+="-";
        }
        return p;
    }

    /**
     * Helper method for playGame:
     * Gets the patterns for all words in words using letter.
     * @param letter the letter used to find the patterns.
     * @return the list of patterns.
     */
    private List<String> getPatterns(String letter)
    {
        List<String> s = new ArrayList<String>();
        for(String x:words){
            boolean add=true;
            for(String y:s)
            if(getPattern(x,letter).equals(y))
            add=false;
            if(add)
            s.add(getPattern(x,letter));
        }
        return s;
    }

    /**
     * Helper method for playGame:
     * Partitions each list in words based on the list of patterns
     * and letter.
     * @param patterns the list of patterns
     * @param letter the letter used to find the pattern for
     *        each word in words.
     * @return the list of partitions.  The ith partition corresponds
     *         to the ith pattern.
     */
    private List<List<String>> getPartitions(
        List<String> patterns, String letter)
    {
        List<List<String>> partitions = new ArrayList<List<String>>();
        for(int x=0;x<patterns.size();x++){
            List<String> part = new ArrayList<String>();
            partitions.add(part);
        }
        for(String x:words){
            String p=getPattern(x,letter);
            for(int y=0;y<patterns.size();y++){
                if(p.equals(patterns.get(y))){
                    partitions.get(y).add(x);
                }
            }
        }
        return partitions;
    }

    /**
     * Helper method for playGame:
     * Determines the largest of the list of partitions.
     * @param partitions the list of partitions.
     * @return the largest partition.
     */
    private List<String> getLargestRemaining(List<List<String>> partitions)
    {
        int count=0;
        for(int x=0;x<partitions.size();x++){
            if(partitions.get(x).size()>partitions.get(count).size())
            count=x;
        }
        return partitions.get(count);
    }

    /**
     * Helper method for playGame:
     * Creates a new string for solution.  If the ith letter of
     * found equals letter, then the ith letter of solution is
     * changed to letter; Otherwise it is unchanged.
     * @param found the string to check for occurances of letter.
     * @param letter the letter to check for in found.
     */
    private void substitute(String found, String letter)
    {
        String s="";
        for(int x=0;x<found.length();x++){
            if(found.substring(x,x+1).equals(letter)){
                s+=letter;
            } else
            s+=solution.substring(x,x+1);
        }
        solution=s;
    }
}
