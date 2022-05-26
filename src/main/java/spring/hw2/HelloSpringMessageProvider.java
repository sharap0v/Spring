package spring.hw2;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("hello")
@Profile("hello")//можно указать через профайл
//-Dspring.profiles.active=want параметр виртуальной машины
public class HelloSpringMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello Spring";
    }
}
