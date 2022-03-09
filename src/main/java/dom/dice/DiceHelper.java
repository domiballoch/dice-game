package dom.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiceHelper {

    @Autowired
    private DiceCalcs diceCalcs;

    @Autowired
    private User user;

    /**
     * Switch logic to return results based on dice number
     *
     * @param rn
     * @return String result
     */
    protected void diceLogicSwitch(final int rn) {
        switch (rn) {
            case 7:
                diceCalcs.LuckySevens(user.getBet());
                break;
            case 2:
                diceCalcs.SnakeEyes(user.getBet());
                break;
            default:
                diceCalcs.Lose(user.getBet());
        }
    }
}
