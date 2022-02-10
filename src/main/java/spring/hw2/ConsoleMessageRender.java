package spring.hw2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class ConsoleMessageRender implements MessageRender {


//    @Autowired//выполняет депенденси инжекшен
//    @Qualifier("like") //если бинам заданы имена @Component(имя) то указать бин можно так
//    private MessageProvider messageProvider;
//
//    public ConsoleMessageRender() {
//
//    }
//
//    public ConsoleMessageRender(MessageProvider messageProvider) {
//        this.messageProvider = messageProvider;
//    }

    @Override
    public void render() {
//        System.out.println(messageProvider.getMessage());
        System.out.println(getMessageProvider().getMessage());
    }

//    @Override
//    public void setMessageProvider(MessageProvider messageProvider) {
//        this.messageProvider = messageProvider;
//    }

    @Override
    @Lookup // вызывает из сингл тона прототайп
    public MessageProvider getMessageProvider() {
//        return this.messageProvider;
        return null;
    }
}
