package abzalov.ruslan.playground.sample4;

import abzalov.ruslan.playground.sample2.HelloWorldMessageProvider;
import abzalov.ruslan.playground.sample2.MessageProvider;
import abzalov.ruslan.playground.sample2.MessageRenderer;
import abzalov.ruslan.playground.sample2.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldJavaConfiguration {

    @Bean
    public MessageProvider messageProvider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
