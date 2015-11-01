package nz.co.paperkite.espressocircleci;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import nz.co.paperkite.espressocircleci.LoginLogic;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {

    @Test
    public void tooManyProducts() {
        LoginLogic loginTest = new LoginLogic();

        boolean result = loginTest.productPurchaseAllowed(4, 0, 0);
        assertThat(result, is(false));
    }

    @Test
    public void costGreaterThanCredit() {
        LoginLogic loginTest = new LoginLogic();

        boolean result = loginTest.productPurchaseAllowed(3, 5, 4);
        assertThat(result, is(false));
    }

    @Test
    public void noCredit() {
        LoginLogic loginTest = new LoginLogic();

        boolean result = loginTest.productPurchaseAllowed(3, 0, 0);
        assertThat(result, is(false));
    }

    @Test
    public void validInput() {
        LoginLogic loginTest = new LoginLogic();

        boolean result = loginTest.productPurchaseAllowed(3, 5, 6);
        assertThat(result, is(true));
    }
}