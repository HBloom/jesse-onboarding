package change;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class DenomsController {

    @RequestMapping(value="/change", method = RequestMethod.GET)
    public ArrayList denoms(@RequestParam Map<String,String> requestParams) {

        /*

        Some intial param work being held here which
        will allow the users to submit a form with custom denoms
        // String name=requestParams.get("denoms");

        */
        Map coinOne = new HashMap();
        Map coinTwo = new HashMap();
        Map coinThree = new HashMap();
        Map coinFour = new HashMap();
        coinFour.put("name", "quater");
        coinFour.put("amount", 25.0);
        coinThree.put("name", "dime");
        coinThree.put("amount", 10.0);
        coinTwo.put("name", "nickle");
        coinTwo.put("amount", 5.0);
        coinOne.put("name", "penny");
        coinOne.put("amount", 1.0);

        ArrayList<Map> denominations = new ArrayList<Map>();
        denominations.add(coinOne);
        denominations.add(coinTwo);
        denominations.add(coinThree);
        denominations.add(coinFour);

        ArrayList<String> emptyList = new ArrayList<String>();
        Denoms myDenom = new Denoms(emptyList);
        ArrayList<Integer> vals = new ArrayList<Integer>(denominations.size());

        return myDenom.printAll(0, denominations, 100.0, vals, emptyList);
    }

    @RequestMapping(value="/post", method = RequestMethod.POST)
    public Map postMethod(@RequestParam Map<String, String> params) {
       return params;
    }
}
