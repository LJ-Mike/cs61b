public class WindowPosSum {
    /**
     * Change value of all elements
     * @param m array
     * @param n number of elements
     */
    public static void windowPosSum(int[] m, int n) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] < 0) {
                continue;
            }
            int newValue = m[i];
            for (int j = 1; j <= n; j++) {
                if (i + j >= m.length) {
                    break;
                }
                newValue = newValue + m[i + j];
            }
            m[i] = newValue;
        }

    }
    public static void main(String[] args) {
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;

        windowPosSum(a, n);

        System.out.println(java.util.Arrays.toString(a));
    }
}
