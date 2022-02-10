package spring.hw2;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration// клас конфигурации спринга
@ComponentScan//можно явно указать какой пакет считывать
//при использовании value необходимо указать propertysource
@PropertySource("classpath:application.properties")
public class HelloConfiguration {

   /** @Bean
    public MessageProvider provider(){
        return new WantMessageProvider();
    }

    @Bean
    public MessageRender render(){
        ConsoleMessageRender render = new ConsoleMessageRender();
        render.setMessageProvider(provider());
        return render;
    }
    Еще один вариант настройки бинов)))
    */

}
