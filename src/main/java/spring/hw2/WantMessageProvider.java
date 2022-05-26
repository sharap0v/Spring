package spring.hw2;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * еще один вариант создания бина анотация Компонент
 */
@Component("want")
@Profile("want")//можно указать через профайл
//в скобках можно указать имена бинов
//@Primary // обозначаем бин приоритетным
public class WantMessageProvider implements MessageProvider {


    //создаем свою анотацию
    @InjectFoodStuff
    String stuff;

    public WantMessageProvider() {
        System.out.println("stuff from default constructor " + stuff);
    }

    @PostConstruct//анотация обозначающая инит метод
    public void init(){
        System.out.println("stuff from init method " + stuff);
    }
// за чтение анотаций отвечает бин пост процессор
    @PreDestroy// метод при разрушении бина
    public void preDestroy(){
        System.out.println("stuff from preDestroy method " + stuff);
    }

    @Override
    public String getMessage() {
        return "I want "+ stuff;
    }
}
