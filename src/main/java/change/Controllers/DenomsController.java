package change;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class DenomsController {

    @RequestMapping("/change")
    public ArrayList<String> denoms(@RequestParam Map<String,String> requestParams) {

        /*

        Some intial param work being held here which
        will allow the users to submit a form with custom denoms
        // String name=requestParams.get("denoms");

        */

        ArrayList<String> emptyList = new ArrayList<String>();
        int[] denominations = {1,10,5,25};
        Denoms myDenom = new Denoms(emptyList);
        int[] vals = new int[4];

        return myDenom.printAll(0, denominations, 100, vals, emptyList);
    }
}
