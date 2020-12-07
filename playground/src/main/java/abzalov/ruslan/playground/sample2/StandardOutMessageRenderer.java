package abzalov.ruslan.playground.sample2;

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
    public void setMessageProvider(MessageProvider messageProvider) {
        this.provider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.provider;
    }
}
