package exercises.hexlet.collections.map;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayBasedMap<K, V> implements Map<K, V> {

    private List<Pair> values = new ArrayList<Pair>();

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
        return values.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return values.stream().map(Pair::getKey).anyMatch(key::equals);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.stream().map(Pair::getValue).anyMatch(value::equals);
    }

    @Override
    public V get(Object key) {
//        values.stream().filter(key::equals).flatMap(Pair::getValue);
        for (Pair item : values) {
            if (item.getKey().equals(key)) return item.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        V oldValue = null;

        if (containsKey(key)) {
            for (Pair item : values) {
                if (item.getKey().equals(key)) item.value = value;
                else oldValue = item.value;
            }
        } else {
            values.add(new Pair(key, value));
        }

        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V value = null;
        for (int i = 0; i < values.size(); i++) {
            final Pair p = values.get(i);
            if (p.getKey().equals(key)) {
                value = p.getValue();
                values.remove(i);
                return value;
            }
        }
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

        for (Map.Entry<K, V> e : (Set<Map.Entry<K, V>>) (Set) m.entrySet())
            put(e.getKey(), e.getValue());
    }

    @Override
    public void clear() {
        values = new ArrayList<Pair>();
    }

    @Override
    public Set<K> keySet() {
        return values.stream().map(Pair::getKey).collect(Collectors.toSet());
    }

    @Override
    public Collection<V> values() {
        return values.stream().map(Pair::getValue).collect(Collectors.toList());
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return (Set<Entry<K, V>>) (Set) new HashSet<>(values);
    }

    private class Pair implements Map.Entry<K, V> {

        private final K key;

        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            final V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            @SuppressWarnings({"rawtypes", "unchecked"})
            Map.Entry<K, V> pair = (Map.Entry<K, V>) o;


            return key != null ?
                    key.equals(pair.getKey()) :
                    pair.getKey() == null && !(value != null ?
                            !value.equals(pair.getValue()) :
                            pair.getValue() != null);

        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }
    }
}