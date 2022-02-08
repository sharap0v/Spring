<%@ page import="spring.hw1.model.ShoppingCart" %>
<%@ page import="spring.hw1.model.Product" %>
<%@ page import="java.util.List" %>
<html>
<%--    <head>shopping_cart</head>--%>
<body>
    <h2>shopping_cart</h2>
<%--    <p>productList: ${shopping_cart.productList}</p>--%>
    <hr>
    <hr>
    <ul>
        <% if (((ShoppingCart)request.getAttribute("shopping_cart")).getProducts() != null) %>
            <% for(Product product : (List<Product>)((ShoppingCart)request.getAttribute("shopping_cart")).getProducts()) { %>
                <li>
<%--      достает значение из элемента списка              <%=product.getId()%>--%>
                    id: <%=product.getId()%>;
                    title:  <%=product.getTitle()%>;
                    cost: <%=product.getCost()%>
                    <hr>
                </li>
            <% } %>
    <hr>
    </ul>
</body>
</html>