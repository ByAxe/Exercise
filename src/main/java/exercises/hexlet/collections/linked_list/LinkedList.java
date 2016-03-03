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
    public boolean add(final T element) {
        if (isEmpty()) {
            this.first = new Item<>(element, null, null);
            this.last = null;
        } else if (size == 1) {
            this.last = new Item<>(element, this.first, null);
        } else {
            final Item<T> newLast = new Item<>(element, this.last, null);
            this.last.next = newLast;
            this.last = newLast;
        }
        size++;
        return true;
    }

    @Override
    public void add(final int index, final T element) {
        rangeCheckForAdd(index);

        if (isEmpty()) {
            this.first = new Item<>(element, null, null);
        } else if (index == 1) {
            this.last = new Item<>(element, this.first, null);
        } else {
            Item<T> current = getByIndex(index);
            Item<T> newItem = new Item<>(element, current.previous, current);

            current.previous.next = newItem;
            current.previous = newItem;
        }
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(int index, final Collection<? extends T> c) {
        if (isEmpty()) {
            c.forEach(this::add);
        } else {
            for (T item : c) this.add(index++, item);
        }
        return true;
    }

    public void addFirst(final T element) {
        if (isEmpty()) {
            first = new Item<>(element, null, null);
            last = null;
        } else {
            final Item<T> newFirst = new Item<>(element, null, first);
            first.previous = newFirst;
            first = newFirst;
        }
    }

    public void addLast(final T element) {
        add(element);
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
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
        nullCheck(o);

        if (isEmpty()) return false;
        Item<T> current = first;

        while (current.next != null && !current.element.equals(o)) current = current.next;

        if (current.element.equals(o)) {
            removeCommon(current);
            return true;
        }
        return false;
    }

    @Override
    public T remove(final int index) {
        rangeCheckForAdd(index);

        Item<T> current = getByIndex(index);
        Item<T> currentPrevious = current.previous;

        if (current != null) {
            removeCommon(current);
            return current.element;
        }
        return null;
    }

    private void removeCommon(Item<T> current) {

        if (size == 1) {
            this.first = null;
            this.last = null;
        } else {
            if (current == first) {
                first = current.next;
                first.previous = null;
            } else if (current == last) {
                last = current.previous;
                last.next = null;
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
        }
        size--;
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
    public T get(final int index) {
        rangeCheckForAdd(index);
        return getByIndex(index).element;
    }

    @Override
    public T set(final int index, final T element) {
        rangeCheckForAdd(index);
        return getByIndex(index).element = element;
    }

    @Override
    public int indexOf(final Object o) {
        nullCheck(o);

        int currentIndex = 0;
        Item<T> current = first;

        while (current != null && !current.element.equals(o)) currentIndex++;
        if (current == null) return -1;

        return currentIndex;
    }

    @Override
    public int lastIndexOf(final Object o) {
        nullCheck(o);

        int currentIndex = size - 1;
        Item<T> current = last;

        while (current != null && !current.element.equals(o)) currentIndex--;
        if (current == null) return -1;

        return currentIndex;
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

    private Item<T> getByIndex(final int index) {
        rangeCheckForAdd(index);

        int currentIndex = 0;
        Item<T> current = first;
        while (currentIndex != index) {
            current = current.next;
            ++currentIndex;
        }
        return current;
    }

    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current;
        private Item<T> last;
        private int nextIndex;


        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            this.current = getByIndex(index);
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            last = current;
            current = current.next;
            return last.element;
        }

        @Override
        public boolean hasPrevious() {
            if (current == first) return false;
            return true;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            if (current == null) {
                current = last;
                last = null;
            } else {
                last = current.previous;
                current = current.previous;
            }
            return current.element;
        }

        @Override
        public int nextIndex() {
            return indexOf(current.element);
        }

        @Override
        public int previousIndex() {
            return indexOf(last);
        }

        @Override
        public void remove() {
            if (last == null) throw new IllegalStateException();
            LinkedList.this.remove(last);
            last = null;
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

    private void rangeCheckForAdd(final int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
    }

    private void nullCheck(final Object element) {
        if (null == element) throw new NullPointerException();
    }
}