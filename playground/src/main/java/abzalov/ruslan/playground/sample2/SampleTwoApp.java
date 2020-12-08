package abzalov.ruslan.playground.sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Пример конфигурации в XML с зависимостями.
 */
public class SampleTwoApp {
    public static void main(String[] args) {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("classpath:sample2/app-context-xml.xml");
        context.refresh();
        MessageRenderer renderer = context.getBean("renderer", MessageRenderer.class);
        renderer.render();
        context.close();
    }
}
