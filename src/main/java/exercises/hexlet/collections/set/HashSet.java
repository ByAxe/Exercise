package exercises.hexlet.collections.set;


import exercises.hexlet.collections.map.ArrayBasedMap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashSet<T> implements Set<T> {

    private static final Boolean EXIST = true;

    private final Map<T, Boolean> elements = new ArrayBasedMap<>();

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return elements.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return elements.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return elements.keySet().toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return elements.keySet().toArray(a);
    }

    @Override
    public boolean add(T t) {
        elements.put(t, EXIST);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        elements.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        c.stream().anyMatch(this::contains);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            elements.put(item, EXIST);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.forEach(this::remove);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        this.stream().filter(item -> !c.contains(item)).forEach(this::remove);
        return true;
    }

    @Override
    public void clear() {
        elements.clear();
    }
}
