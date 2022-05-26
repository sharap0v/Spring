package spring.hw2.hw;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("repository")
public class ProductRepository implements Repository<Product> {

    @InjectProduct
    List<Product> products;

//    public ProductRepository(List<Product> products) {
//        this.products = products;
//    }

    public ProductRepository() {

    }

    @Override
    public Product getObject(int id) {
        System.out.println(products.get(id));
        return products.get(id);
    }

    @Override
    public List<Product> getObjects() {
//        for (int i =0; i< products.size(); i++){
//            System.out.println(products.get(i));
//        }
        return this.products;
    }

    @Override
    public void add(int id) {
        getObject(id).setCost(getObject(id).getCost()+1);
    }

    @Override
    public void delete(int id) {
        getObject(id).setCost(getObject(id).getCost()-1);
    }

    @Override
    public String toString() {
        return "super.toString()";
    }
}
