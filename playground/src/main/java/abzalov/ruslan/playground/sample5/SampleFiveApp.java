package abzalov.ruslan.playground.sample5;

import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SampleFiveApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldAnnotationConfiguration.class);
        MessageRenderer renderer = (MessageRenderer) context.getBean("renderer");
        renderer.render();
    }
}
