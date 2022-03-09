package dom.dice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DiceCalcs {

    @Autowired
    private User user;

    protected int randomNum() {
        Random r = new Random();
        return r.nextInt(13 - 2) + 2;
    }

    protected int SnakeEyes(final int bet) {
        System.out.println(DiceConstants.YOU_WIN + bet * 2);
        user.setBalance(user.getBalance() + (bet * 2));
        System.out.println(DiceConstants.BALANCE + user.getBalance());
        return user.getBalance();
    }

    protected int LuckySevens(final int bet) {
        System.out.println(DiceConstants.YOU_WIN + bet * 7);
        user.setBalance(user.getBalance() + (bet * 7));
        System.out.println(DiceConstants.BALANCE + user.getBalance());
        return user.getBalance();
    }

    protected int Win(final int bet) {
        System.out.println(DiceConstants.YOU_WIN + bet * 11);
        user.setBalance(user.getBalance() + (bet * 11));
        System.out.println(DiceConstants.BALANCE + user.getBalance());
        return user.getBalance();
    }

    protected int Lose(final int bet) {
        System.out.println(DiceConstants.YOU_LOSE + bet);
        user.setBalance(user.getBalance() - bet);
        if(user.getBalance() <= 0){
            System.out.println("Out of funds");
        }
        System.out.println(DiceConstants.BALANCE + user.getBalance());
        return user.getBalance();
    }
}
