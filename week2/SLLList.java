public class SLLList {

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
    private IntNode sentinelB;

    public SLLList() {
        sentinel = new IntNode(0, null, null);
        sentinelB = new IntNode(0, null, sentinel);
        sentinel.next = sentinelB;
        size = 0;
    }

    public SLLList(int x) {
        sentinel = new IntNode(0, null, null);
        sentinel.next = new IntNode(x, null, sentinel);
        sentinelB = new IntNode(0, null, sentinel.next);
        sentinel.next.next = sentinelB;
        size = 1;
    }

    /**
     * Add a item in first of List
     * @param x int
     */
    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
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
        IntNode p = new IntNode(x, sentinelB, sentinelB.prev);
        sentinelB.prev.next = p;
        sentinelB.prev = p;
        size += 1;
    }

    /**
     * Return the size of the list
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLLList L = new SLLList();
        L.addFirst(20);
        L.addLast(5);
        L.addFirst(10);
        L.print();
        System.out.println(L.size());
    }

    public void print() {
        IntNode p = sentinel.next;
        while (p != sentinelB) {
            System.out.println(p.item);
             p = p.next;
        }
    }
}
