package spring.hw2.hw;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

@Component
//@RequiredArgsConstructor//ломбок чтоб не создавать конструктор
public class InjectProductPostProcessor implements BeanPostProcessor {

    Environment environment; //окружение

    String[] data;

    @Autowired
    public InjectProductPostProcessor(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void init(){
        data  = environment.getProperty("listOfProducts").split(";");

        System.out.println(data[0]);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();//получить все филды бина
        for (Field field: declaredFields) {
            InjectProduct annotation = field.getAnnotation(InjectProduct.class);
            //для всех переменных помеченных анотацией InjectProduct выполняем следующее
            int cost = 0;
            if (annotation!=null){
                Product[] products = new Product[data.length];
                while(cost<data.length) {
                    String[] d = data[cost].split(",");
                    products[cost] =  new Product(Integer.parseInt(d[0]),d[1],Integer.parseInt(d[2]));
//                    System.out.println(products[cost]);
                    cost++;

                }
                field.setAccessible(true);// по умолчанию false доступ к филду
                ReflectionUtils.setField(field, bean, Arrays.asList(products));
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean,beanName);
    }
}
