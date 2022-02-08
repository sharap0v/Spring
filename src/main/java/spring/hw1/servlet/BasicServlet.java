package spring.hw1.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;


public class BasicServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);

    private transient ServletConfig config;
//    transient параметр ненужно сериализовать
//    транзиентный для того чтоб конфиги не сериализовались

    @Override
    public void init(ServletConfig servletConfig) {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws  IOException {
//все запросы приходят в этот метод
        logger.info("new request");
        servletResponse.getWriter().println("<h1> service</h1>");
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet ";
    }

    @Override
    public void destroy() {
        //вызывается при завершении работы приложения
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}
