package spring.hw2;

public interface MessageRender {
    //отправляет сообщения кудато
     void render();
//     void setMessageProvider(MessageProvider messageProvider);
     MessageProvider getMessageProvider();
}
