public class IntList {
    public int first;
    public IntList rest;
    /**
     * Constructor
     * @param f int
     * @param r IntList
     */
    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    /**
     * Using recursion
     * @return size of IntList
     */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + rest.size();
    }
    /**
     * Not using recursion
     * @return size of IntListt
     */
    public int iterativeSize() {
        IntList r = rest;
        int ret = 1;
        while (r != null) {
            ret = ret + 1;
            r = r.rest;
        }
        return ret;
    }
    /**
     * Using recursion
     * @param i index
     * @return IntList at index i
     */
    public IntList get(int i) {
        if (i == 0) {
            return this;
        }
        return rest.get(i - 1);
    }
    /**
     * Not using recursion
     * @param i index
     * @return IntList at index i
     */
    public IntList iterativeGet(int i) {
        IntList t = this;
        while (i > 0) {
            t = t.rest;
            i = i - 1;
        }
        return t;
    }

    public void addFirst(int x) {
        IntList i = new IntList(first, rest);
        first = x;
        rest = i;
    }
    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L.addFirst(10);
        L.addFirst(5);
    }
}
