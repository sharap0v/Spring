package spring.hw1.servlet;

import spring.hw1.model.Product;
import spring.hw1.model.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "shopping_cart", urlPatterns = "/shopping_cart")
public class ShoppingCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setAttribute("shopping_cart", getProducts());
        getServletContext().getRequestDispatcher("/shopping_cart.jsp").forward(req,resp);

    }

    private ShoppingCart getProducts() {
        List<Product> products = Arrays.asList(
                new Product("1", "Carrot", "5"),
                new Product("3", "bacon", "4"),
                new Product("2", "chicken", "5"),
                new Product("4", "duck", "66"),
                new Product("15", "chicken", "7"),
                new Product("6", "ham", "8"),
                new Product("8", "Bread", "9"),
                new Product("9", "lamb", "9"),
                new Product("111", "liver", "0"),
                new Product("13", "meat", "54")
                );
        return new ShoppingCart(products);
    }
}
