public class SquaringAList {
    /**
     * Using recursion with create new IntList
     * @param L
     * @return
     */
    public static IntList square(IntList L) {
        IntList ret = new IntList(L.first * L.first, null);
        IntList i = ret;
        while (L.rest != null) {
            i.rest = new IntList(L.rest.first * L.rest.first, null);
            L = L.rest;
            i = i.rest;
        }
        return ret;
    }

    /**
     * Use a recursive approach to change instance variable of input IntList
     * @param L
     * @return
     */
    public static IntList squareDestructive(IntList L) {
        IntList i = L;
        while (L != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }
        return i;
    }
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        IntList L = new IntList(20, null);
        L = new IntList(15, L);
        L = new IntList(5, L);
        L = new IntList(0, L);

        print(L);


        IntList test = square(L);

        print(L);

        print(test);
    }
    /**
     * Print IntList 
     * @param L
     */
    public static void print(IntList L) {
        while (L != null) {
            System.out.print(L.first + " ");
            L = L.rest;
        }
        System.out.println();
    }
}
