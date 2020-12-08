package abzalov.ruslan.playground.sample9;

import abzalov.ruslan.playground.sample2.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")
public class MessageProviderImpl implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
