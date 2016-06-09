package change;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ChangeController {

    @RequestMapping("/hash")
    public Change change(@RequestParam Map<String,String> requestParams) {

        /*

        Some intial param work being held here which
        will allow the users to submit a form with custom denoms
        // String name=requestParams.get("denoms");

        */

        Map coinOne = new HashMap();
        Map coinTwo = new HashMap();
        Map coinThree = new HashMap();
        Map coinFour = new HashMap();
        coinOne.put("name", "quater");
        coinOne.put("value", 25);
        coinOne.put("number", 3);
        coinTwo.put("name", "dime");
        coinTwo.put("value", 10);
        coinTwo.put("number", 2);
        coinThree.put("name", "nickle");
        coinThree.put("value", 5);
        coinThree.put("number", 1);
        coinFour.put("name", "penny");
        coinFour.put("value", 1);
        coinFour.put("number", 0);

        List combo = new ArrayList();
        List all = new ArrayList();

        combo.add(coinOne);
        combo.add(coinTwo);
        combo.add(coinThree);
        combo.add(coinFour);

        all.add(combo);

        return new Change(1, coinOne, all);
    }
}
