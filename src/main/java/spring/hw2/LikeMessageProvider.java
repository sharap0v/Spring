package spring.hw2;


import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("like")
@Profile("like")//можно указать через профайл
@Scope("prototype")//каждый раз создается заново
public class LikeMessageProvider implements MessageProvider {

    @InjectFoodStuff
    String stuff;//бин постпроцессор везде где стоит эта анотация будет добавлять какой то продукт
    @Override
    public String getMessage() {
//        return "I like Cookies";
        return "I Like "+ stuff;
    }
}
