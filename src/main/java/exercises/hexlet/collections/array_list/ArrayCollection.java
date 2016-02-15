package exercises.hexlet.collections.array_list;

import java.util.*;

/**
 * My own implementation of ArrayList
 */
public class ArrayCollection<T> implements List<T> {

    private T[] array = (T[]) new Object[1];

    private int size;

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
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
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(final Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        final T[] newArray = (T[]) new Object[this.size()];
        System.arraycopy(array, 0, newArray, 0, this.size());
        return newArray;
    }

    @Override
    public <R> R[] toArray(final R[] a) {
        if (a.length < size) return (R[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size);

        if (a.length > size) a[size] = null;
        return a;
    }

    @Override
    public boolean add(final T t) {
        if (size == array.length) {
            final T[] oldArray = array;
            array = (T[]) new Object[this.size() + 15];
            System.arraycopy(oldArray, 0, array, 0, oldArray.length);
        }
        array[size++] = t;
        return true;
    }

    @Override
    public void add(final int index, final T element) {
        rangeCheckForAdd(index);

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        nullCheck(c);

        for (final T item : c) add(item);

        return true;
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends T> c) {
        rangeCheckForAdd(index);
        nullCheck(c);

        Object[] a = c.toArray();
        int numNew = a.length;

        int numMoved = size - index;
        if (numMoved > 0) System.arraycopy(array, index, array, index + a.length, numMoved);

        System.arraycopy(a, 0, array, index, numNew);
        size += numNew;

        return false;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = size() - 1; i >= 0; i--) {
            if (array[i].equals(o)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(final int index) {
        final T element = array[index];
        if (index != this.size() - 1) System.arraycopy(array, index + 1, array, index, this.size() - index - 1);
        size--;
        return element;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        nullCheck(c);

        c.stream().forEach(this::remove);
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        nullCheck(c);

        this.stream().filter(item -> !c.contains(item)).forEach(this::remove);

        return true;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[1];
        size = 0;
    }

    @Override
    public T get(final int index) {
        rangeCheckForAdd(index);
        return array[index];
    }

    @Override
    public T set(final int index, final T element) {
        rangeCheckForAdd(index);
        T oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public int indexOf(final Object o) {
        nullCheck(o);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(final Object o) {
        nullCheck(o);
        for (int i = size; i > 0; i--) {
            if (array[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public List<T> subList(final int fromIndex, final int toIndex) {
        if (fromIndex < 0 || toIndex > size) throw new IndexOutOfBoundsException();
        else if (fromIndex > toIndex) throw new IllegalArgumentException();
        else if (fromIndex == toIndex) return new ArrayCollection<>();

        int range = toIndex - fromIndex;
        T[] tempArray = (T[]) new Object[1];

        System.arraycopy(array, fromIndex, tempArray, 0, range);

        return Arrays.asList(tempArray);
    }

    private class ElementsIterator implements ListIterator<T> {

        private int index = 0;

        private int last = -1;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return ArrayCollection.this.size > index;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            last = index;
            return ArrayCollection.this.array[index++];
        }

        @Override
        public boolean hasPrevious() {
            return index != 0;
        }

        @Override
        public T previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            last = previousIndex();
            index--;
            return ArrayCollection.this.array[last];
        }

        @Override
        public int nextIndex() {
            if (!hasNext()) return ArrayCollection.this.size();
            return ++index;
        }

        @Override
        public int previousIndex() {
            if (!hasPrevious()) return -1;
            return --index;
        }

        @Override
        public void remove() {
            if (last == -1) throw new IllegalStateException();
            ArrayCollection.this.remove(last);
            index--;
            last = -1;
        }

        @Override
        public void set(final T element) {
            if (last == -1) throw new IllegalStateException();
            ArrayCollection.this.set(last, element);
        }

        @Override
        public void add(final T t) {
            ArrayCollection.this.add(t);
        }
    }

    private void rangeCheckForAdd(final int index) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException();
    }

    private void nullCheck(final Object element) {
        if (null == element) throw new NullPointerException();
    }

}
