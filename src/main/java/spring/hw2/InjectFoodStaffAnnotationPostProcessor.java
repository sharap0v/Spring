package spring.hw2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.Random;
@Component
//@RequiredArgsConstructor//анотация ламбок создает конструктор только с финальными филдами
public class InjectFoodStaffAnnotationPostProcessor implements BeanPostProcessor {

    //спринг будет прокидывать в методы бинпост процессора вызывать методы афтер и бефо
//    String[] food = {"meat","fish", "cookie","apple"};
    //вариант заполнить параметры через @value
//    @Value("meat, fish, cookie, apple")
            //или
//    @Value("${listOfFoodStaff}") не работает для бин постпроцессора
    @Autowired
    Environment environment;

    /**
     * private final Environment enviroment;
     * в этом случает автоваред можно не писать
     *
     */
//    @Autowired
//    public void setEnviroment(Environment enviroment) {
//        this.enviroment = enviroment;
//    }
    @Autowired
    public InjectFoodStaffAnnotationPostProcessor(Environment enviroment) {
        this.environment = enviroment;
    }

    String[] food;
    @PostConstruct
    public void init(){
        food = environment.getProperty("listOfFoodStaff").split(",");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //поведение метода до инициализации
        Field[] declaredFields = bean.getClass().getDeclaredFields();//получить все филды бина
        for (Field field: declaredFields) {

            InjectFoodStuff annotation = field.getAnnotation(InjectFoodStuff.class);
            if (annotation!=null){
                String foodStuff = food[new Random().nextInt(food.length-1)];
                field.setAccessible(true);// по умолчанию false доступ к филду
                ReflectionUtils.setField(field, bean, foodStuff); //задаем значение конкретному филду ввиде обьекта бин и значение фудстав
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean,beanName);
    }
}
