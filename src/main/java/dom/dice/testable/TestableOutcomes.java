package dom.dice.testable;

import dom.dice.DiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestableOutcomes {

    @Autowired
    private TestableUser testableUser;

    protected int SnakeEyes(final int bet) {
        System.out.println(DiceConstants.YOU_WIN + bet * 2);
        testableUser.setMyBalance(testableUser.getMyBalance() + (bet * 2));
        System.out.println(DiceConstants.BALANCE + testableUser.getMyBalance());
        return testableUser.getMyBalance();
    }

    protected int LuckySevens(final int bet) {
        System.out.println(DiceConstants.YOU_WIN + bet * 7);
        testableUser.setMyBalance(testableUser.getMyBalance() + (bet * 7));
        System.out.println(DiceConstants.BALANCE + testableUser.getMyBalance());
        return testableUser.getMyBalance();
    }

    protected int Win(final int bet) {
        System.out.println(DiceConstants.YOU_WIN + bet * 11);
        testableUser.setMyBalance(testableUser.getMyBalance() + (bet * 11));
        System.out.println(DiceConstants.BALANCE + testableUser.getMyBalance());
        return testableUser.getMyBalance();
    }

    protected int Lose(final int bet) {
        System.out.println(DiceConstants.YOU_LOSE + bet);
        testableUser.setMyBalance(testableUser.getMyBalance() - bet);
        if(testableUser.getMyBalance() <= 0){
            log.info("\nOut of funds");
            throw new IllegalArgumentException("\nOut of funds");
        }
        System.out.println(DiceConstants.BALANCE + testableUser.getMyBalance());
        return testableUser.getMyBalance();
    }
}
