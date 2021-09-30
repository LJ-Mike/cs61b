public class StaticMethodAndVariable {
    public String name;
    public static String noise;

    public StaticMethodAndVariable(String n, String n_) {
        this.name = n;
        this.noise = n_;
    }

    public void play() {
        System.out.println(noise + " I'm " + name + " the cat");
    }

    public static void anger() {
        noise = noise.toUpperCase();
    }

    public static void calm() {
        noise = noise.toLowerCase();
    }

    public static void main(String[] args) {
        /** Create new StaticMethodAndVariable object, assign noise static variable to Meow!*/
        StaticMethodAndVariable a = new StaticMethodAndVariable("Cream", "Meow!");
        /** Create new StaticMethodAndVariable object, assign noise static variable to Nyan!*/
        StaticMethodAndVariable b = new StaticMethodAndVariable("Tubbs", "Nyan!");
        /** print Nyan! I'm Cream the cat */
        a.play();
        /** print Nyan! I'm Tubbs the cat */
        b.play();
        /** Change noise static variable to NYAN! */
        StaticMethodAndVariable.anger();
        /** Change noise static variable to nyan! */
        a.calm();
        /** print nyan! I'm Cream the cat */
        a.play();
        /** print nyan! I'm Tubbs the cat */
        b.play();
    }
}
