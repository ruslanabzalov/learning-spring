package abzalov.ruslan.playground.sample3;

import abzalov.ruslan.playground.sample2.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World";
    }
}
