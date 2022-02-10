package spring.hw2.hw;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import spring.hw2.HelloConfiguration;
import spring.hw2.MessageRender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class HWMain {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HWConfiguration.class);
//        for (String b: context.getBeanDefinitionNames()) {
//            System.out.println(b);
//        }

        ProductRepository productRepository = context.getBean(ProductRepository.class);
//        System.out.println(productRepository);
//        System.out.println(productRepository.getObject(0));
        ArrayList<Cart> carts = new ArrayList<>();//список всех корзин создаем 10
        for (int i = 0; i < 10; i++) {
            Cart cart = context.getBean(Cart.class);
            for (int y = 0; y<new Random().nextInt(productRepository.getObjects().size()); i++){
                System.out.println("Cart "+y+" add product list:");
                cart.addProduct(productRepository.getObject(new Random().nextInt(productRepository.getObjects().size()-1)));
            }
            carts.add(cart);
        }
        int index = 0;
        for (Cart cart: carts) {
            System.out.println("Cart "+index+" product list:");
            for (Map.Entry<Integer,Product> p:
            cart.getProducts().entrySet()) {
                System.out.println(p.getValue());
            }
            index++;
        }
        System.out.println("||||||||||||||||afterDelete|||||||||||||||||||");

        for (int i = 0; i<carts.size(); i++) {
            for (int y = 0; y<new Random().nextInt(productRepository.getObjects().size()); y++){
                System.out.println("Cart "+y+" delete product list:");
                carts.get(i).deleteProduct(productRepository.getObject(new Random().nextInt(productRepository.getObjects().size()-1)));
            }
        }

        index = 0;
        for (Cart cart: carts) {
            System.out.println("Cart "+index+" product list:");
            for (Map.Entry<Integer,Product> p:
                    cart.getProducts().entrySet()) {
                System.out.println(p.getValue());
            }
            index++;
        }







    }
}
