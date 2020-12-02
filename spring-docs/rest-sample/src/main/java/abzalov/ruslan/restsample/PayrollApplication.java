package abzalov.ruslan.restsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootApplication - мета-аннотация, запускающая сканирование компонентов, автоконфигурацию
 * и поддержку свойств.
 */
@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
    }
}
