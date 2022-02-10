package spring.hw2.hw;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Integer id;
    private String title;
    private Integer cost;

    public Product() {

    }

    /**
     * создать клас продукт не бин
     * создать класс продук репозиторий бин создать лист продуктов
     * создать бин кард прототайп
     *
     * 1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository, в виде List<Product>, при старте в него нужно добавить 5 любых товаров.
     * 2. ProductRepository позволяет получить весь список или один товар по id. Создаем бин Cart, в который можно добавлять и удалять товары по id.
     * 3. Написать консольное приложение, позволяющее управлять корзиной.
     * 4. При каждом запросе корзины из контекста, должна создаваться новая корзина.
     */
    @Override
    public String toString() {
        return "Product id: " + id +", title: " + title + " cost: " +cost + "\r";
    }

}
