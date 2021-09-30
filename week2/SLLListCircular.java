public class SLLListCircular {

    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode prev;
        /**
         * 
         * @param i item value
         * @param next_ next Node
         * @param prev_ prev Node
         */
        public IntNode(int i, IntNode next_, IntNode prev_) {
            item = i;
            next = next_;
            prev = prev_;
        }
    }
    private IntNode sentinel;
    private int size;

    public SLLListCircular() {
        sentinel = new IntNode(0, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public SLLListCircular(int x) {
        sentinel = new IntNode(0, null, null);
        IntNode p = new IntNode(x, sentinel, sentinel);
        sentinel.next = p;
        sentinel.prev = p;
        size = 1;
    }

    /**
     * Add a item in first of List
     * @param x int
     */
    public void addFirst(int x) {
        size += 1;
        IntNode p = new IntNode(x, sentinel.next, sentinel);
        sentinel.next.prev = p;
        sentinel.next = p;
    }

    /**
     * 
     * @return int
     */
    public int getFirst() {
        if (size == 0) return 0;
        return sentinel.next.item;
    }

    /**
     * Add the last element to the list
     * @param x
     */
    public void addLast(int x) {
        IntNode p = new IntNode(x, sentinel, sentinel.prev);
        sentinel.prev.next = p;
        sentinel.prev = p;
        size += 1;
    }

    /**
     * Return the size of the list
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLLListCircular L = new SLLListCircular(100);
        L.addLast(5);
        L.addFirst(10);
        L.addFirst(20);
        L.print();
        System.out.println(L.size());
    }

    public void print() {
        IntNode p = sentinel.next;
        while (p != sentinel) {
            System.out.println(p.item);
             p = p.next;
        }
    }
}
