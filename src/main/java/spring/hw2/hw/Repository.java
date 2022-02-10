package spring.hw2.hw;

import java.util.List;

public interface Repository<T>{
    T getObject(int id);
    List<T> getObjects();
    void add(int id);
    void delete(int id);
}
