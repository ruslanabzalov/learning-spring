package abzalov.ruslan.playground.sample7;

import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleSevenApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:sample7/app-context-old-property.xml");
        context.refresh();
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
        context.close();
    }
}
