package model;


import java.util.Collection;
import java.util.HashMap;

public interface MyIDictionary<K, V> {

    V lookup(K key);
    Collection<V> values();
    V put(K key, V val);
    boolean isDefined(K key);

}