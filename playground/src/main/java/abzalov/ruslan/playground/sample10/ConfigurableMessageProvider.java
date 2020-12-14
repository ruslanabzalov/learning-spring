package abzalov.ruslan.playground.sample10;

import abzalov.ruslan.playground.sample2.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider {

    private final String message;

    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
