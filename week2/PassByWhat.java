public class PassByWhat {
    public String name;
    public int level;

    public PassByWhat(String n, int l) {
        this.name = n;
        this.level = l;
    }

    public static void main(String[] args) {
        PassByWhat p = new PassByWhat("Pikachu", 17);
        int level = 100;
        change(p, level);
        System.out.println("Name: " + p.name + " Level: " + p.level);
    }

    public static void change(PassByWhat poke, int level) {
        poke.level = level;
        level = 50;
        poke = new PassByWhat("Gengar", 1);
    }
}

/**
 * What would java display: 
 *  Name: Pikachu Level 100
 * 
 * On line 19, we set level equal to 50.
 * This level is local variable in change() method
 */
