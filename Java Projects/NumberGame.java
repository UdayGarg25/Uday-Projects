import java.util.*;
public class NumberGame {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 1;
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int TotalScore = 0;
        
        System.out.println("NUMBER GUESSING GAME");
        System.out.println("TOTAL NUMBER OF ROUNDS : 3");
        System.out.println("ATTEMPS TO GUESS NUMBER IN EACH ROUND : 10");
        do{
        for(int i=1; i<=MAX_ROUNDS; i++) {
            int Number = random.nextInt(MAX_RANGE);
            int Attempts = 0;
            System.out.printf("Guess The Number B/w %d & %d in %d Attempts. \n", MIN_RANGE , MAX_RANGE , MAX_ATTEMPTS);
            while(Attempts < MAX_ATTEMPTS) {
                System.out.println("Guess Number");
                int Guess_No = sc.nextInt();
                Attempts++;
                if(Guess_No == Number) {
                    int Score = MAX_ATTEMPTS - Attempts;    //higher the number of attempts, the lower the score
                    TotalScore += Score;
                    System.out.printf("Hurray! Number Guessed Successfully. Attempts = %d. Round Score = %d\n", Attempts , Score);
                    break;
                }

                else if(Guess_No < Number) {
                    System.out.printf("This Number is Greater Than %d. Attempts Left = %d\n",Guess_No , MAX_ATTEMPTS - Attempts);
                }

                else if(Guess_No > Number) {
                    System.out.printf("This Number is Less Than %d. Attempts Left = %d\n",Guess_No , MAX_ATTEMPTS - Attempts);
                }
            }
            if(Attempts == MAX_ATTEMPTS) {
                System.out.printf("\nRounds = %d\n",i);
                System.out.println("Attempts = 0");
                System.out.printf("The Random No is %d\n",Number);
            }
        }
        System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase();

            if (playAgain.equals("no")) {
                break;
            }
    }     
    while(true);
        System.out.printf("Game Over. Total Score = %d\n", TotalScore);
    }
}