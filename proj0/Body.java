public class Body {
    /** List of instance variables */
    public double xxPos; // Its current x position
    public double yyPos; // Its current y position
    public double xxVel; // Its current velocity in the x direction
    public double yyVel; // Its current velocity in the y direction
    public double mass; // Its mass;
    public String imgFileName; // it corresponds with actual file name

    static final double G = 6.67e-11;

    /** List of constructors */
    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    /** Calulate the distance from this Body to another Body */
    public double calcDistance(Body b) {
        double dx = this.xxPos - b.xxPos;
        double dy = this.yyPos - b.yyPos;
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /** Calulate the force that exerted by another Body to this body */
    public double calcForceExertedBy(Body b) {
        final double r = calcDistance(b);
        return ( G * this.mass * b.mass) / (r * r);
    }

    /** Calculate the force that exerted by another to this Body in x direction */
    public double calcForceExertedByX(Body b) {
        final double F = calcForceExertedBy(b);
        final double r = calcDistance(b);
        final double dx = b.xxPos - this.xxPos;

        return (F * dx) / r;
    }

    /** Calculate the force that exerted by another to this Body in y direction */
    public double calcForceExertedByY(Body b) {
        final double F = calcForceExertedBy(b);
        final double r = calcDistance(b);
        final double dy = b.yyPos - this.yyPos;

        return (F * dy) / r;

    }

    /** Calculate the net force that exerted by list of Body to this body in x direction */
    public double calcNetForceExertedByX(Body[] bs) {
        double ret = 0.0;
        for (Body b : bs) {
            if (!this.equals(b)) {
                ret += calcForceExertedByX(b);
            }
        }
        return ret;
    }

    /** Calculate the net force that exerted by list of Body to this body in y direction */
    public double calcNetForceExertedByY(Body[] bs) {
        double ret = 0.0;
        for (Body b : bs) {
            if (!this.equals(b)) {
                ret += calcForceExertedByY(b);
            }
        }
        return ret;
    }

    /** Update velocity and position of the body when exerted by a force in a time */
    public void update(double time, double forceX, double forceY) {
        double aX = forceX / this.mass;
        double aY = forceY / this.mass;

        this.xxVel = xxVel + aX * time;
        this.yyVel = yyVel + aY * time;

        this.xxPos = this.xxPos + time * this.xxVel;
        this.yyPos = this.yyPos + time * this.yyVel;
    }

}
