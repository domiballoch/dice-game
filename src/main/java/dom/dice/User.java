package dom.dice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@NoArgsConstructor
@Component
public class User {

    @Autowired
    private DiceCalcs diceCalcs;

    @Autowired
    private DiceHelper diceHelper;

    private static Scanner input = new Scanner(System.in);

    @Getter
    @Setter
    private int balance = 100;

    @Getter
    private int bet;

    /**
     * User input method that accepts bets and guesses
     * performs some logic and displays to console
     */
    public void userInput() {
        int guess;
        do {
            System.out.print("\nEnter your bet: ");
            bet = input.nextInt();

            if (bet > balance || bet == 0) {
                System.out.println("Invalid bet!");
                continue;
            }
            else {
                System.out.println("Your bet is: " + bet);
            }

            System.out.print("Enter your guess between 2-12: ");
            guess = input.nextInt();

            if (guess > 12 || guess < 2) {
                System.out.println("Invalid guess!");
                continue;
            }
            System.out.println("Your guess is: " + guess);

            final int rn = diceCalcs.randomNum();
            System.out.println("Number rolled is: " + rn);

            if (rn == guess) {
                diceCalcs.Win(bet);
            }
            else {
                diceHelper.diceLogicSwitch(rn);
            }
        }
        while (balance > 0);
    }

    /**
     * Opening welcome
     * @return String as StringBuilder
     */
    protected void welcome() {
        final StringBuilder sb = new StringBuilder();
        sb.append("***************************************")
                .append("\n*WELCOME TO THE LUCKY SEVENS DICE GAME*")
                .append("\n***************************************")
                .append("\nYour starting balance is $100")
                .append("\nEach correct guess pays x11")
                .append("\nSnake Eyes pays x2")
                .append("\nLucky Sevens pays x7").toString();
        System.out.println(sb);
    }
}
