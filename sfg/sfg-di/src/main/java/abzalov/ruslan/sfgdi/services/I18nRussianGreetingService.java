package abzalov.ruslan.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("RU")
@Service("i18nService")
public class I18nRussianGreetingService implements GreetingService {

    @Override
    public String sayHello() {
        return "Привет, мир - RU";
    }
}
