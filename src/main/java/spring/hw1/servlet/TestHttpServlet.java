package spring.hw1.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//второй вариант указания адреса вместо xml
@WebServlet(name = "TestHttpServlet", urlPatterns = "/test_http_servlet")
public class TestHttpServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(TestHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New get Request");
        logger.info(req.getContextPath());
        logger.info(req.getServletPath());
        logger.info(req.getQueryString());
        logger.info("User agent: {}", req.getHeader("User-agent"));
        resp.setHeader("Content-Type", "text/html; character=utf-8");
        resp.getWriter().printf("<h2>New get Request!</h2>");
        resp.getWriter().printf("<h2>New get Request! param1 =%s; param2 = %s</h2>", req.getParameter("param1"),req.getParameter("param2"));
        //переадресация
        getServletContext().getRequestDispatcher("/basic-servlet").forward(req,resp);
        //        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("New POST req");
        resp.getWriter().printf("<h2>Post Request!</h2>");
        resp.getWriter().printf("<h2>Post Request! body: echo %s</h2>", readAllLines(req.getReader()));
//        super.doPost(req, resp);
    }

    private String readAllLines(BufferedReader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line;
        while((line=reader.readLine())!=null){
            builder.append(line);
            builder.append(System.lineSeparator());
        }
        return  builder.toString();
    }
}
