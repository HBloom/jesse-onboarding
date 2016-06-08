package change;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ChangeController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/change")
    public Change change(@RequestParam Map<String,String> requestParams) {
        String name=requestParams.get("denoms");
        return new Change(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
