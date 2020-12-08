package abzalov.ruslan.playground.sample4;

import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Пример конфигурации с помощью Java Based Configuration.
 */
public class SampleFourApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldJavaConfiguration.class);
        MessageRenderer renderer = (MessageRenderer) context.getBean("messageRenderer");
        renderer.render();
    }
}
