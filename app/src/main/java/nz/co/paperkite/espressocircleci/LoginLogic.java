package nz.co.paperkite.espressocircleci;

/**
 * Created by jeruelfernandes1 on 2/11/15.
 */
public class LoginLogic {

    public boolean productPurchaseAllowed(int number, int cost, int credit) {

        if (number > 3) {
            return false;
        }
        if (cost > credit) {
            return false;
        }
        if (credit == 0) {
            return false;
        }

        return true;
    }
}
