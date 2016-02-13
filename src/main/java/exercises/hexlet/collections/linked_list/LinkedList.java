package exercises.hexlet.collections.linked_list;


import java.lang.reflect.Array;
import java.util.*;

public class LinkedList<T> implements List<T> {

    private Item<T> first = null;
    private Item<T> last = null;

    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean add(final T t) {
        if (isEmpty()) {
            this.first = new Item<>(t, null, null);
            this.last = null;
        } else if (size == 1) {
            this.last = new Item<>(t, this.first, null);
        } else {
            final Item<T> newLast = new Item<>(t, this.last, null);
            this.last.next = newLast;
            this.last = newLast;
        }
        size++;
        return true;
    }

    @Override
    public void add(final int index, final T t) {

    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends T> c) {
        return false;
    }

    public void addFirst(final T element) {

    }

    public void addLast(final T element) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(final Object o) {
        if (first == null) return false;
        for (T item : this) {
            if (item.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        final T[] array = (T[]) new Object[size];
        int counter = 0;
        for (T item : this) {
            array[counter++] = item;
        }
        return array;
    }

    @Override
    public <R> R[] toArray(R[] a) {
        if (a.length < size) a = (R[]) Array.newInstance(a.getClass().getComponentType(), size);

        int counter = 0;
        Object[] result = a;

        for (Item<T> e = first; e != null; e = e.next) result[counter++] = e.element;

        if (a.length > size) a[size] = null;

        return a;
    }

    @Override
    public boolean remove(final Object o) {
        if (isEmpty()) return false;
        Item<T> current = this.first;
        while (current.next != null && !current.element.equals(o)) current = current.next;

        if(current.element.equals(o)){
        }

        return true;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean equals(final Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public T get(final int index) {
        return null;
    }

    @Override
    public T set(final int index, final T element) {
        return null;
    }

    @Override
    public T remove(final int index) {
        return null;
    }

    @Override
    public int indexOf(final Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(final Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        return null;
    }


    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current;
        private Item<T> last;
        private int nextIndex;


        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            last = current;
            current = current.next;
            return last.element;
        }

        @Override
        public boolean hasPrevious() {
            return true;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(T t) {
            if (last == null) throw new IllegalStateException();
            last.element = t;
        }

        @Override
        public void add(T t) {
            LinkedList.this.add(t);
        }
    }

    private class Item<T> {
        private T element;
        private Item<T> next;
        private Item<T> previous;

        public Item(final T element, final Item<T> previous, final Item<T> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Item<T> getNext() {
            return next;
        }

        public Item<T> getPrevious() {
            return previous;
        }
    }
}