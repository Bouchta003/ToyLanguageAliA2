package model;

import java.util.ArrayList;
import java.util.List;
public class MyList <T> implements MyIList<T> {
    private List<T> list;
    public MyList() {

        this.list = new ArrayList<>();
    }
    @Override
    public void add(T elem) {

        this.list.add(elem);
    }
    @Override
    public boolean remove(T elem) {

        return this.list.remove(elem);
    }
    @Override
    public T remove(int index) {

        return this.list.remove(index);
    }
    @Override
    public int size() {

        return this.list.size();
    }
    @Override
    public T get(int index) {

        return this.list.get(index);
    }
    @Override
    public String toString() {
        return this.list.toString();
    }
}
