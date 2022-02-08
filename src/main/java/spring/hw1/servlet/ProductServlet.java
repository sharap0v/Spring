package spring.hw1.servlet;


import spring.hw1.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "ProductHttpServlet",urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("product", getProduct());
        getServletContext().getRequestDispatcher("/product.jsp").forward(req,resp);

        //        super.doGet(req, resp);
    }

    private Product getProduct() {
        return new Product("1","1","1");
    }
}
