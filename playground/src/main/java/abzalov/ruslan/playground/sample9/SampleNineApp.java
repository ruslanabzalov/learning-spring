package abzalov.ruslan.playground.sample9;

import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleNineApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:sample9/app-context-annotation-property.xml");
        context.refresh();
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
        context.close();
    }
}
