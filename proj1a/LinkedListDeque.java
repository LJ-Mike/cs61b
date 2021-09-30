public class LinkedListDeque<T> {

    /** Class represent for Node of List*/
    public class Node {
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n) {
            this.item = i;
            this.prev = p;
            this.next = n;
        }
    }

    private Node sentinel;
    private int size;

    /** Default constructor */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Copy constructor */
    public LinkedListDeque(LinkedListDeque<T> other) {
        size = other.size;
        sentinel = new Node(other.sentinel.item, null, null);
        Node p = sentinel;
        Node i = other.sentinel.next;
        while (i != other.sentinel) {
            Node tmp = new Node(i.item, p, null);
            p.next = tmp;
            p = p.next;
            i = i.next;
        }
        p.next = sentinel;
        sentinel.prev = p;
    }

    public void addFirst(T item) {
        Node p = new Node(item, sentinel, null);
        p.next = sentinel.next;
        sentinel.next.prev = p;
        sentinel.next = p;
        size += 1;
    }

    public void addLast(T item) {
        Node p = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node first = sentinel.next;
        first.next.prev = sentinel;
        sentinel.next = first.next;
        size -= 1;
        return first.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node last = sentinel.prev;
        last.prev.next = sentinel;
        sentinel.prev = last.prev;
        size -= 1;
        return last.item;
    }

    public T get(int index) {
        if (isEmpty() || index >= size() || index < 0) {
            return null;
        }
        Node p = sentinel.next;
        while (index-- > 0) {
             p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (isEmpty() || index < 0 || index >= size()) {
            return null;
        }
        return get(sentinel.next, index).item;
    }

    private Node get(Node p, int index) {
        if (index == 0) {
            return p;
        } else {
            return get(p.next, index - 1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> i = new LinkedListDeque<>();
        i.addFirst(10);
        i.addLast(20);
        LinkedListDeque<Integer> i2 = new LinkedListDeque<>(i);
        i2.printDeque();
        System.out.println(i2.get(1));
    }
}
