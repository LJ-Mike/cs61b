public class Osmosis {
    public int first;
    public Osmosis rest;
    public Osmosis(int f, Osmosis r) {
        first = f;
        rest = r;
    }

    public void addAdjacent() {
        Osmosis p = this;
        while (p.rest != null) {
            if (p.first == p.rest.first) {
                p.first = p.first + p.first;
                p.rest = p.rest.rest;
                continue;
            }
            p = p.rest;
        }
    }
    public static void main(String[] args) {
        Osmosis L = new Osmosis(3, null);
        L = new Osmosis(2, L);
        L = new Osmosis(1, L);
        L = new Osmosis(1, L);
        L.addAdjacent();
    }
}
