import java.util.*;

public class Game {
    //1. Game outputs 10 random letters
    //2. Player can only input one word generated from letters provided per turn
    //3. Player only has 6 turns
    //4. Each player word is checked to be a word from the dictionary
    //5. If word exists then is added to a list to find sum of words
    //6. One word on list equals one point


    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
    List words = new ArrayList();

    char randChar() {
        double rand = Math.random(); //0.23446578
        int startOfPossibleRange = 'A';
        int endOfPossibleRange = 'Z';
        int rangeSize = endOfPossibleRange - startOfPossibleRange;

        //0.xyz * 25 = random index in range size. + start character number of 'A'
        char randChar = (char) ((rand * rangeSize) + startOfPossibleRange);
        return randChar;
    }

    public char[] generateHand() { //array of chars
        char[] hand = new char[10];
        for (int i = 0; i < 10; i++) {
            hand[i] = randChar();
        }
        return hand;
    } //will need to revoke if output is all consonant

    public void startGame() {
        generateHand();
        System.out.println(generateHand());
        int turn = 0;

        while (isGameOver(turn) == false) { //Game is over when reaches 10 turns
            String move = playerMove();
            if (checkDictionary(move)) { //if true
                addWordToList(move);
                System.out.println("It's a word!");
            }
            turn++;
            System.out.println("You have " + totalWords() + "points!");
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
