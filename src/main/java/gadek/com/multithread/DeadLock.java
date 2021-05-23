package gadek.com.multithread;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DeadLock {

    private BigDecimal balance=new BigDecimal(100);
    private Map<String, BigDecimal> history = new HashMap<>();

    public void acceptTransfer(BigDecimal amount) {
        synchronized(balance) {
            synchronized(history) {
                BigDecimal newBalance = balance.add(amount);
                this.balance = newBalance;
                this.history.put("new-transfer", amount);
            }
        }
    }

    public void withdrawMoney(BigDecimal amount) {
        synchronized(history) {
            synchronized(balance) {
                BigDecimal newBalance = balance.subtract(amount);
                this.balance = newBalance;
                this.history.put("withdrawal", amount);
            }
        }
    }


}
