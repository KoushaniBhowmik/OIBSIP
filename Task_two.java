import java.util.Scanner;
import java.util.Random;

public class Task_two{

    private static final int min_range=1;
    private static final int max_range=100;
    private static final int max_attempt=10;
    private static final int max_round=3;

    public static void main(String[] args){
        Random rd=new Random();
        Scanner sc=new Scanner(System.in);
        int totalScore=0;

        System.out.println("***NUMBER GUESSING GAME***\n");
        System.out.println("Number Range: 1 to 100");
        System.out.println("Maximum number of rounds: 3");
        System.out.println("Maximum number of attempts in each round: 10\n");
        
        for(int i=0;i<max_round;i++){
            int num=rd.nextInt(max_range)+min_range;
            int attempt=0;

            System.out.println("Round "+i+":Guess the number between "+min_range+" to "+max_range+" in "+max_attempt+" attempts\n");
            while(attempt<max_attempt){
                System.out.print("Enter your guess:");
                int guessNum=sc.nextInt();
                attempt++;
                
                if(num==guessNum){
                    totalScore+=(max_attempt-attempt);
                    System.out.printf("Hurray!!! You've guessed the number successfully.\nRound=%d.\nAttempt=%d.\nYour score:%d out of 10\n\n",i+1,attempt,totalScore);
                    return;
                }
                else if(num<guessNum){
                    System.out.printf("Your guessed number is greater than the actual number.\nAttempt left=%d.\n\n",max_attempt-attempt);
                }
                else{
                    System.out.printf("Your guessed number is less than the actual number.\nAttempt left=%d.\n\n",max_attempt-attempt);
                }
            }
            if(attempt==max_attempt){
                System.out.println("Sorry. Your attempts are over.\nBetter luck next time!!!");
                System.out.println("Random Number is:"+num);
            }
        }
        sc.close();
    }
}