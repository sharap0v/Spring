package spring.hw2;

import java.util.Properties;

public class MessageSupportFactory {
    private static MessageSupportFactory instance;

    private Properties properties;
    private MessageProvider messageProvider;
    private MessageRender messageRender;

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }

    public MessageRender getMessageRender() {
        return messageRender;
    }

    private MessageSupportFactory(){
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/message-context.properties"));
            String renderClass = properties.getProperty("render.class");
            String providerClass = properties.getProperty("provider.class");
            messageRender = (MessageRender) Class.forName(renderClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(providerClass).newInstance();
            //4
//            messageRender.setMessageProvider(messageProvider);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
