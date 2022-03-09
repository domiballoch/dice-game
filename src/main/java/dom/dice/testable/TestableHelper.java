package dom.dice.testable;

import dom.dice.DiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestableHelper {

    @Autowired
    private TestableOutcomes testableOutcomes;

    @Autowired
    private TestableUser testableUser;

    /**
     * Switch logic to return results based on dice number
     * More results can be added cleanly
     *
     * @param rn
     * @return String result
     */
    protected void diceLogicSwitch(final int rn) {
        switch (rn) {
            case 7:
                testableOutcomes.LuckySevens(testableUser.getMyBet());
                break;
            case 2:
                testableOutcomes.SnakeEyes(testableUser.getMyBet());
                break;
            default:
                testableOutcomes.Lose(testableUser.getMyBet());
        }
    }
}
