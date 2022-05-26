package spring.hw2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//чтоб все делалось в рантайме
@Target(ElementType.FIELD)//анотация применяется только к филдам
public @interface InjectFoodStuff {

}
