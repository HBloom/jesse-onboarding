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

    public static ArrayList printAll(int iter, ArrayList<Map> denom, Double cents, ArrayList<Map<String, Integer>> vals, ArrayList totals) {
        ArrayList denomins = totals;
        if (cents == 0.0) {
            ArrayList<Map<String, Integer>> newArrList = new ArrayList<Map<String, Integer>>(vals);

            denomins.add(newArrList);
            if (iter == 1) {
                return denomins;
            }
            return denomins;
        }
        if (iter == denom.size()) {

            return denomins;
        }
        Object thisAmount = denom.get(iter).get("amount");
        Object thisName = denom.get(iter).get("name");
        String denomName = (String) thisName;
        Double currdenom = (Double) thisAmount;
        for (int i = 0; i <= (cents / currdenom); i++) {

            Map myMap = new HashMap();
            myMap.put("name", denomName);
            myMap.put("number", i);
            myMap.put("value", currdenom);

            if (vals.isEmpty()) {
                vals.add(myMap);
            } else if (vals.size() <= iter) {
                vals.add(myMap);
            } else {
                vals.set(iter, myMap);
            }


            Double newCents = cents - i * currdenom;

            printAll(iter + 1, denom, newCents, vals, denomins);
        }

        return denomins;
    }
}
