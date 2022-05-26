package spring.hw2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HelloSpring {
    public static void main(String[] args) {

//        System.out.println("Hello Spring");
        //1
//        MessageProvider messageProvider = new HelloSpringMessageProvider();
//        System.out.println(messageProvider.getMessage());
        //2
//        MessageProvider messageProvider = new HelloSpringMessageProvider();
//        MessageRender messageRender = new ConsoleMessageRender();
//        messageRender.setMessageProvider(messageProvider);
//        messageRender.render();
        //3 добавление файла настроек properties
//        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
//        MessageRender messageRender = MessageSupportFactory.getInstance().getMessageRender();
//        messageRender.setMessageProvider(messageProvider);
//        messageRender.render();
        //4 внедрение зависимостей dependency injection
        // inversion of control на MessageSupportFactory
//        MessageRender messageRender = MessageSupportFactory.getInstance().getMessageRender();
//        messageRender.render();
        //Spring
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        //чтобы избавиться от бинов в xml
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));

        for (int i = 0; i < 5; i++) {
            MessageRender messageRender = context.getBean((MessageRender.class));
            messageRender.render();
        }

//        MessageRender messageRender = context.getBean(MessageRender.class);

        context.close();//в  этом случае вызывается метод @PreDestroy только для бинов синглтон
    }
}
