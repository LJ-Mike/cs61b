public class DrawingATriangle {
    public static void main(String[] args) {
        int x = 1;
        while (x < 11) {
            int j = x;
            while (j > 0) {
                System.out.print("*");
                j = j -1;
            }
            System.out.println();
            x = x + 1;
        }
    }
}
