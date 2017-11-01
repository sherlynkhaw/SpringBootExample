package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private GreetingRepo greetings = new GreetingRepo();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));

    }

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="World") String name) {
        return "hello world";
    }

    @RequestMapping("/allgreetings")
    public GreetingRepo allgreetings(@RequestParam(value="lol", defaultValue="lol2") String name) {
        greetings.add(new Greeting(1,"hi"));
        greetings.add(new Greeting(2,"bye"));
        greetings.add(new Greeting(3,"merry christmas"));
        return greetings;
    }
}
