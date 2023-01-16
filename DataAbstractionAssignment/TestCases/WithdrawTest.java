import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;

public class WithdrawTest {

    // Test: Withdraw toString method returns the correct format for checking account
    @Test
    public void testCheckingAccount(){
        Withdraw withdraw = new Withdraw(10.0, new Date(122, 11, 25, 4, 16, 17), Customer.CHECKING, 5.00);
        String expected = "Withdrawal of: $10.0 Date: Sun Dec 25 04:16:17 PST 2022 from account: Checking Current Balance in Checking is: $5.0";
        assertEquals(expected, withdraw.toString());
    }

    // Test: Withdraw toString method returns the correct format for savings account
    @Test
    public void testSavingAccount(){
       Withdraw withdraw = new Withdraw(10.0, new Date(122, 11, 25, 4, 16, 17), Customer.SAVING, 5.00);
        String expected = "Withdrawal of: $10.0 Date: Sun Dec 25 04:16:17 PST 2022 from account: Saving Current Balance in Saving is: $5.0";
        assertEquals(expected, withdraw.toString());
    }
}
