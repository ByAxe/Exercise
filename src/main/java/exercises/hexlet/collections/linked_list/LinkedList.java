package exercises.hexlet.collections.linked_list;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    public void add(final int index, final T element) {

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
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        return null;
    }

    @Override
    public boolean remove(final Object o) {
        return false;
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
            return null;
        }

        @Override
        public boolean hasPrevious() {
            return false;
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

        }

        @Override
        public void add(T t) {

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