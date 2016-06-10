package change;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class DenomsController {

    @RequestMapping(value="/change", method = RequestMethod.POST)
    public ArrayList postMethod(@RequestParam Map<String, String> requestParams) {

        String[] coinNames=requestParams.get("coinNames").split(",");
        String[] coinValues=requestParams.get("coinValues").split(",");
        double theTotalAmount=Double.parseDouble(requestParams.get("totalAmount"));
        ArrayList<Map> denominations = new ArrayList<Map>();

        for (int i = 0; i < coinValues.length; i++) {
            Map coin = new HashMap();
            double thisCoinValue = Double.parseDouble(coinValues[i]);
            coin.put("name", coinNames[i]);
            coin.put("amount", thisCoinValue);
            denominations.add(coin);
        }

        ArrayList<String> emptyList = new ArrayList<String>();
        Denoms myDenom = new Denoms(emptyList);
        ArrayList<Map<String, Integer>> vals = new ArrayList<Map<String, Integer>>();


        return Denoms.printAll(0, denominations, theTotalAmount, vals, emptyList);
    }
}
