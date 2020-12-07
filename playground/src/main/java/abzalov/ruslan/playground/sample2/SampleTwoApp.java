package abzalov.ruslan.playground.sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SampleTwoApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:sample2/app-context-xml.xml");
        context.refresh();
        MessageRenderer renderer = (MessageRenderer) context.getBean("renderer");
        renderer.render();
        context.close();
    }
}
