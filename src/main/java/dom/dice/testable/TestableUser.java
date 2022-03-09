package dom.dice.testable;

import dom.dice.DiceConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TestableUser {

    private int myBalance, myBet, myGuess, myRandom;

    @Autowired
    private TestableHelper testableHelper;

    @Autowired
    private TestableOutcomes testableOutcomes;

    public void testableInput() {
            System.out.print("\nYour bet is: " + myBet);

            if (myBet > myBalance || myBet == 0) {
                log.info("\nInvalid bet! {}", myBet);
                throw new IllegalArgumentException("Invalid bet!");
            }

            System.out.print("\nYour guess is: " + myGuess);

            if (myGuess > 12 || myGuess < 2) {
                log.info("\nInvalid guess! {}", myGuess);
                throw new IllegalArgumentException("Invalid guess!");
            }

            System.out.println("\nNumber rolled is: " + myRandom);

            if (myRandom == myGuess) {
                testableOutcomes.Win(myBet);
            }
            else {
                testableHelper.diceLogicSwitch(myRandom);
            }
    }
}
