package spring.hw2.hw;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("spring.hw2.hw")//можно явно указать какой пакет считывать
@PropertySource("classpath:application.properties")
public class HWConfiguration {
}
