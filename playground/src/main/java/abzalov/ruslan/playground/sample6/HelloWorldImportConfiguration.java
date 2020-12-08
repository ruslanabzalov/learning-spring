package abzalov.ruslan.playground.sample6;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:sample2/app-context-xml.xml"})
public class HelloWorldImportConfiguration {}
