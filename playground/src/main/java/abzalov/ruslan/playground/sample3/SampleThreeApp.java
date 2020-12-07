package abzalov.ruslan.playground.sample3;

import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleThreeApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:sample3/app-context-annotation.xml");
        context.refresh();
        MessageRenderer renderer = (MessageRenderer) context.getBean("renderer");
        renderer.render();
        context.close();
    }
}
