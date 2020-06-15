import java.util.*;

public class Game {
    //1. Game outputs 10 random letters
    //2. Player can only input one word generated from letters provided per turn
    //3. Player only has 6 turns
    //4. Each player word is checked to be a word from the dictionary
    //5. If word exists then is added to a list to find sum of words
    //6. One word on list equals one point
    //have two arrays, 1 is vowels and 1 consonants, use random to have 2-4 vowels you want.
    // //once you have that number then use that number to pick the random vowels.

    //next work on changing char[] to arrayLists of type char.

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

    int chooseNumOfVowels() {
        double rand = Math.random();
        int minVowels = 2;
        int maxVowels = 4;
        int rangeSize = maxVowels - minVowels + 1; //a range of three numbers 2,3,4
        int randomNumVowels = (int) ((rand * rangeSize) + minVowels);
        return randomNumVowels;
    }

    char[] chooseVowels(int randomNumVowels) { //return an array of chars, input is num of vowels to choose
        char[] vowels = {'a', 'i', 'e', 'o', 'u'};
        char[] chosenRandomVowels = new char[randomNumVowels]; //create empty array with this many slots in it (2,3,4)

//        System.out.println(randomNumVowels);   <- test random vowel num selection
        for (int i = 0; i < randomNumVowels; i++) {  //for loop creates a range, starting at 0 and looping until randomNumVowels
            int randomIndex = new Random().nextInt(vowels.length); //Random is a class that has a method called nextInt and requires a parameter that is the max num to choose from.
            //vowels is an array (built in object type) the built in object has a method called "length".
            char randomVowel = vowels[randomIndex];
            //System.out.println(randomVowel); <- test random vowel picking
            //adding an element to an array
            chosenRandomVowels[i] = randomVowel; //i = index of array
        }
        return chosenRandomVowels;
    }

    char[] chooseConsonants(int numConsonants) {
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        char[] chosenRandomConsonants = new char[numConsonants];

        for (int i = 0; i < numConsonants; i++) {
            int randomIndex = new Random().nextInt(consonants.length);
            char randomConsonant = consonants[randomIndex];
            chosenRandomConsonants[i] = randomConsonant;
        }
        //System.out.println(chosenRandomConsonants);
        return chosenRandomConsonants;
    }

    List words = new ArrayList();

    char randChar() {
        double rand = Math.random(); //0.23446578 asciitable.com
        int startOfPossibleRange = 'A';//65
        int endOfPossibleRange = 'Z'; //90
        int rangeSize = endOfPossibleRange - startOfPossibleRange; //90-65 is the rangSize
        //0.xyz * 25 = random index in range size. + start character number of 'A'
        char randChar = (char) ((rand * rangeSize) + startOfPossibleRange); //taking the number version and converting it back to char version aka casting
        return randChar;
    }

    public char[] generateHand() { //array of chars
        char[] drawnHand = new char[10];
        int numVowels = chooseNumOfVowels();
        int numConsonants = 10 - numVowels;
        char[] vowelsArray = chooseVowels(numVowels);
        char[] consonantsArray = chooseConsonants(numConsonants);
        //add values from one array to another array

        for (int i = 0; i < numVowels; i++) { //assign vowels to first num vowels slots
            drawnHand[i] = vowelsArray[i]; //
        }
        int consonantsArrayIndex = 0; //moved out of for loop so it only executes once
        for (int i = numVowels; i < 10; i++) { //assign vowels to first num vowels slots
            drawnHand[i] = consonantsArray[consonantsArrayIndex];
            consonantsArrayIndex++; //increment by 1
        }
        System.out.println(drawnHand);
        return drawnHand;
    }

    public void startGame() {
        generateHand();
//        System.out.println(generateHand());
        int turn = 0;

        while (isGameOver(turn) == false) { //Game is over when reaches 10 turns
            String move = playerMove();
            if (checkDictionary(move)) { //if true
                addWordToList(move);
                System.out.println("It's a word!");
            }
            turn++;
            System.out.println("You have " + totalWords() + "point(s)!");
        }
    }

    public boolean isGameOver(int currentTurn) {
        return currentTurn > 5;
    }

    public boolean checkDictionary(String inputWord) {
        return true;
    }

    public void addWordToList(String word) {
        words.add(word); //add array list of words in this class
    }

    public int totalWords(){
        int totalCount = words.size();
        return totalCount;
    }
    public String playerMove() {
        System.out.println("Create a word with letters provided");
        Scanner scanner = new Scanner(System.in);
        String playerMove = scanner.next();
        return playerMove;
    }

}
