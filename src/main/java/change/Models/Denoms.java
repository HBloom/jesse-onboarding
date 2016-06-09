package change;

import java.util.*;


public class Denoms {

    private final ArrayList<String> totals;

    public Denoms(ArrayList<String> totals) {
        this.totals = totals;
    }

    public ArrayList<String> getTotals() {
        return totals;
    }

    public static ArrayList printAll(int iter, ArrayList<Map> denom, Double cents, ArrayList vals, ArrayList totals) {
        ArrayList denomins = totals;
        System.out.println(cents.getClass());
        if (cents == 0.0) {
            denomins.add(vals);
            if (iter == 1) {
                return denomins;
            }
            return denomins;
        }
        if (iter == (denom.size())) {

            return denomins;
        }
        Object myVar = denom.get(iter).get("amount");
        // System.out.println("The current denom is: " + myVar);
        Double currdenom = (Double) myVar;
        for (int i = 0; i <= (cents / currdenom); i++) {
            if (vals.isEmpty()) {
              // System.out.println("Vals was empty so added " + i + " on iter: " + iter);
              vals.add(i);
            } else if (vals.size() <= iter) {
              // System.out.println("Val size and iter are equal, added: " + i + "at iter: " + iter);
              vals.add(i);
            } else {
              // System.out.println("Got to the else part and and added: " + i + "at iter: "+ iter);
              vals.set(iter, i);
            }

            // System.out.println(vals);

            printAll(iter + 1, denom, cents - i * currdenom, vals, denomins);
        }

        return denomins;
    }
}
