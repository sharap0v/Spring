package spring.hw2.hw;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("cart")
@Getter
//@Profile("cart")
@Scope("prototype")
public class Cart {

    final HashMap<Integer,Product> products;

    public Cart(HashMap<Integer, Product> products) {
        this.products = products;
    }


    public void addProduct(Product product){
        System.out.println("Product in Cart" + products.keySet());
        if(products.containsKey(product.getId())){
            products.get(product.getId()).setCost(products.get(product.getId()).getCost()+1);
        }else {
            product = new Product(product.getId(), product.getTitle(),1);
            products.put(product.getId(),product);
        }
    }

    void deleteProduct(Product product){
        System.out.println("Product in Cart" + products.keySet());
        if (products.containsKey(product.getId())){
            if(products.get(product.getId()).getCost()>1){
                products.get(product.getId()).setCost(products.get(product.getId()).getCost()-1);
            }else if(products.get(product.getId()).getCost()==1){
                products.remove(product.getId());
            }
        }
    }
}
