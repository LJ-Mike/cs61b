public class MaxElementInArray {
    /**
     * Returns the maximum value in array
     * @param m array
     * @return
     */
    public static int max(int[] m) {
        int x = 1;
        int ret = m[0];
        while (x < m.length) {
            if (m[x] > ret) {
                ret = m[x];
            }
            x = x + 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] numbers = new int[] {9, 2, 15, 2, 22, 10, 6};
        int max = max(numbers);
        System.out.println("Maximum number in array is: " + max);
    }
}
