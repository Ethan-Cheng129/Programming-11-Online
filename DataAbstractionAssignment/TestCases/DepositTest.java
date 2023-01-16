import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class DepositTest {

    // Test: Deposit toString method returns the correct format for checking account
    @Test
    public void testCheckingAccount(){
        Deposit deposit = new Deposit(10.0, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING, 15.00);
        String expected = "Deposit of: $10.0 Date: Sun Dec 25 04:16:17 PST 2022 into account: Checking Current Balance in Checking is: $15.0";
        assertEquals(expected, deposit.toString());
    }

    // Test: Deposit toString method returns the correct format for savings account
    @Test
    public void testSavingAccount(){
        Deposit deposit = new Deposit(10.0, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING, 15.00);
        String expected = "Deposit of: $10.0 Date: Sun Dec 25 04:16:17 PST 2022 into account: Saving Current Balance in Saving is: $15.0";
        assertEquals(expected, deposit.toString());
    }
}
