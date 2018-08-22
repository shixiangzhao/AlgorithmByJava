package shixzh.abj.collection;

import java.util.*;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        clear();
    }

    public void clear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void ensureCapacity(int newCapacicy) {
        if (newCapacicy < theSize) {
            return;
        }

        T[] old = theItems;
        theItems = (T[]) new Object[newCapacicy];
        for (int i = 0; i < size(); i++) {
            theItems[i] = old[i];
        }
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void treamToSize() {
        ensureCapacity(size());
    }

    public T get(int idx) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public T set(int idx, T newVal) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public boolean add(T newVal) {
        add(size(), newVal);
        return true;
    }

    private void add(int idx, T newVal) {
        if (theItems.length == size())
            ensureCapacity(size() * 2 + 1);
        for (int i = size(); i < idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = newVal;
        theSize++;
    }

    public T remove(int idx) {
        T old = theItems[idx];
        for (int i = idx; i < size() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }
        theSize--;
        return old;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public static void main(String [] args) {
        List lst = Arrays.asList("12", "34");
    }
}
