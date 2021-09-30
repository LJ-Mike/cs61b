public class ArrayDeque<T> {
    private T[] elems;
    private int size;
    private int nextLast;
    private int nextFirst;

    /**
     * Default constructor
     */
    public ArrayDeque() {
        elems = (T[]) new Object[8]; // default size;
        size = 0;
        nextLast = elems.length / 2;
        nextFirst = (elems.length / 2) - 1;
    }

    /**
     * Copy constructor
     */
    public ArrayDeque(ArrayDeque other) {
        elems = (T[]) new Object[other.elems.length];
        size = other.size;
        nextLast = other.nextLast;
        nextFirst = other.nextFirst;
        System.arraycopy((T[]) other.elems, 0, elems, 0, other.elems.length);
    }

    public void addFirst(T item) {
        resize(); // check whether or not need to resize
        elems[nextFirst] = item;
        size++;
        nextFirst = getLeftIndex(nextFirst);
    }

    private int getLeftIndex(int currentNextFirst) {
        return (currentNextFirst - 1 + elems.length) % (elems.length);
    }

    public void addLast(T item) {
        resize(); // check whether or not need to resize
        elems[nextLast] = item;
        size++;
        nextLast = getRightIndex(nextLast);
    }

    private int getRightIndex(int currentNextLast) {
        return (currentNextLast + 1) % (elems.length);
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int count = 0;
        int current = getRightIndex(nextFirst);
        while (count++ < size) {
            System.out.print(elems[current] + " ");
            current = getRightIndex(current);
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        size--;
        int currentFirst = getRightIndex(nextFirst);
        T first = elems[currentFirst];
        elems[currentFirst] = null;
        nextFirst = currentFirst;
        resize();
        return first;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size--;
        int currentLast = getLeftIndex(nextLast);
        T last = elems[currentLast];
        elems[currentLast] = null;
        nextLast = currentLast;
        resize();
        return last;
    }

    /** Get Element at index */
    public T get(int index) {
        if (isEmpty() || index < 0 || index >= size()) {
            return null;
        }
        return elems[(nextFirst + 1 + index) % (elems.length)];
    }

    /** Resize array when size less than 0.25 of array length */
    private void resize() {
        boolean goBigger = (size == elems.length);
        boolean goSmaller = (elems.length > 16 && size > 0 && ((0.0 + elems.length) / size > 4.0));
        if (goBigger || goSmaller) {
            int newSize = size * 2;
            T[] newElements = (T[]) new Object[newSize];
            int currentFirst = getRightIndex(nextFirst);
            int currentLast = getLeftIndex(nextLast);
            int newNextFirst;
            int newNextLast;
            if (currentFirst < currentLast) {
                int length = currentLast - currentFirst + 1;
                System.arraycopy((T[])elems, currentFirst, newElements, (newSize / 2 - 1), length);
                newNextFirst = newSize / 2 - 2;
                newNextLast = (newSize / 2 - 1) + length;
            } else {
                int length1 = elems.length - 1 - currentFirst + 1;
                System.arraycopy((T[])elems, currentFirst, newElements, (newSize / 2 - 1), length1);
                int next = (newSize / 2 - 1) + length1;
                int length2 = currentLast - 0 + 1;
                System.arraycopy((T[])elems, 0, newElements, next, length2);
                newNextFirst = newSize / 2 - 2;
                newNextLast = (newSize / 2 - 1) + length1 + length2;
            }
            elems = newElements;
            nextFirst = newNextFirst;
            nextLast = newNextLast;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> f = new ArrayDeque<>();
        int count = 0;
        while (count++ < 20) {
            f.addLast(count);
            f.addFirst(count);
        }
        f.printDeque();
        while (count-- > 0) {
            f.removeLast();
            f.removeFirst();
        }
        f.printDeque();
    }
}
