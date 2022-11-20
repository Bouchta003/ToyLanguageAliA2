package model;

import java.util.Collection;
import java.util.HashMap;
//hashmaps are the key/value functioning arrays

public class MyDictionary<K,V> implements MyIDictionary<K,V> {
    private HashMap<K, V> map;
    public MyDictionary(){

        map=new HashMap<K,V>();
    }
    @Override
    public V put(K key, V val){

        return this.map.put(key, val);
    }

    @Override
    public boolean isDefined(K key) {

        return this.map.containsKey(key);
    }

    @Override
    public Collection<V> values() {

        return this.map.values();
    }

    @Override
    public V lookup(K key){

        return this.map.get(key);
    }

    @Override
    public String toString(){

        return map.toString();
    }

}