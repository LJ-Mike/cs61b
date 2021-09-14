public class SLLList {

    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;

    public SLLList() {
        sentinel = new IntNode(0, null);
        size = 0;
    }

    public SLLList(int x) {
        sentinel = new IntNode(0, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /**
     * Add a item in first of List
     * @param x int
     */
    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
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
     * Add the new IntNode to the last IntNode from p
     * @param p
     * @param x
     */
    private static void addLast(IntNode p, int x) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
        } else {
            addLast(p.next, x);
        }
    }

    /**
     * Add the last element to the list
     * @param x
     */
    public void addLast(int x) {
        size += 1;

        addLast(sentinel, x);
    }

    /**
     * Return the size of the list
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SLLList L = new SLLList();
        L.getFirst();
        L.addLast(10);
        L.addLast(20);

    }
}
