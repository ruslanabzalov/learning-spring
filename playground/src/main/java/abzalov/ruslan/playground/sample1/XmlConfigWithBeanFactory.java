package abzalov.ruslan.playground.sample1;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Пример конфигурации в XML без зависимостей.
 */
public class XmlConfigWithBeanFactory {

    public static void main(String... args) {
//        ApplicationContext context = SpringApplication.run(XmlConfigWithBeanFactory.class, args);
//        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("sample1/xml-bean-factory-config.xml"));
        Oracle oracle = factory.getBean("oracle", Oracle.class);
        System.out.println(oracle.defineMeaningOfLife());
    }
}
