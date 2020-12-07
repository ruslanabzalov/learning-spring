package abzalov.ruslan.playground.sample3;

import abzalov.ruslan.playground.sample2.MessageProvider;
import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider provider;

    @Override
    public void render() {
        if (provider == null) {
            throw new RuntimeException("You must set the property messageProvider of class: " +
                    HelloWorldMessageProvider.class.getCanonicalName());
        }
        System.out.println(provider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider messageProvider) {
        this.provider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.provider;
    }
}
