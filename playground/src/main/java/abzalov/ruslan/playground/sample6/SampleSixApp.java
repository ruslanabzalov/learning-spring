package abzalov.ruslan.playground.sample6;

import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Пример конфигурации с помощью Java Based Configuration + ImportResource.
 */
public class SampleSixApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldImportConfiguration.class);
        MessageRenderer renderer = (MessageRenderer) context.getBean("renderer");
        renderer.render();
    }
}
