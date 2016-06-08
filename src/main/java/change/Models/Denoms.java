package change;

import java.util.Arrays;
import java.util.ArrayList;


public class Denoms {

    private final ArrayList<String> totals;

    public Denoms(ArrayList<String> totals) {
        this.totals = totals;
    }

    public ArrayList<String> getTotals() {
        return totals;
    }

    public static ArrayList<String> printAll(int iter, int[] denom, int cents, int[] vals, ArrayList<String> totals) {
        ArrayList<String> denomins = totals;

        if (cents == 0) {
            denomins.add(Arrays.toString(vals));
            if (iter == 1) {
                return denomins;
            }
            return denomins;
        }
        if (iter == (denom.length)) {

            return denomins;
        }
        int currdenom = denom[iter];
        for (int i = 0; i <= (cents / currdenom); i++) {
            vals[iter] = i;
            printAll(iter + 1, denom, cents - i * currdenom, vals, denomins);
        }

        return denomins;
    }
}
