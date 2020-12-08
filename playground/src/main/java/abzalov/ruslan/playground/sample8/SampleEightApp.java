package abzalov.ruslan.playground.sample8;

import abzalov.ruslan.playground.sample2.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleEightApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:sample8/app-context-config-p.xml");
        context.refresh();
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
        context.close();
    }
}
