/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    private int[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length) {
            resize();
        }
        items[size++] = x;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return get(size - 1);
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;    
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        int last = getLast();
        items[size--] = 0;
        return last;
    }

    /** Resize array when the items is more than 100 (default size) */
    private void resize() {
        int[] newItems = new int[items.length * 2];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }
} 