package abzalov.ruslan.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("LifeCycleDemoBean Constructor!");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("My Bean name is " + name + "!");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Bean Factory has been set!");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application Context has been set!");
    }

    public void beforeInit() {
        System.out.println("Before Init - Called by Bean Post Processor!");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("The Post Construct annotated method has been called!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("The LifeCycleBean has it's properties set!");
    }

    public void afterInit() {
        System.out.println("After Init - Called by Bean Post Processor!");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("The Pre Destroy annotated method has been called!");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("The LifeCycleBean has bean terminated!");
    }
}
