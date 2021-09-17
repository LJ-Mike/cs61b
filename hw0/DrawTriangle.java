public class DrawTriangle {
    public static void main(String[] args) {
        drawTriangle(10);
    }
    public static void drawTriangle(int height) {
        int x = 1;
        while (x <= height) {
            int y = x;
            while (y > 0) {
                System.out.print("*");
                y = y - 1;
            }
            System.out.println();
            x = x + 1;
        }
    }
}
